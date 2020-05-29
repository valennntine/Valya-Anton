package com.example.JB.service;

import com.example.JB.model.*;
import com.example.JB.repos.UserRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BooksService booksService;

    @Autowired
    private RestaurantService restaurantService;


    @Autowired
    private MailSender mailSender;

    private Logger log = LogManager.getLogger();



    public boolean addUser(User user){
        User newUser = userRepo.findByUsername(user.getUsername());

        if(newUser != null){
            return false;
        }

        user.setActive(false);
        user.setRoles(Collections.singletonList(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);
        sendMessage(user);

        return true;
    }

    private void sendMessage(User user) {
        if(!user.getEmail().isEmpty() && user.getEmail()!=null){
            String message = String.format(
                    "Hello, %s!" +"\n" + " http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            mailSender.send(user.getEmail(),"Welcome to justBook ",message);
        }
    }

    public boolean activateUser(String code) {
        User user =  userRepo.findByActivationCode(code);

        if(user == null){
            return false;
        }
        user.setActive(true);
        user.setActivationCode(null);
        userRepo.save(user);
        return true;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }

    public User findByUsername(String name) {
        if(name != null && !name.isEmpty()) {
            log.info("User found");
            return userRepo.findByUsername(name);
        }else{
            log.warn("The name is invalid and null was returned");
            return null;
        }

    }

    public void updateProfile(User user, String password, String email) {
        String userEmail = user.getEmail();
        boolean isChanged = ((email != null && !email.equals(userEmail)) || (userEmail != null && !userEmail.equals(email)));
        if(isChanged){
            user.setEmail(email);

            if(!StringUtils.isEmpty(email)){
                user.setActivationCode(UUID.randomUUID().toString());
            }
        }
        if(!StringUtils.isEmpty(password)){
            user.setPassword(password);
        }
        userRepo.save(user);
        if(isChanged) {
            sendMessage(user);
        }

    }

    public List<TextClass> getProfile(User user) {
        List<Book> books = booksService.findAll();
        List<Restaurant> restaurants = new ArrayList<>();
        List<Book> newBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getUser().getId().equals(user.getId())) {
                newBooks.add(book);
                restaurants.add(book.getRestaurant());
            }
        }
        List<TextClass> textClasses = new ArrayList<>();
        for (int i = 0; i < newBooks.size(); i ++){
            textClasses.add(new TextClass());
            textClasses.get(i).setCodeWord(newBooks.get(i).getCodeWord());
            textClasses.get(i).setName(restaurants.get(i).getName());
            textClasses.get(i).setTime(newBooks.get(i).getTime());
            textClasses.get(i).setId(newBooks.get(i).getIdOfBook());
        }
        return textClasses;
    }

    public void deleteBook(Book book) {
        Restaurant restaurant = book.getRestaurant();
        restaurant.deleteBookOfRestaurant(book);
        restaurantService.plusPlace(restaurant);
        restaurantService.save(restaurant);
        booksService.delete(book);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s);
    }

    public boolean addTestUser(User user) {
        User newUser = userRepo.findByUsername(user.getUsername());

        if(newUser != null){
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singletonList(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);

        return true;
    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }
}

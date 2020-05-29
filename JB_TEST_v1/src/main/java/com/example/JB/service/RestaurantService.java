package com.example.JB.service;


import com.example.JB.model.Book;
import com.example.JB.model.Restaurant;
import com.example.JB.model.User;
import com.example.JB.repos.RestaurantRepo;
import com.example.JB.repos.UserRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class RestaurantService {



    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BooksService booksService;

    private RestaurantRepo restaurantRepo;

    private Logger log = LogManager.getLogger();

    @Autowired
    public RestaurantService(@Qualifier("RestaurantDao") RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    public Iterable<Restaurant> findAll(){
        return restaurantRepo.findAll();
    }

    public Restaurant findByName(String name){
        if(name != null && !name.isEmpty()) {
            log.info("Restaurant found");
            return restaurantRepo.findByName(name);
        }
        else{
            log.warn("There is no restaurant with that name");
            return null;
        }
    }

    public void save(Restaurant restaurant){
        if(restaurant != null && restaurantRepo.findByName(restaurant.getName()) == null){
            log.info("Restaurant added");
            restaurantRepo.save(restaurant);
        }else {
            log.warn("The restaurant already exists or the data is incorrect");
        }
    }

    public void delete(Restaurant restaurant){
        if(restaurant != null){
            log.info("Restaurant deleted");
            List<Book> list = booksService.findAll();
            for (Book book : list) {
                if (book.getRestaurant() == restaurant) {
                    booksService.delete(book);
                }
            }
            restaurantRepo.delete(restaurant);
        }else{
            log.warn("Restaurant not deleted");
        }
    }

    public void update(Restaurant restaurant, String name, String address,String description , String phoneNumber){
        if(restaurant != null && !name.isEmpty() && !address.isEmpty() && !description.isEmpty() && !phoneNumber.isEmpty()){
            restaurant.setName(name);
            restaurant.setAddress(address);
            restaurant.setDescription(description);
            restaurant.setPhoneNumber(phoneNumber);
            restaurantRepo.save(restaurant);
            log.info("Restaurant updated");
        }else{
            log.warn("The data is incorrect");
        }
    }

    public void minusPlace(Restaurant restaurant){
        if(restaurant != null && restaurant.getCountOfPlaces() > 0) {
            log.info("Number of seats in the " + restaurant.getName() + " reduced");
            restaurant.setCountOfPlaces(restaurant.getCountOfPlaces() - 1);
            restaurantRepo.save(restaurant);
        }else {
            log.warn("The data is incorrect or all the seats are occupied");
        }
    }

    public void plusPlace(Restaurant restaurant){
        if(restaurant != null ) {
            log.info("Number of seats in the " + restaurant.getName() + " increased");
            restaurant.setCountOfPlaces(restaurant.getCountOfPlaces() + 1);
            restaurantRepo.save(restaurant);
        }else {
            log.warn("The data is incorrect or all the seats are occupied");
        }
    }

    public List<Restaurant> findRestaurant(String name) {
        if(name != null && !name.isEmpty() ) {
            List<Restaurant> allRestaurants = (List<Restaurant>) this.findAll();
            List<Restaurant> restaurants = new ArrayList<>();
            for (Restaurant allRestaurant : allRestaurants) {
                if (allRestaurant.getName().toLowerCase().contains(name.toLowerCase())) {
                    restaurants.add(allRestaurant);
                }
            }
            return restaurants;
        }else{
            Iterable<Restaurant> restaurants = this.findAll();
            return (List<Restaurant>) restaurants;

        }
    }


    public Restaurant findById(long id) {
        return restaurantRepo.findById(id);
    }

    public boolean addBook(long id, String name, String dateAndTime, String codeWord, String phoneNumber, int countOfPeoples) {
        if(!dateAndTime.isEmpty() && !codeWord.isEmpty() && !phoneNumber.isEmpty() && countOfPeoples > 0 && countOfPeoples < 10 && this.findByName(name).getCountOfPlaces() > 0
        ){
            Book book= new Book();
            book.setNumberOfPeople(countOfPeoples);
            book.setCodeWord(codeWord);
            book.setPhoneNumber(phoneNumber);
            book.setTime(dateAndTime);
            this.minusPlace(this.findByName(name));
            Restaurant restaurant = restaurantRepo.findById(id);
            restaurant.addBookOfRestaurant(book);
            User user = userRepo.getOne(userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId());
            user.addBook(book);
            restaurantRepo.save(restaurant);
            userRepo.save(user);
            book.setRestaurant(restaurant);
            book.setUser(user);
            booksService.save(book);

            log.info("Booking was created");
            return true;
        }
        log.warn("Book was not created");
        return false;
    }

    public void addRestaurant(MultipartFile file, String name, String address, String description, String phoneNumber, int countOfPlaces, String uploadPath) throws IOException {
        if( !name.isEmpty() && !address.isEmpty() && !description.isEmpty() && !phoneNumber.isEmpty() && countOfPlaces > 0) {
            Restaurant restaurant = new Restaurant();
            restaurant.setName(name);
            restaurant.setAddress(address);
            restaurant.setDescription(description);
            restaurant.setPhoneNumber(phoneNumber);
            restaurant.setCountOfPlaces(countOfPlaces);
            if(file != null){
                File uploadDir = new File(uploadPath);
                if(!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String universalFileName = UUID.randomUUID().toString();
                String resultFileName =  universalFileName + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadPath + "/" + resultFileName));
                restaurant.setFilename(resultFileName);
            }
            this.save(restaurant);
        }
    }

    public boolean addBookForTests(User user,long id, String name, String dateAndTime, String codeWord, String phoneNumber, int countOfPeoples) {
        if(!dateAndTime.isEmpty() && !codeWord.isEmpty() && !phoneNumber.isEmpty() && countOfPeoples > 0 && countOfPeoples < 10 && this.findByName(name).getCountOfPlaces() > 0
        ){
            Book book = new Book();
            book.setNumberOfPeople(countOfPeoples);
            book.setCodeWord(codeWord);
            book.setPhoneNumber(phoneNumber);
            book.setTime(dateAndTime);
            this.minusPlace(this.findByName(name));
            Restaurant restaurant = restaurantRepo.findById(id);
            restaurant.addBookOfRestaurant(book);
            user.addBook(book);
            restaurantRepo.save(restaurant);
            userRepo.save(user);
            book.setRestaurant(restaurant);
            book.setUser(user);
            booksService.save(book);

            log.info("Booking was created");
            return true;
        }
        log.warn("Book was not created");
        return false;
    }
}
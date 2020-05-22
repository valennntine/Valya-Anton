package com.example.JB.controller;

import com.example.JB.model.*;
import com.example.JB.service.RestaurantService;
import com.example.JB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    RestaurantService restaurantService;


    @Autowired
    UserService userService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("All users: ", userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){
       userService.saveUser(user,username,form);
        return "redirect:/user";
    }



//    @GetMapping("profile")
//    public String getProfile(Model model, @AuthenticationPrincipal User user){
//        model.addAttribute("name", user.getUsername());
//        model.addAttribute("password",user.getPassword());
//        model.addAttribute("email",user.getEmail());
//
//        List<Book> books = new ArrayList<>();
//        List<Restaurant> restaurants = new ArrayList<>();
//        List<BooksParticipantsUser> booksParticipantsUsers = (List<BooksParticipantsUser>) bookParticipantsUserRepo.findAll();
//        for (BooksParticipantsUser booksParticipantsUser : booksParticipantsUsers) {
//            if (booksParticipantsUser.getUserId() == user.getId()) {
//                books.add(booksRepo.findByIdOfBook(booksParticipantsUser.getBookId()));
//                restaurants.add(restaurantService.findById(booksParticipantsUser.getRestaurantId()));
//            }
//        }
//        List<TextClass> textClasses = new ArrayList<>();
//        for (int i = 0; i < books.size(); i ++){
//            textClasses.add(new TextClass());
//            textClasses.get(i).setCodeWord(books.get(i).getCodeWord());
//            textClasses.get(i).setName(restaurants.get(i).getName());
//            textClasses.get(i).setTime(books.get(i).getTime());
//            textClasses.get(i).setId(books.get(i).getIdOfBook());
//        }
//        model.addAttribute("books", textClasses);
//        return "profile";
//    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("name", user.getUsername());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("email",user.getEmail());
        List<TextClass> textClasses =  userService.getProfile(user);
        model.addAttribute("books", textClasses);
        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @RequestParam String password,
                                @RequestParam String email){
        userService.updateProfile(user,password,email);

        return "redirect:/user/profile";
    }

    @GetMapping("delete")
    public String deleteBook(@RequestParam("bookId") Book book){
        userService.deleteBook(book);
        return "redirect:/user/profile";
    }
}

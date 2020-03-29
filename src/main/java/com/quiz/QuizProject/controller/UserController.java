package com.quiz.QuizProject.controller;

import com.quiz.QuizProject.domain.User;
import com.quiz.QuizProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/index")
    public String showUsers(Model model){

        List<User> userList = userService.findAll();

        model.addAttribute("users", userList);

        return "users/index";
    }

    @GetMapping(value = "/add")
    public String showAddForm(User user){

        return "users/add-user";
    }

    @PostMapping(value = "/add")
    public String addUser(User user, BindingResult result, Model model){

        userService.save(user);

        List<User> userList = userService.findAll();

        model.addAttribute("users", userList);

        return "users/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUserById(@PathVariable("id") int id, Model model){

        userService.deleteUserById(id);

        List<User> userList = userService.findAll();

        model.addAttribute("users", userList);

        return "users/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model){

        User user = userService.findOneById(id);

        model.addAttribute("user", user);

        return "users/update-user";
    }

    @PostMapping(value = "/edit")
    public String editUser(User user, Model model){

        userService.save(user);

        List<User> userList = userService.findAll();

        model.addAttribute("users", userList);

        return "users/index";

    }



}

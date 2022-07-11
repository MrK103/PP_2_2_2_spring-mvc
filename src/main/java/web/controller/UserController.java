package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

   @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String showUsers(@RequestParam(defaultValue = "0") int count, Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/user-create")
    public String showFormNewUser(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    private String saveUser(User user){
        userService.add(user);
        return "redirect:/user";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/user";
    }

    @GetMapping("/user-update/{id}")
    public String createUpdateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
       //merge
        userService.add(user);
        return "redirect:/user";
    }
}
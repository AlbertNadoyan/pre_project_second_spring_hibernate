package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/add")
    public String addUserPage(Model model) {
        model.addAttribute("user", new User());
        return "addUsers";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserPage(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}

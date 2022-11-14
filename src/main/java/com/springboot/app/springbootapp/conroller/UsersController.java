package com.springboot.app.springbootapp.conroller;

import com.springboot.app.springbootapp.model.User;
import com.springboot.app.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public String startPage() {
        return "index";
    }

    @GetMapping(value = "/users")
    public String showUsers(Model model) {
        model.addAttribute("listUsers", userService.listUsers());
        return "users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        userService.saveUser(user);
        return "result";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam(value = "id") Long id, User user, Model model) {
        model.addAttribute("user", user);
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String editUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
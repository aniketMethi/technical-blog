package st.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import st.model.User;
import st.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(@Valid User newuser){
        userService.registerUser(newuser);
        return "redirect:/users";

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUser(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/delete")
    public String deletePostSubmit(@RequestParam(name="id") Integer userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }

    @RequestMapping(value = "/userByName", method = RequestMethod.GET)
    public String getUserByName(@RequestParam(name = "name") String name , Model model){
        System.out.println("/***********************" + name+ "***************************/");
        List<User> users = userService.getAllUserByName(name);
        model.addAttribute("users", users);
        return "users";
    }







}

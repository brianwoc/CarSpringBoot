package pl.altkom.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.altkom.car.model.Car;
import pl.altkom.car.model.User;
import pl.altkom.car.repository.UsersRepositoryJpa;
import pl.altkom.car.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistryController {

    private UserService userService;
    private UsersRepositoryJpa usersRepositoryJpa;

    @Autowired
    public RegistryController(UserService userService, UsersRepositoryJpa usersRepositoryJpa) {
        this.userService = userService;
        this.usersRepositoryJpa = usersRepositoryJpa;
    }



//    @GetMapping("registry")
//    public String showRegistry(User user, @RequestParam(name = "userId", required = false) Long userId, Model model){
//        if (userId!= null){
//            User foundUser = usersRepositoryJpa.findById(userId).get();
//            user.setId((foundUser.getId()));
//            user.setUsername((foundUser.getUsername()));
//            user.setRole((foundUser.getRole()));
//            user.setEmail((foundUser.getEmail()));
//            user.setEnabled((foundUser.isEnabled()));
//        }
//
//        return "registry";
//    }
    @PostMapping("/registry")
    public String addUser(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "registry";
        }

        userService.addUser(user);
        return "redirect:/";

    }



    @GetMapping("/registry")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "registry";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.addUser(user);
        return "registry";
    }


}

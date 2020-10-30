package com.example.flightReservation.controller;

import com.example.flightReservation.repository.UserRepository;
import com.example.flightReservation.entity.User;
//import com.example.flightReservation.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    // @Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    // @Autowired
    // SecurityService securityService;

    //Method to direct you to the register user page
//    @RequestMapping("/registerUser")
//    public String showRegistration() {
//        return "login/registerUser";
//    }

    //directs to the login page
    @RequestMapping("/loginUser")
    public String showLogin() {
        return "login";
    }

    //saving the User
    @RequestMapping("/registerUser")
    public String register(@ModelAttribute User user,@RequestParam("lastName") String lastName,@RequestParam("gender")String gender) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword(lastName.toUpperCase());
        user.getGender(gender);
        userRepository.save(user);

        return "forms";
    }


    //Authenticating User login
  //  @PostMapping("login-user")
 //   public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
//        Boolean userExist = securityService.login(email,password);
//        if(userExist){
//            return "findFlights";
//        }
//        else{
//            modelMap.addAttribute("msg","Invalid credentials");
//        }
//        return "login/login";
   // }



    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){
        User user= userRepository.findByEmail(email);
        if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
            return "index";
        }
        else {
            modelMap.addAttribute("msg","Invalid Username or password.. Please try again");
        }
        return "login";
    }

}

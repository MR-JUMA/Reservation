package com.example.flightReservation.controller;

import com.example.flightReservation.repository.UserRepository;
import com.example.flightReservation.entity.User;
//import com.example.flightReservation.service.SecurityService;
import com.example.flightReservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;


    @RequestMapping("updateUser/{id}")
    public String updateFlight(@PathVariable("id")int id,User user,ModelMap modelMap){
        userRepository.save(user);
        List<User> hello=userRepository.findAll();
        modelMap.addAttribute("users",hello);

        return "viewUser";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteFlights(@PathVariable("id")int id, ModelMap modelMap){
        userRepository.deleteById((long) id);
        List<User> users= userRepository.findAll();
        modelMap.addAttribute("users",users);
        return "viewUser";
    }


    // @Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    // @Autowired
    // SecurityService securityService;

    //Method to direct you to the register user page
    @RequestMapping("/viewUser")
    public String viewUsers(ModelMap modelMap) {
        List<User> userList=userRepository.findAll();
        modelMap.addAttribute("users",userList);
        return "viewUser";
    }
    @GetMapping("/forms")
    public String addUser(@ModelAttribute("user")User user){
        return "addUser";
    }

    //directs to the login page
    @RequestMapping("/loginUser")
    public String showLogin() {
        return "login";
    }

    //saving the User
    @RequestMapping("/registerUser")
    public String register(@ModelAttribute("user") User user,@RequestParam("lastName") String lastName,
                           @RequestParam("gender")String gender) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword(lastName.toUpperCase());
//        user.setLastName(lastName);
//        user.setFirstName(firstName);
//        user.setMiddleName(middleName);
//        user.setEmail(email);user.getGender(gender);
        userRepository.save(user);

        return "addUser";
    }

    @RequestMapping("/editUser/{id}")
    public String editFlights(@PathVariable("id")int id, ModelMap modelMap){
        User user= userService.getUserById(id);
        modelMap.addAttribute("user",user);
        return "editUser";
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
            return "admin";
        }
        else {
            modelMap.addAttribute("msg","Invalid Username or password.. Please try again");
        }
        return "login";
    }

}

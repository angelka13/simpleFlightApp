package com.example.simpleapp.Controller;

import com.example.simpleapp.Model.User;
import com.example.simpleapp.Repository.UserRepository;
import com.example.simpleapp.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomUserDetailsService userService;

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList=userRepository.findAll();
        if(userList!=null){
            modelAndView.addObject("users",userList);
        }
        modelAndView.setViewName("allUsers");
        return modelAndView;
    }
    @RequestMapping("/getOne")
    @ResponseBody
   public Optional<User> getOne(String id){
        return userService.getOne(id);

   }
    @GetMapping(value = "/delete")
    public ModelAndView deleteUser(String id) {
        ModelAndView modelAndView = new ModelAndView();
        userRepository.deleteById(id);

        modelAndView.setViewName("delete");
        return modelAndView;
    }
    @RequestMapping(value = "/edit")
    public ModelAndView editUser() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("edit");
        return modelAndView;
    }
    @PostMapping("/save")
    public void save(User user){
       // ModelAndView modelAndView=
        userRepository.save(user);
       // retus
    }
}

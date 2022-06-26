package lv.venta.project.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.project.models.User;
import lv.venta.project.services.IUserService;



@Controller
@RequestMapping("/admin") //localhost:8080/admin
public class UserController {
	@Autowired
    private IUserService userService;

    @GetMapping("/user_all") //localhost:8080/admin/user_all
    public String AllUser(Model model) 
    {
        try {
            ArrayList<User> list= userService.getAllUsers();
            model.addAttribute("packageuser", list);
            return "user-all-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }
    @GetMapping("/user_all/{id}") //localhost:8080/admin/user_all/id
    public String UserById(@PathVariable(name = "id") int id, Model model) 
    {
        try {
            User temp = userService.getUserById(id);
            model.addAttribute("packageuserbyid", temp);
            return "user-by-id-page"; 
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }
    
    @GetMapping("/user_add") //localhost:8080/admin/user_add
    public String UserAdd(User temp)  {   
        return "user-add-page";
    }

    @PostMapping("/user_add") //localhost:8080/admin/user_add
    public String postUserAdd(@Valid User user, BindingResult result) { 
        if(!result.hasErrors()) {
            userService.insertNewUser(user);
            return "redirect:/admin/user_all/" + user.getUserID();
        } else {
            return "user-add-page";
        }
    }
	
    @GetMapping("/user_update/{id}") //localhost:8080/admin/user_update/id
    public String UserUpdate(@PathVariable(name="id") int id, Model model) {
        try {
            User temp = userService.getUserById(id);
            model.addAttribute("user", temp);
            return "user-update-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }
    
    @PostMapping("update/{id}") //localhost:8080/admin/user_update/id
    public String UserUpdate(@PathVariable(name="id") int id, @Valid User user, BindingResult result) { 
        if(!result.hasErrors()) {
            try {
                userService.updateUserById(id, user);
                return "redirect:/admin/user_all/" + id;
            } catch (Exception e) {
                return "redirect:/admin/user_all/";
            }
        } else {
            return "user-update-page";
        }
    }
    
    @GetMapping("/user_remove/{id}") //localhost:8080/admin/user_remove/id
    public String UserDelete(@PathVariable(name="id") int id, Model model) {
        try {
            userService.deleteUserById(id);
            model.addAttribute("packageuserdelete", userService.getAllUsers());
            return "user-all-page";
        } catch (Exception e) {
            e.printStackTrace();
            return "error-page";
        }
    }
	  
}

package com.skrekoza.tenders_spring;


import com.skrekoza.tenders_spring.DAO.DAO;
import com.skrekoza.tenders_spring.dmodel.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String greeting(Model model) {

        // For Annotation
        /*ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        DAO ops = new DAO();
        // get student based on search criteria
        ops.searchUser(mongoOperation, "email", "");

        model.addAttribute("users", dao.getAllUsers());*/
        return "hello";
    }

    @PostMapping("/hello")
    public String auth(@RequestParam(name="username", required = false, defaultValue = "-1") String username,
                       @RequestParam(name="password", required = false, defaultValue = "-1") String password,
                       Model model, HttpSession httpSession){
        System.out.println("Entered PostMapping");
        System.out.println("email = " + username + " password = " + password);
        DAO dao = new DAO();
        User user = dao.getUser(username, password);
        if(user == null){
            model.addAttribute("login_error", true);
            return "hello";
        }
        else{
            httpSession.setAttribute("user", user);
            model.addAttribute("user", user);
            return "redirect:/main";
        }
    }

}

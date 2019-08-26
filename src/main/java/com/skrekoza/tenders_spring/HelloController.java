package com.skrekoza.tenders_spring;


import com.skrekoza.tenders_spring.DAO.DAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String greeting(Model model) {
        DAO dao = new DAO();
        model.addAttribute("users", dao.getAllUsers());
        return "hello";
    }

}

package com.skrekoza.tenders_spring;

import com.skrekoza.tenders_spring.DAO.DAO;
import com.skrekoza.tenders_spring.dmodel.Tender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(Model model, HttpSession httpSession){
        model.addAttribute("user", httpSession.getAttribute("user"));

        return "main";
    }

    @PostMapping("/main")
    public String addTender(Model model, HttpSession httpSession,
                            @RequestParam(name="type", required = false) String type,
                            @RequestParam(name="price", required = false) String price,
                            @RequestParam(name="vault", required = false) String vault,
                            @RequestParam(name="step_size", required = false) String step_size,
                            @RequestParam(name="step_per", required = false) String step_per,
                            @RequestParam(name="subject", required = false) String subject,
                            @RequestParam(name="subject_det", required = false) String subject_det){
        System.out.println("Enter Main DoPost Method");
        System.out.println(type + " " + price + " " + vault + " " + step_size + " " + step_per + " " + subject + " " + subject_det);
        Tender tender = new Tender(type, Integer.parseInt(price), vault, Integer.parseInt(step_size), Integer.parseInt(step_per), subject);
        DAO dao = new DAO();
        try {
            dao.addTender(tender);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("user", httpSession.getAttribute("user"));
        return "main";
    }

}

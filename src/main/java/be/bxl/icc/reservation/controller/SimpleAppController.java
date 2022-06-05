package be.bxl.icc.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
class SimpleAppController {  
    @RequestMapping("/")  
    String home() {  
        return "home";  
    }  
}
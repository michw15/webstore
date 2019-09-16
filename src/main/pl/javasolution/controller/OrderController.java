package main.pl.javasolution.controller;

import main.pl.javasolution.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    String configLocation;
    ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
    @RequestMapping("/order/P1234/2")
    public String process(){
        orderService.processOrder("P1234",2);
        return "redirect:/products";
    }
}

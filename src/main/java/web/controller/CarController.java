package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.Service;

@Controller
public class CarController {
    @Autowired
    private Service carService;

    @GetMapping("/cars")
    public String showCars(@RequestParam(defaultValue = "0") int count, Model model) {
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}
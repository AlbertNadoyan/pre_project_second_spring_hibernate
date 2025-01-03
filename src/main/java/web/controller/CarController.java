package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;


    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(@RequestParam(name = "count", defaultValue = "5") int count, Model model) {
        List<Car> cars;
        if(count >= 5){
            cars = carService.getCars();
        }else {
            cars = carService.getCarsByCount(count);
        }
        model.addAttribute("cars", cars);
        return "cars";

    }
}

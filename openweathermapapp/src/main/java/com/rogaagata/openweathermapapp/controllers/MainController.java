package com.rogaagata.openweathermapapp.controllers;

import com.rogaagata.openweathermapapp.models.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;

@Controller
public class MainController {

    final WeatherService weatherService;

    @Autowired
    public MainController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String index(@RequestParam("cityName") String cityName,
                        Model model) {
        model.addAttribute("weather", weatherService.getWeather(cityName));
        return "index";

    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public String statusCode(HttpStatusCodeException http,
                             Model model) {
        model.addAttribute("apiError", http.getStatusCode());
        return "index";
    }
}

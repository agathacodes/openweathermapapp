package com.rogaagata.openweathermapapp.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    String apiKey;

    public WeatherDto getWeather(String cityName) {
        return getRestTemplate().getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey, WeatherDto.class);
    }
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

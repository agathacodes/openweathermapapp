package com.rogaagata.openweathermapapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {

    private WeatherTemp main;

    @Data
    public static class WeatherTemp{
        private double temp;

    }
}

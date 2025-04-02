package com.hiraru.mavenproject1.controller;

import com.hiraru.mavenproject1.dto.Weather;
import com.hiraru.mavenproject1.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping
    public ResponseEntity<Weather> getWeather(@RequestParam double lat, @RequestParam double lon) {
        return weatherRepository.findByLatitudeAndLongitude(lat, lon)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Weather addWeather(@RequestBody Weather weather) {
        return weatherRepository.save(weather);
    }
}
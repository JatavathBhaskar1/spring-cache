package com.bhaskar.spring_caching.controller;

import com.bhaskar.spring_caching.dto.FruitDto;
import com.bhaskar.spring_caching.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private DataService dataService;

    @CachePut("fruits")
    @GetMapping("fruit-list")
    public List<FruitDto> getFruitList() {
        log.info("Friuts list will be always as response and add to cache");
        return dataService.getFruitList();
    }

    @GetMapping("car-list")
    public List<String> getCar() {
        return dataService.getCarList();
    }

    @CacheEvict("car")
    @DeleteMapping("clear")
    public String clearCar(){
        log.info("car cache will be cleared");
        return "done";
    }
}



//echo "# spring-cache" >> README.md
//git init
//git add README.md
//git commit -m "first commit"
//git branch -M main
//git remote add origin https://github.com/JatavathBhaskar1/spring-cache.git
//git push -u origin main

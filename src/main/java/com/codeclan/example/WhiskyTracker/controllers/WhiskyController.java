package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping("/year/{year}")
    public List<Whisky> findAllWhiskyByYear(@PathVariable int year){
        return whiskyRepository.findAllWhiskyByYear(year);
    }

    @GetMapping("/distillery/{id}/{age}")
    public List<Whisky> findAllWhiskyByDistilleryIdAndAge(@PathVariable Long id, @PathVariable int age){
        return whiskyRepository.findAllWhiskeyByDistilleryIdAndAge(id,age);
    }

    @GetMapping("/region/{region}")
    public List<Whisky> getAllWhiskeyByRegion(@PathVariable String region){
        return whiskyRepository.getAllWhiskeyByRegion(region);
    }

    @GetMapping("/whiskyolderthan/{age}")
    public List<Distillery> getAllDistilleriesWithWhiskyOverAge(@PathVariable int age){
        return whiskyRepository.getAllDistilleriesWithWhiskyOverAge(age);
    }

}



/*
@RestController
@RequestMapping(value = "/raids")
public class RaidController {

    @Autowired
    RaidRepository raidRepository;

    @GetMapping
    public List<Raid> getAllRaids(){
        return raidRepository.findAll();
    }

    @GetMapping("/location/{location}")
    public List<Raid> findRaidByLocation(@PathVariable String location){
        return raidRepository.findRaidByLocation(location);
    }
}
 */
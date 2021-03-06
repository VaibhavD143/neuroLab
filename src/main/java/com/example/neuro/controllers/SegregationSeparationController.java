package com.example.neuro.controllers;

import com.example.neuro.beans.Master;
import com.example.neuro.beans.Test;
import com.example.neuro.beans.Vial;
import com.example.neuro.services.SegregationSeparationService;
import com.example.neuro.utils.TestCategoryEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/segregation")
public class SegregationSeparationController {

    @Autowired
    SegregationSeparationService segregationSeparationService;

    @PostMapping("/separateSample")
    public String separateSample(@RequestBody Master master) throws JsonProcessingException {
        return segregationSeparationService.separateSampleRest(master);
    }

    @GetMapping("/updateLockedCounter")
    public Test updateLockedCounter(@RequestParam String code, @RequestParam Integer lockedCounter){
        return segregationSeparationService.updateLockedCounterRest(code,lockedCounter);
    }

    @PostMapping("/updateLockedCounterWithVials")
    public Test updateLockedCounterWithVials(@RequestParam String code, @RequestParam Integer lockedCounter, @RequestBody List<Vial> vials){
        return segregationSeparationService.updateLockedCounterRest(code,lockedCounter,vials);
    }

    @GetMapping("/getTestListByCodeAndDate")
    public List<Vial> getTestListByCodeAndDate(@RequestParam String testCode, @RequestParam String date) {
        return segregationSeparationService.getTestListByCodeAndDateRest(testCode,date);
    }

    @GetMapping("/getPatientDetailByVLID")
    public Vial getPatientDetailByVLID(@RequestParam String vlid) throws JsonProcessingException {
        return segregationSeparationService.getPatientDetailByVLIDRest(vlid);
    }

    @GetMapping("/getTestListByCategoryAndDate")
    public String getTestListByCategoryAndDate(@RequestParam TestCategoryEnum testCategory,@RequestParam String date) throws JsonProcessingException {
        return segregationSeparationService.getTestListByCategoryAndDateRest(testCategory,date);
    }

    @PostMapping("/swapVialSerial")
    public List<Vial> swapVialSerial(@RequestBody String jsonString) throws JsonProcessingException {
        return segregationSeparationService.swapVialSerialRest(jsonString);
    }
}

package com.example.neuro.controllers;

import com.example.neuro.services.ReceiveStationPService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test/")
public class recieveStationPController {
    //spelling hoti hai recEIve.
    @Autowired
    ReceiveStationPService receiveStationPService;

    @GetMapping("/getNextXULID")
    public String getNextXULID(@RequestParam String sampleType){
        return receiveStationPService.getNextXULIDRest(sampleType);
    }

    @GetMapping("/getNextIULID")
    public String getNextIULID(@RequestParam String sampleType) { return receiveStationPService.getNextIULIDRest(sampleType); }

    @PostMapping("/storeXPatientDetail")
    public String storeXPatientDetail(@RequestBody String jsonString) throws JsonProcessingException {
        return receiveStationPService.storeXPatientDetailRest(jsonString);
    }

    @GetMapping("/test")
    public String test(){
        return receiveStationPService.incCounter("iCount");
    }
}

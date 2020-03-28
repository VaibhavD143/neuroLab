package com.example.neuro.service;

import com.example.neuro.beans.Master;
import com.example.neuro.beans.Sample;
import com.example.neuro.beans.ValidityList;
import com.example.neuro.repositories.SampleRepository;
import com.example.neuro.repositories.ValidityListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ValidityListService {
    @Autowired
    private ValidityListRepository validityListRepository;
    @Autowired
    private SampleRepository sampleRepository;

    public List<ValidityList> getValidityListsRest() {
        return validityListRepository.findAll();
    }

    public ValidityList getValidityListRest(Integer id) {
        return validityListRepository.getOne(id);
    }

    public ValidityList addValidityListRest(Integer sId) {
        ValidityList validityList = new ValidityList();
        validityList.setSample(sampleRepository.getOne(sId));
        return validityListRepository.save(validityList);
    }
    public ValidityList updateValidityListRest(ValidityList validityList) {
        return validityListRepository.save(validityList);
    }

    public void deleteValidityListRest(Integer id){
        Sample sample= validityListRepository.getOne(id).getSample();
        sample.setValidityList(null);
        sampleRepository.save(sample);
        validityListRepository.deleteById(id);
    }
}
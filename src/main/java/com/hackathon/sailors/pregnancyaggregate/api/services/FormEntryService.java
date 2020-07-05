package com.hackathon.sailors.pregnancyaggregate.api.services;

import com.hackathon.sailors.pregnancyaggregate.api.repo.FormsRepository;
import com.hackathon.sailors.pregnancyaggregate.models.DataEntryForm;
import com.hackathon.sailors.pregnancyaggregate.models.PregnantMotherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormEntryService {

    @Autowired
    private FormsRepository formsRepository;

    public DataEntryForm postData(DataEntryForm dataEntryForm) {
        return formsRepository.save(dataEntryForm);
    }

    public List<DataEntryForm> getAllForms(){
       return  formsRepository.findAll();
    }
}

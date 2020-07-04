package com.hackathon.sailors.pregnancyaggregate.api.services;

import com.hackathon.sailors.pregnancyaggregate.api.repo.PregnantMotherDataRepository;
import com.hackathon.sailors.pregnancyaggregate.models.PregnantMotherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PregnantMotherDataEntryService {

    @Autowired
    private PregnantMotherDataRepository pregnantMotherDataRepository;

    public PregnantMotherData postData(PregnantMotherData pregnantMotherData) {
        return pregnantMotherDataRepository.save(pregnantMotherData);
    }
}

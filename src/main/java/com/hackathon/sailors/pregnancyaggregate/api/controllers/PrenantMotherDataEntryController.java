package com.hackathon.sailors.pregnancyaggregate.api.controllers;

import com.hackathon.sailors.pregnancyaggregate.api.services.PregnantMotherDataEntryService;
import com.hackathon.sailors.pregnancyaggregate.models.ApiResponse;
import com.hackathon.sailors.pregnancyaggregate.models.PregnantMotherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PrenantMotherDataEntryController {

    @Autowired
    private PregnantMotherDataEntryService pregnantMotherDataEntryService;

    @PostMapping("/pregnancy")
    public ApiResponse<Void> postData(@RequestBody PregnantMotherData pregnantMotherData){
        PregnantMotherData pregnantMotherData1 = pregnantMotherDataEntryService.postData(pregnantMotherData);
        ApiResponse<Void> response = new ApiResponse<>();

        if(pregnantMotherData1 != null){
            response.setResultCode(0);
            response.setResultDescription("Data posted successfully");

        }else{
            response.setResultCode(1);
            response.setResultDescription("Error posting data");
        }

        return response;
    }
}

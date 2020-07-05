package com.hackathon.sailors.pregnancyaggregate.api.controllers;

import com.hackathon.sailors.pregnancyaggregate.api.services.FormEntryService;
import com.hackathon.sailors.pregnancyaggregate.models.ApiResponse;
import com.hackathon.sailors.pregnancyaggregate.models.DataEntryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataEntryFormControllerController {

    @Autowired
    private FormEntryService formEntryService;

    @PostMapping("/form")
    public ApiResponse<Void> postData(@RequestBody DataEntryForm dataEntryForm){
        DataEntryForm dataEntryForm1 = formEntryService.postData(dataEntryForm);
        ApiResponse<Void> response = new ApiResponse<>();

        if(dataEntryForm1 != null){
            response.setResultCode(0);
            response.setResultDescription("Data posted successfully");

        }else{
            response.setResultCode(1);
            response.setResultDescription("Error posting data");
        }

        return response;
    }
}

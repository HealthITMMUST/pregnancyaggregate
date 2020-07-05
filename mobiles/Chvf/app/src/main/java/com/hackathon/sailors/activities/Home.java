package com.hackathon.sailors.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hackathon.sailors.R;
import com.hackathon.sailors.models.ApiResponse;
import com.hackathon.sailors.models.DataEntryForm;
import com.hackathon.sailors.remoteAccess.RetrofitServiceInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    private EditText name, phoneNumber, pregnancyStage, age,location, district;
    private Button submitButton;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        progressDialog = new ProgressDialog(Home.this);
        progressDialog.setMessage("submitting data...");
        progressDialog.setCanceledOnTouchOutside(false);

        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phoneNumber);
        pregnancyStage = findViewById(R.id.pregnancy_stage);
        age = findViewById(R.id.age);
        location = findViewById(R.id.location);
        district = findViewById(R.id.district);
        submitButton = findViewById(R.id.submit_bt);
        submitButton.setOnClickListener(v -> submitDetails());
    }

    private void submitDetails() {

        String mName = name.getText().toString().trim();
        String mphoneNumber = phoneNumber.getText().toString().trim();
        String mPregnancyStage = pregnancyStage.getText().toString().trim();
        String mAge = age.getText().toString().trim();
        String mLocation = location.getText().toString().trim();
        String mDistrict = district.getText().toString().trim();
        if(TextUtils.isEmpty(mName) || TextUtils.isEmpty(mphoneNumber) || TextUtils.isEmpty(mPregnancyStage) || TextUtils.isEmpty(mAge) || TextUtils.isEmpty(mLocation) || TextUtils.isEmpty(mDistrict)){
            Toast.makeText(getApplicationContext(), "Please fill All the fields ", Toast.LENGTH_SHORT).show();
            return;
        }

        DataEntryForm form = new DataEntryForm(mName,mphoneNumber, mPregnancyStage,"",mLocation,mDistrict);
        progressDialog.show();

        RetrofitServiceInstance.getApi().postData(form).enqueue(new Callback<ApiResponse<Void>>() {
            @Override
            public void onResponse(Call<ApiResponse<Void>> call, Response<ApiResponse<Void>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Your Data was posted successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext() , Home.class));
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(),"There was a problem posting your data we will try again next time", Toast.LENGTH_SHORT ).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Void>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"There was a Technical "+t.getLocalizedMessage(), Toast.LENGTH_SHORT ).show();
                progressDialog.dismiss();
            }
        });

    }
}
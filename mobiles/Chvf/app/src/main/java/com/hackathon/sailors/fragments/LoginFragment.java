package com.hackathon.sailors.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.hackathon.sailors.R;
import com.hackathon.sailors.activities.Home;
import com.hackathon.sailors.activities.SplashScreen;
import com.hackathon.sailors.models.ApiResponse;
import com.hackathon.sailors.models.LoginDetails;
import com.hackathon.sailors.models.User;
import com.hackathon.sailors.preffs.Data;
import com.hackathon.sailors.remoteAccess.RetrofitServiceInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private TextView userName, password;
    private ProgressDialog progressDialog;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        userName = view.findViewById(R.id.user_name);
        password = view.findViewById(R.id.user_pass);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("verifying Credentials...");
        progressDialog.setCancelable(false);
        view.findViewById(R.id.login_bt).setOnClickListener(v -> login());
        
        return view;
    }

    private void login() {

        String mUserName = userName.getText().toString().trim();
        String mPassword = password.getText().toString().trim();


        if(TextUtils.isEmpty(mUserName)){
            Toast.makeText(getActivity(), "please enter username", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(mPassword)){
            Toast.makeText(getActivity(), "please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        LoginDetails loginDetails = new LoginDetails();
        loginDetails.setUsername(mUserName);
        loginDetails.setPassword(mPassword);
        progressDialog.show();

        RetrofitServiceInstance.getApi().login(loginDetails).enqueue(new Callback<ApiResponse<User>>() {
            @Override
            public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
                if(response.isSuccessful() && response.body() != null){
                    Data.setSidToken(getActivity().getSharedPreferences(SplashScreen.PREFS_SID, SplashScreen.MODE_PRIVATE), response.body().getData().getName());
                    showHome();
                }else{

                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "there was an error please try again", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Error "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void showHome() {
        startActivity(new Intent(getActivity(), Home.class));
        getActivity().finish();
    }
}

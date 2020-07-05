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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hackathon.sailors.R;
import com.hackathon.sailors.activities.Home;
import com.hackathon.sailors.models.ApiResponse;
import com.hackathon.sailors.models.User;
import com.hackathon.sailors.remoteAccess.RetrofitServiceInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    private TextView userName,email, password, confirmPassword;
    private ProgressDialog progressDialog;


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        userName = view.findViewById(R.id.user_name);
        email = view.findViewById(R.id.user_email);
        password = view.findViewById(R.id.user_pass);
        confirmPassword = view.findViewById(R.id.user_confirm_pass);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Creating your account...");
        progressDialog.setCancelable(false);
        view.findViewById(R.id.login_bt).setOnClickListener(v -> showLogin());
        view.findViewById(R.id.sign_up_bt).setOnClickListener(v -> signup());
        
        return view;
    }

    private void signup() {

        String mUserName = userName.getText().toString().trim();
        String mEmail = email.getText().toString().trim();
        String mPassword = password.getText().toString().trim();
        String mConfirmPassword = confirmPassword.getText().toString().trim();


        if(TextUtils.isEmpty(mUserName)){
            Toast.makeText(getActivity(), "please enter username", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(mEmail)){
            Toast.makeText(getActivity(), "please enter Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(mPassword)){
            Toast.makeText(getActivity(), "please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(mConfirmPassword)){
            Toast.makeText(getActivity(), "please enter password confirmation", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!mPassword.equals(mConfirmPassword)){
            Toast.makeText(getActivity(), "password confirmation must be same as password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.show();
        User user = new User();
        user.setName(mUserName);
        user.setEmail(mEmail);
        user.setPassword(mPassword);

        RetrofitServiceInstance.getApi().registerUser(user).enqueue(new Callback<ApiResponse<User>>() {
            @Override
            public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {

                Toast.makeText(getActivity(), "Account created successfully", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                showLogin();

            }

            @Override
            public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Error "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showLogin(){
       FragmentManager fm = getActivity().getSupportFragmentManager();
       FragmentTransaction transaction = fm.beginTransaction();
       transaction.replace(R.id.auth_layout_holder, new LoginFragment());
       transaction.commit();
   }
}

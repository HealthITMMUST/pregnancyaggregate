package com.hackathon.sailors.remoteAccess;


import com.hackathon.sailors.models.ApiResponse;
import com.hackathon.sailors.models.LoginDetails;
import com.hackathon.sailors.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("/api/register")
    Call<ApiResponse<User>> registerUser(@Body User user);


    @POST("/api/login")
    Call<ApiResponse<User>> login(@Body LoginDetails loginDetails);

//    @GET("/api/businesses?featured=true")
//    Call<Data> getFeaturedBussinesses();
//
//    @GET("/api/businesses/{id}")
//    Call<ReviewsApiResponse> getBussinessById(@Path("id") String id);
//
//   @POST("http://bcsb.co.ke/api/reviews")
//    Call<Review> postReview(@Body ApiReview review, @Header("Authorization") String authorization);
//
//    @GET("/api/businesses")
//    Call<Data> getBussinesses();
//
//    @POST("/api/password/reset/sendotp")
//    Call<Object> resetPassword(@Body ResetPasswordObject resetPasswordObject);
//
//    @POST("/api/password/reset/confirm")
//    Call<Object> confirmPasswordResetCode(@Body ConfirmResetCodeObject confirmResetCodeObject);
//
//    @POST ("/api/password/reset")
//    Call<Object> loginUserWithNewPassword(@Body NewPassHolderObject newPassHolderObject, @Header("Authorization") String authorization);

}

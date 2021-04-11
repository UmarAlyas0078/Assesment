package com.codesorbit.assesment.webservices;

import com.codesorbit.assesment.models.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroRequest {
    @GET("/posts")
    Call<List<PostResponse>> getPost();
}

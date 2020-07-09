package com.smile.service;

import com.smile.bo.DemoBO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;

public interface GitHubService {
  @GET("user/{user}")
  Call<List<DemoBO>> listRepos(@Path("user") String user) throws IOException;
}
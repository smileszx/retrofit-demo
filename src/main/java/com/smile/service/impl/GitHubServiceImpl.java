package com.smile.service.impl;

import com.smile.bo.DemoBO;
import com.smile.service.GitHubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author suzhengxiao
 * @date 2020/7/8 8:49 下午
 */
@Slf4j
@Service
public class GitHubServiceImpl implements GitHubService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8082/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    GitHubService service = retrofit.create(GitHubService.class);

    @Override
    public Call<List<DemoBO>> listRepos(String user) throws IOException {
        Call<List<DemoBO>> repos = service.listRepos(user);
        return repos;
    }
}

package com.smile.controller;

import com.smile.bo.DemoBO;
import com.smile.service.GitHubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author suzhengxiao
 * @date 2020/7/8 8:56 下午
 */
@Slf4j
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private GitHubService gitHubService;

    @RequestMapping("/user/{user}")
    public List<DemoBO> test (@PathVariable("user") String user) {
        List<DemoBO> list = new ArrayList<>();
        DemoBO demoBo = new DemoBO();
        demoBo.setId(1L);
        demoBo.setName(user);
        list.add(demoBo);

        return list;
    }

    @RequestMapping("/test")
    public List<DemoBO> ok () throws IOException {
        Call<List<DemoBO>> call = gitHubService.listRepos("suzhengxiao");
        Response<List<DemoBO>> execute = call.execute();
        log.info("查询结果: {}", execute.body());
        return execute.body();
    }
}

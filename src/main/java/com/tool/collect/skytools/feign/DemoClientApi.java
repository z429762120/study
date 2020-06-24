package com.tool.collect.skytools.feign;

import com.alibaba.fastjson.JSONObject;
import com.ywkj.base.bean.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/4/8 下午3:15
 **/
@FeignClient(url = "http://profile.ypzdw.info", name = "demoClientApi")
public interface DemoClientApi {
    @RequestMapping(value = "/profile/person/find",method = RequestMethod.GET,
            consumes = {"application/x-www-form-urlencoded"},
            produces = {"application/json;charset=UTF-8"})
    ResponseResult<List<JSONObject>> findPerson(@RequestParam("personIds") String personIds,
                                                                 @RequestHeader("token") String token);

}

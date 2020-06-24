package com.tool.collect.skytools.feign;

import com.alibaba.fastjson.JSONObject;
import com.ywkj.base.bean.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/4/8 下午3:15
 **/
@FeignClient(name = "testClientApi")
public interface TestClientApi {

    @RequestMapping(value = "/profile/person/find" ,method = RequestMethod.GET)
    ResponseResult<List<JSONObject>> findPersonInfo(@RequestParam("personIds") String personIds);


    @RequestMapping(value = "/profile/organization/find" ,method = RequestMethod.GET)
    ResponseResult<List<JSONObject>> findOrgInfo(@RequestParam("organizationIds") String organizationIds);
}

package com.xzy.data.desensitized.controller;

import com.xzy.data.desensitized.common.model.Result;
import com.xzy.data.desensitized.model.response.UserGetResponse;
import com.xzy.data.desensitized.model.response.UserListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xzy.xiao
 * @since 2024/12/25  17:13
 */
@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("/list")
    public Result<List<UserListResponse>> list() {
        List<UserListResponse> userList = new LinkedList<>();
        userList.add(new UserListResponse()
                .setUserId("10000001")
                .setChineseName("李云龙")
                .setIdCard("350721199611111219")
                .setFixedPhone("10086")
                .setMobilePhone("18860000000")
                .setAddress("中国北京海淀区上地十街10号")
                .setEmail("www.xzy@163.com")
                .setPassword("123abc,")
                .setCarLicense("粤B99N9A")
                .setBankCard("6231320000002541108")
                .setIpv4("183.247.147.172")
                .setIpv6("2001:db8:130F:0000:0000:9C0:876A:130B")
        );
        return Result.success(userList);
    }

    @PostMapping("/get")
    public Result<UserGetResponse> get() {
        return Result.success(new UserGetResponse()
                .setUserId("10000001")
                .setChineseName("李云龙")
                .setIdCard("350721199611111219")
                .setFixedPhone("10086")
                .setMobilePhone("18860000000")
                .setAddress("中国北京海淀区上地十街10号")
                .setEmail("www.xzy@163.com")
                .setPassword("123abc,")
                .setCarLicense("粤B99N9A")
                .setBankCard("6231320000002541108")
                .setIpv4("183.247.147.172")
                .setIpv6("2001:db8:130F:0000:0000:9C0:876A:130B")
        );
    }
}

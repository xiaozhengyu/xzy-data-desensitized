package com.xzy.data.desensitized.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzy.xiao
 * @since 2024/12/25  17:08
 */
@RestController
@RequestMapping("health")
public class HealthController {

    @RequestMapping("check")
    public String check() {
        return "xzy-data-desensitized-test";
    }
}

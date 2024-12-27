package com.xzy.data.desensitized;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xzy.xiao
 * @since 2024/12/23  13:48
 */
@SpringBootApplication(
        scanBasePackages = {"com.xzy.data.desensitized"}
)
public class XzyDataDesensitizedApplication {

    public static void main(String[] args) {
        SpringApplication.run(XzyDataDesensitizedApplication.class, args);
    }

}

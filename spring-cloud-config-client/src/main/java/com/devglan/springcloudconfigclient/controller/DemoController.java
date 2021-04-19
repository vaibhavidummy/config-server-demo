package com.devglan.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DemoController {

    @Value("${encrypted.property: default}")
    private String encrypted;

    @Value("${test.local.property:test}")
    private String testProperty;

    @RequestMapping("/")
    public String test() {
        StringBuilder builder = new StringBuilder();
        builder.append("encrypted property - ").append(encrypted).append(" || ")
                .append("local property - ").append(testProperty);
        return builder.toString();
    }
}

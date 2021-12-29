package com.fantasi.xxd.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxd
 * @date 2020/5/29 10:39
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/static")
    public String testStatic(){
        return SpringUtil.test();
    }
}

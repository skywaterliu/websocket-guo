package com.mafei.job.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jms on 2017/1/19.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }


}

package com.village.soa.web.controller;

import com.village.soa.service.domain.result.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenwei on 2016/11/26.
 */
@Controller
@RequestMapping(value = "/api/login")
public class LoginController {

    @RequestMapping(value = "/login")
    public BaseResult login() {

        return new BaseResult();
    }

}

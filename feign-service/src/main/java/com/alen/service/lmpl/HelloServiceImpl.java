package com.alen.service.lmpl;

import com.alen.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(Integer age) {
        return age+"失败";
    }
}

package cn.mldn.microcloud.controller;

import cn.mldn.vo.Dept;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ConsumerDeptController {
    public static final String DEPT_GET_URL = "http://127.0.0.1:8001/dept/get/";
    public static final String DEPT_LIST_URL = "http://127.0.0.1:8001/dept/list/";
    public static final String DEPT_ADD_URL = "http://127.0.0.1:8001/dept/add?dname=";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;

    @RequestMapping(value = "/consumer/dept/get")
    public Object getDept(long id) {
//		发送GET请求（getForObject()、getForEntity()、exchange()）
// http://rensanning.iteye.com/blog/2362105
        Dept dept = this.restTemplate
                .exchange(DEPT_GET_URL + id, HttpMethod.GET,
                        new HttpEntity<Object>(this.headers), Dept.class)
                .getBody();
        return dept;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public Object listDept() {
        List<Dept> allDepts = this.restTemplate
                .exchange(DEPT_LIST_URL, HttpMethod.GET,
                        new HttpEntity<Object>(this.headers), List.class)
                .getBody();
        return allDepts;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object addDept(Dept dept) throws Exception {
        Boolean flag = this.restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST,
                new HttpEntity<Object>(dept, this.headers), Boolean.class)
                .getBody();
        return flag;
    }
}

package cn.dubby.test.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangzheng03 on 2018/6/20.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Map hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        Map<String, String> result = new HashMap<>();
        result.put("name", name);
        result.put("server", "test.demo");
        return result;
    }

}

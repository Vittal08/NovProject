package com.ecommerce.novprojectecommerce.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class SampleController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
    @GetMapping("/bye")
    public String sayBye(){
        return "bye";
    }
}

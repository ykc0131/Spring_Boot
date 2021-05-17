package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")  //get방식 localhost:8080/hello 에서 hello부분일때 HelloController 사용
    public String hello(Model model){
        model.addAttribute("data","hello!"); //data부분을 "hello!" 할당

        return "hello"; //hello.html로 가는 것을 암시 (templates/hello.html)
        //viewName 매핑
        //'resources:templates/{viewName}.html
    }
}

package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")  //get방식 localhost:8080/hello 에서 hello부분일때 HelloController 사용
    public String hello(Model model){
        model.addAttribute("data","hello!"); //data부분을 "hello!" 할당

        return "hello"; //hello.html로 가는 것을 암시 (templates/hello.html)
        //viewName 매핑
        //'resources:templates/{viewName}.html
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        //RequestParam(value="name", required = true(default값) | true:값 받아야함 , false : 값 안 받아도 됨
        //name 값을 주기 위해서 hello-mvc?name=spring!!!  =>  '?' 사용

        model.addAttribute("name",name);
        return "hello-template";
    }

    // 과정
    // localhost:8080/hello-mvc => 내장 톰켓 서버
    // 1. helloController : GetMapping 있으면 실행 -> hello-template.html 실행
    // 2. hello-template.html : HTML 화면 출력

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;  //이때는 html 태그 없이 문자만 출력됨
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //Json 형태

    }
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}

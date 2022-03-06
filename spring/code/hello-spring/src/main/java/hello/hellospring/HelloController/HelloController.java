package hello.hellospring.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello"; // hello.html 여기로 가라
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    @GetMapping("hello-spring")
    @ResponseBody // body에 붙여서 데이터를 전송함
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring"

    }

    @GetMapping("hello-api")
    @ResponseBody // body에 붙여서 데이터를 전송함
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); // 객체 생성 후 반환
        hello.setName(name);
        return hello; // 객체 반환은 json 형태로 반환

    }

    static class Hello {
        private String name;

        public String getName() { // getter // 프로퍼티 접근 방식
            return name;
        }

        public void setName(String name) { // setter
            this.name = name;
        }
    }
}

package com.demo.message.Controller;

import com.demo.message.Model.Greeting;
import com.demo.message.Model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting send(HelloMessage hello, SimpMessageHeaderAccessor headerAccessor) throws Exception {
        Thread.sleep(10); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(hello.getName()) + "!");
    }


}

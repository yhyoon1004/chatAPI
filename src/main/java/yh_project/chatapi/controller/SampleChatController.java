package yh_project.chatapi.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import yh_project.chatapi.chat.SampleChatMessage;

@Controller
public class SampleChatController {
    @MessageMapping("/chat.sendMessage")//클라이언트로부터 메세지 수신
    @SendTo("/topic/public")//수신한 메세지를 public 채널로 송신
    public SampleChatMessage sendMessage(@Payload SampleChatMessage message) {
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public SampleChatMessage addUser(@Payload SampleChatMessage message) {
        message.setType(SampleChatMessage.MessageType.JOIN);
        return message;
    }

}

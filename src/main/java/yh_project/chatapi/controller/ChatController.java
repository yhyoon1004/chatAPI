package yh_project.chatapi.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import yh_project.chatapi.chat.ChatMessage;

@Controller
public class ChatController {
    @MessageMapping("/chat.sendMessage")//클라이언트로부터 메세지 수신
    @SendTo("/topic/public")//수신한 메세지를 public 채널로 송신
    public ChatMessage sendMessage(@Payload ChatMessage message) {
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage message) {
        message.setType(ChatMessage.MessageType.JOIN);
        return message;
    }

}

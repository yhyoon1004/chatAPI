package yh_project.chatapi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import yh_project.chatapi.chat.UserChatMessage;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat/{roomId}")
    public UserChatMessage userSendMessage(@Payload UserChatMessage message) {
//        messagingTemplate.convertAndSendToUser("");

        return message;
    }
}

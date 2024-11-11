package yh_project.chatapi.api;


import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import yh_project.chatapi.domain.chat.ChatMessage;
import yh_project.chatapi.domain.chat.ChatMessageRepository;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageRepository chatMessageRepository;

    @MessageMapping("/chat")
    public ChatMessage userSendMessage(@Payload ChatMessage message) {
        chatMessageRepository.save(message);
        System.out.println("message = " + message);
        System.out.println("saved!!!!");
        return message;
    }
}

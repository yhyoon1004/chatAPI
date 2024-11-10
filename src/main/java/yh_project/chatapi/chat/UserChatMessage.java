package yh_project.chatapi.chat;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserChatMessage {
    private String sender;
    private String message;
    private String receiver;
    private LocalDateTime createdAt;
}
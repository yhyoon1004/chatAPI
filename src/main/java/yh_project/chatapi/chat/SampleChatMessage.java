package yh_project.chatapi.chat;

import lombok.Data;


@Data
public class SampleChatMessage {
    private String sender;
    private String content;
    private MessageType type;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
    }
}

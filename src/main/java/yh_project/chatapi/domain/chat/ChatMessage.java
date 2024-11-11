package yh_project.chatapi.domain.chat;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
public class ChatMessage {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sender;
    private String receiver;
    @Lob
    private String message;
    private Timestamp sendDate;
}

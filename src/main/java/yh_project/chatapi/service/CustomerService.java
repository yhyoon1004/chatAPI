package yh_project.chatapi.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    public String createChatRoom() {
        String roomId = UUID.randomUUID().toString();
        return roomId;
    }
}

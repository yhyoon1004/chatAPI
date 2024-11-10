package yh_project.chatapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//@Configuration
//@EnableWebSocketMessageBroker   //메세지 브로커 활성화
public class SampleWebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * 웹소켓 연결후 통신할 채널 설정 (브로커 설정)
     * */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 활성화할 브로커 (=연결할 채널) 접두사 | topic = 브로드캐스트, queue = 특정 클라이언트 하나
        config.enableSimpleBroker("/topic", "/queue");
        // 클라이언트(채널 접속자)가 요청할 엔드포인트 접두사
        config.setApplicationDestinationPrefixes("/app");
    }
    /**
     * 웹소켓 연결을 위한 엔드포인트 설정
     * */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")//cors 설정
                .withSockJS();
    }
}

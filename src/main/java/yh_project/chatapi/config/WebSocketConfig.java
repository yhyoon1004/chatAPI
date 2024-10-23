package yh_project.chatapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker   //메세지 브로커 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    //메세지 브로커 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");    ///topic 채널로 브로커 설정
        config.setApplicationDestinationPrefixes("/app");   //어플리케이션 요청 uri 프리픽스 설정
    }
    //stomp 프로토콜 엔드포인트 설정
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")//cors 설정
                .withSockJS();
    }
}

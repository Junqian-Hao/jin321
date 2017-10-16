package com.jin321.ms.WebSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Tyranitarx on 2017/10/15.
 *
 * @Description : WebSocket配置
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class SpringWebSocketConfigure extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new PayBackEventHandler(),"/paybackeventhandler").addInterceptors(new WebSocketInterceptor());

    }
    @Bean
    public WebSocketHandler PayBackEventHandler(){
        return new PayBackEventHandler();
    }
}

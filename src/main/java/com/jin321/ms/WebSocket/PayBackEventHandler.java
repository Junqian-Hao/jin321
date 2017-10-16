package com.jin321.ms.WebSocket;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Tyranitarx on 2017/10/15.
 *
 * @Description :SOCKET握手拦截器
 */
public class PayBackEventHandler extends TextWebSocketHandler{
    private static final Log log = LogFactory.getLog(PayBackEventHandler.class);
    //session中存储的供应商登录信息
    private static final List<WebSocketSession> users;
    static {
        users=new ArrayList<WebSocketSession>();
    }
    //连接建立处理
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        users.add(session);
        log.info("商家编号"+session.getAttributes().get("did")+"已登录");
        super.afterConnectionEstablished(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
    }
    //收到远端信息
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("握手成功信息为："+message);
        super.handleTextMessage(session, message);
    }
    //关闭连接处理
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("商家编号"+session.getAttributes().get("did")+"已登出");
        super.afterConnectionClosed(session, status);
    }

    /**
     * 给某个用户发送消息
     *
     * @param did
     * @param message
     */
    public void sendMessageToUser(String did, TextMessage message) throws Exception{
        for (WebSocketSession user :users) {
            if (user.getAttributes().get("did").equals(did)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }
}

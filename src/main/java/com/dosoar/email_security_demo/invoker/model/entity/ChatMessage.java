package com.dosoar.email_security_demo.invoker.model.entity;

import com.dosoar.email_security_demo.invoker.model.param.ChatParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private ChatRole role;

    private String content;
}
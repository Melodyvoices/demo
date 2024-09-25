package com.dosoar.email_security_demo.invoker.model.param;

import com.dosoar.email_security_demo.invoker.model.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private List<ChatMessage> messages;

    private Integer max_tokens;

}

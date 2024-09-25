package com.dosoar.email_security_demo.invoker.model.response;

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
public class ChatResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String object;

    private Integer created;

    private String model;

    private List<Choice> choices;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice{
        private Integer index;

        private ChatMessage message;
    }
}

package com.dosoar.email_security_demo.invoker;

import com.alibaba.fastjson.JSONObject;
import com.dosoar.email_security_demo.invoker.model.param.ChatParam;
import com.dosoar.email_security_demo.invoker.model.response.ChatResponse;
import com.dosoar.email_security_demo.utils.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatModelInvoker {
    @Value("${common.llm.ai-chat-url}")
    private String llmAiChatUrl;

    public ChatResponse chat(ChatParam param) {
        ChatResponse response=new ChatResponse();
        String responseStr = HttpRequestUtils.jsonObjectPost(llmAiChatUrl, JSONObject.toJSONString(param));
        JSONObject obj = JSONObject.parseObject(responseStr);
        if (obj != null) {
           response.setObject(obj.getString("object"));
           response.setCreated(obj.getInteger("created"));
           response.setModel(obj.getString("model"));
            List<ChatResponse.Choice> choices=obj.getJSONArray("choices").toJavaList(ChatResponse.Choice.class);
        }
        return response;
    }
}

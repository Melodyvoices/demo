package com.dosoar.email_security_demo.invoker;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dosoar.email_security_demo.invoker.model.entity.ChatMessage;
import com.dosoar.email_security_demo.invoker.model.entity.ChatRole;
import com.dosoar.email_security_demo.invoker.model.param.ChatParam;
import com.dosoar.email_security_demo.invoker.model.response.ChatResponse;
import com.dosoar.email_security_demo.utils.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatModelInvoker {
    @Value("${common.llm.ai-chat-url}")
    private String llmAiChatUrl;

    public ChatResponse chat(ChatParam param) {
        ChatResponse response = new ChatResponse();
        String responseStr = HttpRequestUtils.jsonObjectPost(llmAiChatUrl, JSONObject.toJSONString(param));
        JSONObject obj = JSONObject.parseObject(responseStr);
        if (obj != null) {
            response.setObject(obj.getString("object"));
            response.setCreated(obj.getInteger("created"));
            response.setModel(obj.getString("model"));

            JSONArray jsonArray = obj.getJSONArray("choices");
            List<ChatResponse.Choice> choices = new ArrayList<>();
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    ChatResponse.Choice choice = new ChatResponse.Choice();
                    JSONObject choiceObj = jsonArray.getJSONObject(i);
                    if (choiceObj != null) {
                        choice.setIndex(choiceObj.getInteger("index"));
                        if (choiceObj.getJSONObject("message") != null) {
                            ChatMessage message = new ChatMessage();
                            message.setRole(ChatRole.valueOf(choiceObj.getJSONObject("message").getString("role")));
                            message.setContent(choiceObj.getJSONObject("message").getString("content"));
                            choice.setMessage(message);
                        }
                    }
                    choices.add(choice);
                }
            }
            response.setChoices(choices);

        }
        System.out.println(JSONObject.toJSONString(response));
        return response;
    }
}

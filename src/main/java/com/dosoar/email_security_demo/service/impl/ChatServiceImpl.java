package com.dosoar.email_security_demo.service.impl;

import com.dosoar.email_security_demo.invoker.ChatModelInvoker;
import com.dosoar.email_security_demo.invoker.model.entity.ChatMessage;
import com.dosoar.email_security_demo.invoker.model.entity.ChatRole;
import com.dosoar.email_security_demo.invoker.model.param.ChatParam;
import com.dosoar.email_security_demo.invoker.model.response.ChatResponse;
import com.dosoar.email_security_demo.model.entity.EmailStorage;
import com.dosoar.email_security_demo.service.IChatService;
import com.dosoar.email_security_demo.service.IEmailStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatServiceImpl implements IChatService {
    @Autowired
    private IEmailStorageService emailStorageService;

    @Autowired
    private ChatModelInvoker chatModelInvoker;

    @Override
    public String faqWhyAlert(String emailId) {
        EmailStorage emailStorage = emailStorageService.getById(emailId);
        if (emailStorage == null) {
            return null;
        }

        String emailTitle = emailStorage.getTitle() == null ? "空白" : "“" + emailStorage.getTitle() + "”";
        String emailContent = emailStorage.getContent() == null ? "" : emailStorage.getContent();
        String messageContent = "我收到了一封标题为" + emailTitle + "的邮件，请告诉我此邮件告警的原因，邮件内容如下：\n" + emailContent;

        ChatMessage message = new ChatMessage();
        message.setRole(ChatRole.user);
        message.setContent(messageContent);

        ChatParam chatParam = new ChatParam();
        List<ChatMessage> messages = new ArrayList<>();
        chatParam.setMessages(messages);
        chatParam.setMax_tokens(1024);

        List<ChatResponse.Choice> choices = chatModelInvoker.chat(chatParam).getChoices();
        if (choices == null || choices.isEmpty()) {
            return null;
        }
        ChatResponse.Choice choice = choices.get(0);
        if (choice == null) {
            return null;
        }
        return choice.getMessage() == null ? null : choice.getMessage().getContent();
    }
}

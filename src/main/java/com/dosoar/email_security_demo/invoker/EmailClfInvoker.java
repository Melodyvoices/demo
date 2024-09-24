package com.dosoar.email_security_demo.invoker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dosoar.email_security_demo.invoker.model.param.EmailClfParam;
import com.dosoar.email_security_demo.invoker.model.response.EmailClfResponse;
import com.dosoar.email_security_demo.utils.HttpRequestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;


@Service
public class EmailClfInvoker {
    @Value("${common.llm.verify-email-url}")
    private String llmVerifyEmailUrl;

    public EmailClfResponse emailClf(EmailClfParam param) {
        EmailClfResponse response = new EmailClfResponse();

        String responseStr = HttpRequestUtils.jsonObjectPost(llmVerifyEmailUrl, JSONObject.toJSONString( param));
        JSONObject obj = JSONObject.parseObject(responseStr);
        if (obj!=null) {
//            JSONObject result = obj.getJSONObject("result");
            response.setModelType(obj.getString("model_type"));
            response.setLabel(obj.getJSONArray("label").toJavaList(Integer.class));
            response.setProba(obj.getJSONArray("proba").toJavaList(Double.class));
            response.setText(obj.getJSONArray("text").toJavaList(String.class));
        }
        return response;
    }
}

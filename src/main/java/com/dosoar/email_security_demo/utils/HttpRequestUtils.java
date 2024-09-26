package com.dosoar.email_security_demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpRequestUtils {
    public static String jsonObjectPost(String requestUrl, String jsonStr) {
        String responseStr;
        HttpPost httpPost = new HttpPost(requestUrl);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000) // 设置连接超时时间，单位毫秒
                .setSocketTimeout(60000) // 设置请求获取数据的超时时间，单位毫秒
                .build();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setEntity(new StringEntity(jsonStr, ContentType.APPLICATION_JSON));

            HttpResponse httpResponse = httpClient.execute(httpPost);
            System.out.println("origin===================");
            System.out.println(JSONObject.toJSONString(httpResponse));
            HttpEntity responseEntity = httpResponse.getEntity();
            responseStr = EntityUtils.toString(responseEntity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return responseStr;
    }
}

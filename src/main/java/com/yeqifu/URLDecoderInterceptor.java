package com.yeqifu;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.logging.Logger;

public class URLDecoderInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求中的参数，并对其进行URL解码
         Logger logger = Logger.getLogger(URLDecoderInterceptor.class.getName());
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String[] values = entry.getValue();
            for (int i = 0; i < values.length; i++) {
                try {
                    String decodedValue = URLDecoder.decode(values[i], StandardCharsets.UTF_8.name());
                    values[i] = decodedValue;
                    logger.info("Decoded parameter: " + entry.getKey() + "=" + decodedValue);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    // 处理解码失败的情况
                }
            }
            // 将解码后的参数存储为请求属性
            request.setAttribute(entry.getKey(), values);
        }
        // 返回true表示继续执行后续的处理器（如Controller），返回false表示中断请求处理
        return true;
    }
}
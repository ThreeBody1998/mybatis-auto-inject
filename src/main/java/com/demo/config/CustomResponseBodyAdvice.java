package com.demo.config;

import com.demo.enums.HttpResultEnum;
import com.demo.pojo.custom.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * description  响应体处理类
 * @author 周建泽
 * @date 2023/10/21
 */
@RestControllerAdvice
@Slf4j
public class CustomResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {

        // 在这里对响应体进行处理，可以转换格式、加密等操作
        // 返回处理后的响应体
        try {
            ResponseResult<Object> responseResult = (ResponseResult<Object>) body;
            return responseResult.toJsonString();
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseResult<String>().setHttpResultEnum(HttpResultEnum.SERVER_ERROR).setMsg(e.getMessage()).toJsonString();
        }

    }
}

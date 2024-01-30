package com.demo.config;

import com.demo.enums.HttpResultEnum;
import com.demo.pojo.custom.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;


/**
  * @des valid注解参数校验统一异常处理
  * @date 2023/9/21
 */
@ControllerAdvice
@Slf4j
public class WebExceptionHandler {
    /**
     * 处理请求参数格式错误 @RequestBody上使用@Valid 实体上使用@NotNull等，验证失败后抛出的异常是MethodArgumentNotValidException异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResult<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return new ResponseResult<String>().setHttpResultEnum(HttpResultEnum.PARAM_IS_NULL).setMsg(message);
    }

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseResult<String> bindExceptionHandler(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return new ResponseResult<String>().setHttpResultEnum(HttpResultEnum.PARAM_IS_ERROR).setMsg(message);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseResult<String> constraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return new ResponseResult<String>().setHttpResultEnum(HttpResultEnum.PARAM_IS_ERROR).setMsg(message);
    }

    /**
     * 参数格式异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseResult<String> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        log.error(e.toString());
        return new ResponseResult<String>().setHttpResultEnum(HttpResultEnum.PARAM_NOT_VALID);
    }

    /**
     * 服务器异常
     * @param e 异常
     * @return  返回结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult<String> exceptionHandler(Exception e) {
        log.error(e.toString());
        return new ResponseResult<String>().setHttpResultEnum(HttpResultEnum.SERVER_ERROR);
    }

    /**
     * 请求方法错误
     * @param e 异常
     * @return  返回结果
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResponseResult<String> httpRequestMethodNotSupportedExceptionHandler(Exception e) {
        log.error("请求方法错误",e);
        return new ResponseResult<String>().setHttpResultEnum(HttpResultEnum.REQUEST_METHOD_ERROR);
    }

}

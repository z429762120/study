package com.tool.collect.skytools.support.exception;


import com.ywkj.base.bean.ResponseResult;
import com.ywkj.base.bean.ResponseResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String ERROR_MSG = "系统内部异常";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult exceptionHandler(HttpServletRequest req, Exception e) {
        log.error(ERROR_MSG, e);

        return ResponseResultFactory.build(1,e.getMessage());
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResponseResult bindExceptionHandler(HttpServletRequest req, BindException e) {

        List<FieldError> fieldErrors = e.getFieldErrors();
        StringBuilder errorBuilder = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            errorBuilder.append(fieldError.getDefaultMessage()).append(" ");
        }
        return ResponseResultFactory.build(1,errorBuilder.toString());
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResult methodArgumentNotValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        //log.error(e);
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder errorBuilder = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            errorBuilder.append(fieldError.getDefaultMessage()).append(" ");
        }
        return ResponseResultFactory.build(1,errorBuilder.toString());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ResponseResult constraintViolationExceptionHandler(HttpServletRequest req, ConstraintViolationException e) {
        //log.error( e);
        StringBuilder errorBuilder = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            PathImpl path = (PathImpl) violation.getPropertyPath();
            errorBuilder.append(path.getLeafNode().getName())
                    .append(":")
                    .append(violation.getMessage())
                    .append(" ");
        }
        return ResponseResultFactory.build(1,errorBuilder.toString());
    }

    private String getThrowType(Exception e) {
        StackTraceElement[] st = e.getStackTrace();
        StringBuilder builder = new StringBuilder("Class [");
        StackTraceElement element = st[0];
        builder.append(element.getClassName()).append("] Method [").append(element.getMethodName()).append("]");
        return builder.toString();
    }

    private Throwable rootCause(Exception ex) {
        Throwable rootCause = null;
        Throwable cause = ex.getCause();
        while (cause != null && cause != rootCause) {
            rootCause = cause;
            cause = cause.getCause();
        }
        return rootCause == null ? ex : rootCause;
    }
}

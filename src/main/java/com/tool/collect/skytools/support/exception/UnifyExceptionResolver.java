package com.tool.collect.skytools.support.exception;


import com.tool.collect.skytools.support.constant.ErrorCode;
import com.tool.collect.skytools.support.exception.annotation.TranslationScan;
import com.tool.collect.skytools.support.exception.translation.AbstractExceptionTranslation;
import com.tool.collect.skytools.support.exception.translation.DefaultTranslation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.MessageInterpolator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yangran
 * @create 2018/7/25
 */
@Slf4j
@Configuration
@ConditionalOnClass({LocalValidatorFactoryBean.class})
@TranslationScan("com.tool.collect.skytools.support.exception.translation")
public class UnifyExceptionResolver implements HandlerExceptionResolver {

    private AbstractExceptionTranslation defaultTranslation;
    private List<AbstractExceptionTranslation> translations;
    private String[] jsonp = {"callback","jsonp"};
    private Validator validator;
    private MessageInterpolator interpolator;

    public UnifyExceptionResolver(LocalValidatorFactoryBean validator, List<AbstractExceptionTranslation> translationList) {
        this.validator = validator;
        this.translations = null == translationList?new ArrayList<>():translationList;
        LocalValidatorFactoryBean validatorFactoryBean = validator;
        interpolator = validatorFactoryBean.getMessageInterpolator();
        defaultTranslation = new DefaultTranslation();
        defaultTranslation.setInterpolator(interpolator);
        translations.forEach(abstractExceptionTranslation -> abstractExceptionTranslation.setInterpolator(interpolator));
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TranslationContext translationContext = new TranslationContext(request, response, handler, ex, jsonp);
        return new ModelAndView(converToView(translationContext));
    }

    public AbstractView converToView(TranslationContext context) {
        AbstractView jsonView = null;
        for(AbstractExceptionTranslation translation : translations){
            if(translation.support(context.getException())){
                jsonView = translation.getView(context);
                break;
            }
        }
        if(null == jsonView){
            jsonView = defaultTranslation.getView(context);
        }
        //输出错误日志，只输出大于等于500的日志
        Map<String, Object> attributes = jsonView.getStaticAttributes();
        if(attributes != null && null != attributes.get("code")){
            Integer code = (Integer) attributes.get("code");
            if(code >= ErrorCode.Server.getCode()){
                log.error("【错误码{},统一异常组件捕捉的异常日志：{}】",code,EXPF.getExceptionMsg(context.getException()));
            }
        }
        return jsonView;
    }
}

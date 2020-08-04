package com.tool.collect.skytools.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/7/17 上午11:38
 **/
public class SpEL {

    public static void main(String[] args) {
        System.out.println(StringUtils.leftPad("510100".substring(2), 5, '0'));

        ExpressionParser parser = new SpelExpressionParser();
        //Expression expression = parser.parseExpression("#{T(Math).min(10,8)}",new TemplateParserContext());
        Expression expression = parser.parseExpression("T(Math).min(10,8)");
        EvaluationContext context = new StandardEvaluationContext();
        //context.setVariable("person", new Person().setUsername("张三"));
        System.out.println(expression.getValue(context));
    }
}

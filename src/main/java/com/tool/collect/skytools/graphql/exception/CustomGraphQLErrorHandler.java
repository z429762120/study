package com.tool.collect.skytools.graphql.exception;

import graphql.GraphQLError;
import graphql.servlet.DefaultGraphQLErrorHandler;
import graphql.servlet.GenericGraphQLError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Descriiption 自定义异常处理
 * @Author bo
 * @Date 2020/3/26 下午5:13
 **/
@Component
public class CustomGraphQLErrorHandler extends DefaultGraphQLErrorHandler {

    /**
     * 去除了默认的过滤逻辑，将异常信息转换为自己期望的类型，以便在页面展示
     * @param errors
     * @return
     */
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        List<GraphQLError> clientErrors = new ArrayList<>();
        for (GraphQLError clientError : errors) {
            GenericGraphQLError graphQLError = new GenericGraphQLError(clientError.getMessage());
            clientErrors.add(graphQLError);
            if (clientError instanceof Throwable) {
                log.error("Error executing query!", (Throwable)clientError);
            } else {
                log.error("Error executing query ({}): {}", clientError.getClass().getSimpleName(), clientError.getMessage());
            }
        }
        return clientErrors;
    }
}

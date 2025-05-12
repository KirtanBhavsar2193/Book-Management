package com.bookManagement.exceptions.handler;

import com.bookManagement.exceptions.DataNotFoundException;
import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handlerDataNotFoundException(DataNotFoundException ex) {
        return GraphQLError.newError()
                .message(ex.getMessage())
                .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError handlerGlobalException(Exception ex) {
        return GraphQLError.newError()
                .message(ex.getMessage())
                .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError handlerRunTimeException(RuntimeException ex) {
        return GraphQLError.newError()
               .message(ex.getMessage())
               .build();
    }
}

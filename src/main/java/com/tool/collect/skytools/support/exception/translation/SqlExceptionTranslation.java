package com.tool.collect.skytools.support.exception.translation;


import com.tool.collect.skytools.support.constant.ErrorCode;
import com.tool.collect.skytools.support.exception.TranslationContext;
import com.tool.collect.skytools.support.exception.annotation.ExpTranslation;
import com.tool.collect.skytools.support.springExtension.view.UnifyFailureView;
import org.springframework.web.servlet.view.AbstractView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库异常
 *
 * @author Gnoll
 * @create 2017-06-19 19:57
 **/
@ExpTranslation
public class SqlExceptionTranslation extends AbstractExceptionTranslation {
    private static List<Integer> ignoreSqlCode;

    public SqlExceptionTranslation() {
        ignoreSqlCode = new ArrayList<>();
        ignoreSqlCode.add(1062); // 悲观锁异常
        ignoreSqlCode.add(1213); // 悲观锁异常
    }

    @Override
    public boolean support(Exception ex) {
        return this.rootCause(ex) instanceof SQLException;
    }

    @Override
    public AbstractView translationToJson(TranslationContext context) {
        Throwable throwable = this.rootCause(context.getException());
        SQLException sqlException = (SQLException) throwable;
        AbstractView view = new UnifyFailureView();
        if (ignoreSqlCode.contains(sqlException.getErrorCode())) {
            view.addStaticAttribute(CODE, ErrorCode.Conflict.getCode());
            view.addStaticAttribute(THROWTYPE, getThrowtype(context.getException()));
            view.addStaticAttribute(MESSAGE, sqlException.getMessage());
        } else {
            view.addStaticAttribute(CODE, ErrorCode.Server.getCode());
            view.addStaticAttribute(THROWTYPE, getThrowtype(context.getException()));
            view.addStaticAttribute(MESSAGE, "Code [" + sqlException.getErrorCode() + "] Message [" + sqlException.getMessage() + "]");
        }
        return view;
    }
}

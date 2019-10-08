package com.tool.collect.skytools.support.utility;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 *
 * @author Gnoll
 * @create 2017-07-03 10:05
 **/
public class I18nMessageUtility {

    private MessageSource source;
    private Locale defaultLocale;

    public I18nMessageUtility(MessageSource source) {
        this.defaultLocale = Locale.SIMPLIFIED_CHINESE;
        this.source = source;
    }

    public String getMessage(String key) {
        return source.getMessage(key,null,defaultLocale);
    }

    public String getMessage(String key, Locale locale) {
        return source.getMessage(key,null,locale);
    }

    public String getMessage(String key, Object[] objects) {
        return source.getMessage(key,objects,defaultLocale);
    }
}

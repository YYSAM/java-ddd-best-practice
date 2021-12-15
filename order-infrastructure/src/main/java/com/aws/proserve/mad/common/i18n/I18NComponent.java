package com.aws.proserve.mad.common.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 国际化工具类
 */
@Component
public class I18NComponent {

    @Resource
    private MessageSource messageSource;

    /**
     * 获取单个国际化翻译值
     */
    public String get(String msgKey) {
        try {
            return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            return msgKey;
        }
    }

    public String getMessage(String msgKey, Object[] args) {
        return messageSource.getMessage(msgKey, args, LocaleContextHolder.getLocale());
    }
}
package com.aws.proserve.mad.common.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * 配置默认国际化语言
 */
@Configuration
public class I18NLocaleConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("messages");
        source.setUseCodeAsDefaultMessage(true);
        source.setDefaultEncoding("UTF-8");
        return source;
    }

}
package com.aws.proserve.mad.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

import static java.time.ZoneId.of;
import static java.util.TimeZone.getTimeZone;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.aws.proserve.mad.order", "com.aws.proserve.mad.common"})
public class OrderApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OrderApplication.class, args);

        log.info("Order Application is started!");
    }

    @PostConstruct
    void started() {
        TimeZone.setDefault(getTimeZone(of("Asia/Shanghai")));
    }
}

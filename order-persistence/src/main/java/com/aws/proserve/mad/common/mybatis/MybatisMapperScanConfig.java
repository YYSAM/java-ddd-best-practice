package com.aws.proserve.mad.common.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.aws.proserve.mad.common.event")
public class MybatisMapperScanConfig {
}

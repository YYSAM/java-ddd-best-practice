package com.aws.proserve.mad.common.trace;

import lombok.Value;

/**
 * 微服务线程变量全局类；
 * 可以按照需要进行扩展；
 */
@Value
public class TraceContext {
    private String traceId;
    private String userName;
}

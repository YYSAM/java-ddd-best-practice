package com.aws.proserve.mad.common.trace;

/**
 *
 */
public class TraceContextUtil {

    private static final ThreadLocal<TraceContext> context = new ThreadLocal<>();

    public static void set(TraceContext traceContext) {
        context.set(traceContext);
    }


    public static TraceContext get() {
       return context.get();
    }

    public static void remove() {
        context.remove();
    }
}

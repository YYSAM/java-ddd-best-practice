package com.aws.proserve.mad.common.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.util.ObjectUtils;

public class NotEmptyQueryWrapper<T> extends QueryWrapper<T>
        implements Query<QueryWrapper<T>, T, String> {


    public NotEmptyQueryWrapper<T> like(String column, Object param) {
        super.like(!ObjectUtils.isEmpty(param), column, param);
        return this;
    }

    public NotEmptyQueryWrapper<T> likeRight(String column, Object param) {
        super.likeRight(!ObjectUtils.isEmpty(param), column, param);
        return this;
    }

    public NotEmptyQueryWrapper<T> eq(String column, Object val) {
        super.eq(!ObjectUtils.isEmpty(val), column, val);
        return this;
    }
}

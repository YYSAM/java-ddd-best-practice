package com.aws.proserve.mad.order.application.service;

import com.aws.proserve.mad.order.application.dto.OrderDTO;

import java.util.List;

public interface OrderQueryService {

    List<OrderDTO> queryByCreatePersonId(Long createPersonId);
}

package com.aws.proserve.dip.order.application.service;

import com.aws.proserve.dip.order.application.dto.OrderDTO;

import java.util.List;

public interface OrderQueryService {

    List<OrderDTO> queryByCreatePersonId(Long createPersonId);
}

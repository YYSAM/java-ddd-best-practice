package com.aws.proserve.dip.common.application.service;

import com.aws.proserve.dip.common.application.dto.OrderDTO;

import java.util.List;

public interface OrderQueryService {

    List<OrderDTO> queryByCreatePersonId(Long createPersonId);
}

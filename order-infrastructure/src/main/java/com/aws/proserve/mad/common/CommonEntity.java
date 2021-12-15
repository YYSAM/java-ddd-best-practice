package com.aws.proserve.mad.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonEntity {

    /**
     * 公共属性；
     */
    private String createPersonCode;
    private String createPersonName;
    private LocalDateTime createTime;

    private String modifyPersonCode;
    private String modifyPersonName;
    private LocalDateTime modifyTime;

    private Status status;

    private Integer version;

}

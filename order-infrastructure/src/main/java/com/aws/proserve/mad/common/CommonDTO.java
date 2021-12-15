package com.aws.proserve.mad.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Common DTO", description = "Common DTO")
public class CommonDTO {

    @ApiModelProperty(notes = "创建人编码", name = "createPersonCode", dataType = "String", position = 1000)
    private String createPersonCode;
    @ApiModelProperty(notes = "创建人名称", name = "createPersonName", dataType = "String", position = 1001)
    private String createPersonName;
    @ApiModelProperty(notes = "创建时间", name = "createTime", position = 1002, dataType = "String", example = "2010-02-12 12:00:00")
    private String createTime;

    @ApiModelProperty(notes = "最后修改人编码", name = "lastModifyPersonCode", dataType = "String", position = 1003)
    private String lastModifyPersonCode;
    @ApiModelProperty(notes = "最后修改人名称", name = "lastModifyPersonName", dataType = "String", position = 1004)
    private String lastModifyPersonName;
    @ApiModelProperty(notes = "最后修改时间", name = "lastModifyTime", position = 1005, dataType = "String", example = "2010-02-12 12:00:00")
    private String lastModifyTime;

    @ApiModelProperty(notes = "状态", name = "status", position = 1006, dataType = "String", example = "[\"VALID\",\"INVALID\"]")
    private Status status;
    @ApiModelProperty(notes = "版本号", name = "version", position = 1007, dataType = "Integer", example = "1")
    private Integer version;
}

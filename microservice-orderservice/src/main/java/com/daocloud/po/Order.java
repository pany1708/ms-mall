package com.daocloud.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@ApiModel(value="订单对象",description="订单对象")
@Data
@ToString
public class Order {
    @ApiModelProperty(value="主键",name="id",example="1",hidden = true)
    private Integer id;
    @ApiModelProperty(value="编号",name="number",example="10002")
    private String number;
    @ApiModelProperty(value="用户编号",name="userid",example="1")
    private Integer userid;
    @ApiModelProperty(value="创建时间",name="time",hidden = true)
    private Date createtime;
}
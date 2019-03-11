package com.daocloud.po;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@ApiModel(value="订单对象",description="订单对象")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="主键",name="id",example="1",hidden = true)
	private Integer id;
	@ApiModelProperty(value="主键",name="username",example="james")
	private String username;
	@ApiModelProperty(value="主键",name="address",example="address")
	private String address;

}
package com.daocloud.controller;

import com.daocloud.mapper.UserMapper;
import com.daocloud.po.Order;
import com.daocloud.po.User;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Api
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserMapper userMapper;
	@Value("${ORDERSERVICEURL}")
	private String ORDERSERVICEURL;

	@ApiOperation(value = "获取用户订单信息", notes = "")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure")})
	@GetMapping(path="/findOrders/{username}")
	public List<Order> getOrderByUsername(@ApiParam(value = "用户名") @PathVariable("username")  String username) {
		LOG.info("username:"+username);
		User user = this.userMapper.selectUser(username);
		LOG.error("user:"+user);
		//使用Ribbon后，可以使用http://order-service/而不用使用ip+端口
		ResponseEntity<List<Order>> rateResponse =
			      restTemplate.exchange(ORDERSERVICEURL
					+"/order/findOrders/"+user.getId(),
					HttpMethod.GET, null, 
					new ParameterizedTypeReference<List<Order>>(){});
		List<Order> orders = rateResponse.getBody();
		return orders;
	}
}
package com.daocloud.controller;
import com.daocloud.mapper.OrderMapper;
import com.daocloud.po.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {
	private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderMapper orderMapper;

	@ApiOperation(value = "订单查询接口", notes = "")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure")})
	@GetMapping(path="/findOrders/{userid}")
	@HystrixCommand(fallbackMethod = "findOrderfallback") //断路器
	public List<Order> findOrder(@ApiParam("用户编号") @PathVariable("userid") Integer userid) {
		LOG.info("userId:"+userid);
		List<Order> orders=  this.orderMapper.selectOrder(userid);
		return  orders;
	}
	@ApiOperation(value = "订单保存接口", notes = "")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure")})
	@PostMapping(path="/saveOrder/")
	@HystrixCommand(fallbackMethod = "saveOrderfallback") //断路器
	public Order saveOrder(@RequestBody Order order){
		orderMapper.saveOrder(order);
		return orderMapper.selectOrderById(order.getId());
	}

	//针对上面断路器发现的问题编写回调方法（参数和返回值要一样）
	public List<Order> findOrderfallback(Integer userid) {
		LOG.info("userId:"+userid);
		List<Order> orders =new ArrayList<>();
		return orders;
	}

	//针对上面断路器发现的问题编写回调方法（参数和返回值要一样）
	public int saveOrderfallback(Order order) {
		LOG.info("order:"+order);
		List<Order> orders =new ArrayList<>();
		return 1;
	}
}
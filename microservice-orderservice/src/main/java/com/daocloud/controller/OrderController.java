package com.daocloud.controller;
import com.daocloud.mapper.OrderMapper;
import com.daocloud.po.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {
	private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderMapper orderMapper;

	@GetMapping(path="/findOrders/{userid}")
	@HystrixCommand(fallbackMethod = "findOrderfallback") //断路器
	public List<Order> findOrder(@PathVariable("userid") Integer userid) {
		LOG.info("userId:"+userid);
		List<Order> orders=  this.orderMapper.selectOrder(userid);
		return  orders;
	}
	//针对上面断路器发现的问题编写回调方法（参数和返回值要一样）
	public List<Order> findOrderfallback(Integer userid) {
		LOG.info("userId:"+userid);
		List<Order> orders =new ArrayList<>();
		return orders;
	}
}
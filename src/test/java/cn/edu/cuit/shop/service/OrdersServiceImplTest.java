package cn.edu.cuit.shop.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class OrdersServiceImplTest {
	
	private CountDownLatch start;
	
	private CountDownLatch end;

	
	@Autowired
	OrderItemService orderItemService;
	
	@Test
	public void test() throws InterruptedException {
		start = new CountDownLatch(1000);
		end = new CountDownLatch(20);
		ExecutorService exec = Executors.newFixedThreadPool(2000);
		for (int i = 0; i < 2000; i++) {
			exec.execute(new Task(orderItemService, start, end));
//			new Thread(new Task(orderItemService)).run();
//			start.countDown();
		}
//		exec.shutdownNow();
//		end.await();
//		Thread.sleep(500);
		System.out.println("success!");
	}
}

class Task implements Runnable {
	OrderItemService orderItemService;
	
//	CountDownLatch start;
//	
//	CountDownLatch end;
//	
	public Task(OrderItemService orderItemService, CountDownLatch start, CountDownLatch end) {
		this.orderItemService = orderItemService;
//		this.start = start;
//		this.end = end;
	}
	
	@Override
	public void run() {
//		try {
////			start.await();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("---" + orderItemService);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		orderItemService.update();
//		end.countDown();
		System.out.println("+++" + orderItemService);
		
	}
}


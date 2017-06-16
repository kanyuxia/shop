package cn.edu.cuit.shop.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import cn.edu.cuit.shop.service.impl.TestService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class Test1 {
	@Autowired
	private TestService testService;
	
	private CountDownLatch start = new CountDownLatch(1);
	private CountDownLatch end = new CountDownLatch(20);
	
	@Test
	@Rollback(false)
	public void test() throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		System.out.println(testService);
		for (int i = 0; i < 20; i++) {
			Task task = new Task(start, end, testService);
			executorService.execute(task);
		}
		start.countDown();
		end.await();
		System.out.println("success");
	}
	
	
}

class Task implements Runnable {
	private final CountDownLatch start;
	private final CountDownLatch end;
	private final cn.edu.cuit.shop.service.impl.TestService test;
	
	public Task(CountDownLatch start, CountDownLatch end, cn.edu.cuit.shop.service.impl.TestService test2) {
		super();
		this.start = start;
		this.end = end;
		this.test = test2;
	}

	@Override
	public void run() {
		try {
			start.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test.test();
		end.countDown();
	}
}

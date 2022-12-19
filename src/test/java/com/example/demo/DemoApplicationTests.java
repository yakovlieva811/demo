package com.example.demo;

import com.example.demo.controller.EmployeeController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private EmployeeController employeeController;

	@Test
	void contextLoads() {
		Assertions.assertThat(employeeController).isNotNull();
	}

}
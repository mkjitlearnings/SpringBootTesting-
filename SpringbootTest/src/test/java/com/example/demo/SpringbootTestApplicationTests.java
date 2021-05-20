package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dump.MyCalculator;

//@SpringBootTest
class SpringbootTestApplicationTests {

	@Test
	void doTestA() {
		MyCalculator calculator = new MyCalculator();
		
		// given
		int x = 10;
		int y = 20;
		
		//when
		int result = calculator.doAdd(x, y); 
		
		// then
		assertThat(result).isEqualTo(30);
	}

}

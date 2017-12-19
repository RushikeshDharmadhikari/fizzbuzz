package com.steerlean.fizzbuzz;

import mockit.Mocked;
import mockit.Verifications;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class AppTest {
	
	@Mocked
	NumberProcessor numberProcessor;
	
	@Test
	public void testStart() {
		App app = new App(numberProcessor);
		app.start();
		new Verifications() {{
			numberProcessor.processRange(1, 100, new ArrayList<String>());
			times=1;
		}};
	}
}

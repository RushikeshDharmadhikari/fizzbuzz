package com.steerlean.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.steerlean.fizzbuzz.rule.IRule;

import mockit.Expectations;
import mockit.Mocked;

public class NumberProcessorTest {
	
	@Mocked
	RuleEngine ruleEngine;
	
	@Test
	public void testProcessRange() {
		//ARRANGE
		new Expectations() {{
			ruleEngine.run(2);
			returns(2 + "");
			ruleEngine.run(3);
			returns(3 + "");
			ruleEngine.run(4);
			returns(4 + "");
		}};
		List<String> testString = new ArrayList<String>();
		//ACT
		NumberProcessor numberProcessor = new NumberProcessor(ruleEngine);
		numberProcessor.processRange(new Integer(2), new Integer(4), testString);
		
		//ASSERT
		Assert.assertEquals(testString.size(), 3);
		Assert.assertTrue(testString.contains("2"));
		Assert.assertTrue(testString.contains("3"));
		Assert.assertTrue(testString.contains("4"));
	
	}
}

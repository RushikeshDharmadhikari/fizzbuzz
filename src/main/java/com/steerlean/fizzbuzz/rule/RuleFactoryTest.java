package com.steerlean.fizzbuzz.rule;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class RuleFactoryTest {
	
	@Test
	public void createDivisibilityRuleTest() {
		RuleFactory ruleFactory = new RuleFactory();
		IRule sumOfDigitsDivisibility2 = ruleFactory.createDivisibilityRule(10, "processedString");
		DivisibilityRule divisibilityRule = new DivisibilityRule(10, "processedString");
		Assert.assertEquals(sumOfDigitsDivisibility2, divisibilityRule);
	}
	
	@Test
	public void createSumOfDigitsDivisibilityTest () {
		RuleFactory ruleFactory = new RuleFactory();
		SumOfDigitsDivisibility sumOfDigitsDivisibility = new SumOfDigitsDivisibility(10, "processedString");
		IRule iRule = ruleFactory.createSumOfDigitsDivisibility(10, "processedString");
		Assert.assertEquals(sumOfDigitsDivisibility, iRule);
	}
}

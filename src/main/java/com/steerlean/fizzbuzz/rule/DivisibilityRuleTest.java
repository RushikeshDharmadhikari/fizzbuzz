package com.steerlean.fizzbuzz.rule;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class DivisibilityRuleTest {
	@Test
	public void testNumberIsDivisible () {
		IRule divisibilityrule = new DivisibilityRule(2, "processedString");
		String parseString = divisibilityrule.parse(10);
		Assert.assertEquals(parseString, "processedString");
	}
	
	@Test
	public void testNumberIsNotDivisible() {
		IRule divisibilityrule = new DivisibilityRule(3, "processedString");
		String parseString = divisibilityrule.parse(10);
		Assert.assertEquals(parseString, "");
	}
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void testDivisorZero() {
		IRule divisibilityrule = new DivisibilityRule(0, "processedString");
		String parseString = divisibilityrule.parse(10);
	}
}

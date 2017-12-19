package com.steerlean.fizzbuzz.rule;

public class RuleFactoryStub extends RuleFactory {
	
	@Override
	public IRule createDivisibilityRule(int divisor, String processedString) {
		return null;
	}

	@Override
	public IRule createSumOfDigitsDivisibility(int divisor, String processedString) {
		return null;
	}
}

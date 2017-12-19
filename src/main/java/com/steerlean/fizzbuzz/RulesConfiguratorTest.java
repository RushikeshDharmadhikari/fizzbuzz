package com.steerlean.fizzbuzz;

import java.util.ArrayList;

import mockit.Expectations;
import mockit.*;
import java.util.List;
import org.testng.annotations.Test;
import com.steerlean.fizzbuzz.rule.IRule;
import com.steerlean.fizzbuzz.rule.RuleFactory;

import junit.framework.Assert;

public class RulesConfiguratorTest {
	
	@Mocked
	RuleFactory mockedRuleFactory;
	
	@Test
	public void testConfigure() {
		RuleFactory factory = new RuleFactory();
		List<IRule> rules = new ArrayList<IRule>();

		rules.add(factory.createDivisibilityRule(3, "Fizz"));

		rules.add(factory.createDivisibilityRule(5, "Buzz"));

		rules.add(factory.createSumOfDigitsDivisibility(6, "FiJazz"));

		rules.add(factory.createSumOfDigitsDivisibility(5, "BuJazz"));
		
		Assert.assertEquals(rules, new RulesConfigurator(factory).configure());

	}
	
	@Test
	public void testConfigure1(@Mocked final IRule dummyDivisibilityRule1, @Mocked final IRule dummyDivisibilityRule2, @Mocked final IRule dummyDivisibilityRule3, @Mocked final IRule dummyDivisibilityRule4) {
		//ARRANGE
		new Expectations() {{
			mockedRuleFactory.createDivisibilityRule(3, "Fizz");
			returns(dummyDivisibilityRule1); 
			mockedRuleFactory.createDivisibilityRule(5, "Buzz");
			returns(dummyDivisibilityRule2);
			mockedRuleFactory.createSumOfDigitsDivisibility(6, "FiJazz");
			returns(dummyDivisibilityRule3);
			mockedRuleFactory.createSumOfDigitsDivisibility(5, "BuJazz");
			returns(dummyDivisibilityRule4);
		}};
		
		//ACT
		RulesConfigurator rulesConfigurator = new RulesConfigurator(mockedRuleFactory);
		List<IRule> iRules = rulesConfigurator.configure();
		
		//ASSERT
		Assert.assertEquals(4, iRules.size());
		Assert.assertEquals(iRules.get(0), dummyDivisibilityRule1);
		Assert.assertEquals(iRules.get(1), dummyDivisibilityRule2);
		Assert.assertEquals(iRules.get(2), dummyDivisibilityRule3);
		Assert.assertEquals(iRules.get(3), dummyDivisibilityRule4);
	}
}

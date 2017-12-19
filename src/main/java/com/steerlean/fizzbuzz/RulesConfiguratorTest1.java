package com.steerlean.fizzbuzz;

import java.util.List;
import org.testng.annotations.Test;
import com.steerlean.fizzbuzz.rule.IRule;
import com.steerlean.fizzbuzz.rule.RuleFactoryStub;

import junit.framework.Assert;

public class RulesConfiguratorTest1 {
	RuleFactoryStub ruleFactoryStub = new RuleFactoryStub();
	
	@Test
	public void testConfigure() {
		RulesConfigurator rulesConfigurator = new RulesConfigurator(ruleFactoryStub);
		List<IRule> iRules = rulesConfigurator.configure();
		Assert.assertEquals(4, iRules.size());
		Assert.assertEquals(iRules.get(0), null);
		Assert.assertEquals(iRules.get(1), null);
		Assert.assertEquals(iRules.get(2), null);
		Assert.assertEquals(iRules.get(3), null);
	}
}

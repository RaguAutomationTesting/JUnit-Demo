package org.suiteexecution;

import org.junit.Test;

import junit.framework.Assert;

public class A {
	@Test
	public void tc1() {
		System.out.println("Test 1");

	}
	
	@Test
	public void tc3() {
		System.out.println("Test 3");

	}
	@Test
	public void tc2() {
		Assert.assertTrue("assertion failure", false);
		System.out.println("Test 2");

	}

}

package org.pract;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Demo {
	@BeforeClass
	public static void loadBrowser() {
		System.out.println("launch browser");

	}

	@Before
	public void startTime() {
		System.out.println("start time");

	}

	@Test
	public void tc1() {
		System.out.println("testcase");

	}

	@After
	public void endTime() {
		System.out.println("end Time");

	}

	@AfterClass
	public static void quitBrowser() {
		System.out.println("quit browser");

	}
}

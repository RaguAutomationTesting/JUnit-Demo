package org.suiteexecution;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner1 {
	@Test
	public void tc1() {
		Result r = JUnitCore.runClasses(A.class, B.class, C.class);

		System.out.println("Execution metrics");
		System.out.println("Run Count: " + r.getRunCount());
		System.out.println("Ignore Count: " + r.getIgnoreCount());
		System.out.println("Failure Count: " + r.getFailureCount());
		System.out.println("Run time: " + r.getRunTime());

		List<Failure> failures = r.getFailures();
		System.out.println(failures.size());

		for (Failure failure : failures) {
			System.out.println(failure);

		}

	}

}

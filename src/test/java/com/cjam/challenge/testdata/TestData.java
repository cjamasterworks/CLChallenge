package com.cjam.challenge.testdata;

import com.cjam.challenge.model.employee.Developer;
import com.cjam.challenge.model.employee.IEmployee;
import com.cjam.challenge.model.employee.Manager;
import com.cjam.challenge.model.employee.QATester;

/**
 * Common test data.
 * 
 * @author Christopher J Jones
 *
 */
public class TestData {

	/**
	 * This is the specific scenario given as an example in the challenge documentation to solve.
	 * 
	 * @return challenge scenario test data.
	 */
	public static IEmployee getChallengeScenario() {
		// Let's say this level is dept 1
		Manager managerB = new Manager(111, 1); // 300
		managerB.addDirectReport(new Developer(112, 1)); // 1000
		managerB.addDirectReport(new QATester(113, 1)); // 500

		// Let's say this level is dept 2
		Manager managerA = new Manager(200, 2); // 300
		managerA.addDirectReport(managerB);

		return managerA;
	}

	/**
	 * Generic Scenario 1 with mixed departments at various levels.
	 * 
	 * @return scenario 1 test data.
	 */
	public static IEmployee getScenario1() {

		Manager managerC = new Manager(127, 1); // 300
		managerC.addDirectReport(new Developer(135, 2)); // 1000
		managerC.addDirectReport(new QATester(422, 4)); // 500

		Manager managerB = new Manager(155, 1);// 300
		managerB.addDirectReport(managerC); // Included above
		managerB.addDirectReport(new QATester(155, 1)); // 500

		Manager managerA = new Manager(234, 2);// 300 - conditionally included
		managerA.addDirectReport(managerB);// Included above
		managerA.addDirectReport(new Developer(334, 3)); // 1000

		return managerA;
	}

	/**
	 * Generic Scenario 2 - Variation on Scenario 1.
	 * 
	 * @return scenario 2 test data.
	 */
	public static IEmployee getScenario2() {

		Manager managerC = new Manager(166, 1); // 300
		managerC.addDirectReport(new Developer(135, 1));// 1000

		Manager managerB = new Manager(134, 1);// 300
		managerB.addDirectReport(managerC);// included above

		Manager managerA = new Manager(297, 2); // 300 - conditionally included
		managerA.addDirectReport(managerB); // included above
		managerA.addDirectReport(new QATester(354, 3));// 500
		managerA.addDirectReport(new Developer(388, 3));// 1000

		return managerA;
	}
}

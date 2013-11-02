package toos2;

import java.util.ArrayList;

public class TestCensus {

	public static boolean test(Census toTest) {
		boolean result = true;
		try {
			ArrayList<Voter> voters = null;
			result = result && toTest.voting(voters);
			voters = new ArrayList<Voter>();
			result = result && toTest.voting(voters);
			voters.add(null);
			result = result && toTest.voting(voters);
			voters.add(new Voter(true));
			result = result && toTest.voting(voters);
			voters.add(new Voter(false));
			result = result && !toTest.voting(voters);
		} catch (Exception e) {
			System.err.println(e.toString());
			result = false;
		}
		return result;
	}

	public static void main(String[] args) {

		ArrayList<Census> toTest = new ArrayList<Census>();
		toTest.add(new Census1());
		toTest.add(new Census2());
		toTest.add(new Census3());
		toTest.add(new Census4());
		toTest.add(new Census5());
		toTest.add(new Census6());

		for (Census c : toTest) {
			if (test(c)) {
				System.out.println("Succes on " + c.toString());
			} else {
				System.out.println("Fail on " + c.toString());
			}
		}

	}

}

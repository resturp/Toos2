package toos2;

import java.util.ArrayList;

public class TestCensus {

	private static String run(String testName, ArrayList<Voter> voters,
			Census toTest, boolean expect, boolean exception) {

		if (voters != null) {
			for (Voter v : voters) {
				if (v != null) {
					v.resetVoted();
				}
			}
		}
		try {
			boolean result = toTest.voting(voters);
			if (exception) {
				return ("Failed: missing exception in " + testName + " on " + toTest
						.toString());
			}
			if (voters != null) {
				for (Voter v : voters) {
					if (v != null) {
						if (v.getVoted() == 0) {
							return ("Failed: at least one voter did not vote in "
									+ testName + " on " + toTest.toString());
						}
						if (v.getVoted() > 1) {
							return ("Failed: at least one voter voted more than once in "
									+ testName + " on " + toTest.toString());
						}
					}
				}
			}

			if (expect == result) {
				return ("Succes: test " + testName + " on " + toTest.toString());
			} else {
				return ("Failed: test " + testName + " on " + toTest.toString());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (exception) {
				return ("Succes: exception in " + testName + " on " + toTest
						.toString());
			} else {
				return ("Failed: unexpectede exception " + e.getMessage()
						+ " in " + testName + " on " + toTest.toString());
			}
		}
	}

	private static String run(String testName, ArrayList<Voter> voters,
			Census toTest) {
		return run(testName, voters, toTest, true, false);
	}

	private static String run(String testName, ArrayList<Voter> voters,
			Census toTest, boolean expect) {
		return run(testName, voters, toTest, expect, false);
	}

	public static boolean test(Census toTest) {
		ArrayList<String> result = new ArrayList<String>();
		result.add(run("voterslist is null", null, toTest));
		ArrayList<Voter> voters = new ArrayList<Voter>();
		result.add(run("voterslist is empty", voters, toTest));
		voters.add(null);
		result.add(run("Singel voter is null", voters, toTest));
		voters.clear();
		voters.add(new Voter(false));
		result.add(run("Singel voter is false", voters, toTest, false));
		voters.clear();
		voters.add(new Voter(true));
		result.add(run("Singel voter is true", voters, toTest));
		voters.add(new Voter(false));
		result.add(run("Second voter is false", voters, toTest, false));
		voters.add(new Voter(false));
		result.add(run("third voter is false", voters, toTest, false));
		voters.add(voters.get(1));
		result.add(run("One voter votes twice", voters, toTest, false, true));

		boolean toReturn = true;
		for (String regel : result) {
			System.out.println(regel);
			if (regel.toCharArray()[0] == 'F') {
				toReturn = false;
			}
		}
		return toReturn;
	}

	public static void main(String[] args) {

		ArrayList<Census> toTest = new ArrayList<Census>();
		toTest.add(new Census1());
		toTest.add(new Census2());
		toTest.add(new Census3());
		toTest.add(new Census4());
		toTest.add(new Census5());
		toTest.add(new Census6());
		toTest.add(new Census7());

		for (Census c : toTest) {
			System.out.println("##### testing " + c.getClass().getName()
					+ " #####");
			if (test(c)) {
				System.out.println("##### Succes on " + c.getClass().getName()
						+ " #####");
			} else {
				System.out.println("##### Fail on " + c.getClass().getName()
						+ " #####");
			}
			System.out.println("");

		}

	}

}

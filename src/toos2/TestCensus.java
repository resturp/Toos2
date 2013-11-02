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


		if (test(new Census1())) {
			System.out.println("Succes");
		} else {
			System.out.println("Fail");
		}

	}

}

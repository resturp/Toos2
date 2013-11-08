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
				return ("Failed: unexpected exception " + e.getMessage()
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
		
		// Test C2
		
		System.out.println("##### testing SpecializedCensus #####");
		
		// Create voter lists
		ArrayList<Voter> v1t = null; // null
		ArrayList<Voter> v1f = null; // null
		ArrayList<Voter> v2t = new ArrayList<Voter>(); // Empty
		ArrayList<Voter> v2f = new ArrayList<Voter>(); // Empty
		ArrayList<Voter> v3t = new ArrayList<Voter>(); // 1 true
		ArrayList<Voter> v3f = new ArrayList<Voter>(); // 1 true
		v3t.add(new Voter(true));
		v3f.add(new Voter(true));
		ArrayList<Voter> v4t = new ArrayList<Voter>(); // 1 false
		ArrayList<Voter> v4f = new ArrayList<Voter>(); // 1 false
		v4t.add(new Voter(false));
		v4f.add(new Voter(false));
		ArrayList<Voter> v5t = new ArrayList<Voter>(); // 1 true and 1 false
		ArrayList<Voter> v5f = new ArrayList<Voter>(); // 1 true and 1 false
		v5t.add(new Voter(true));
		v5f.add(new Voter(true));
		v5t.add(new Voter(false));
		v5f.add(new Voter(false));
		
		// Create Specialized Census
		SpecializedCensusTrue SC1T = new SpecializedCensusTrue();
		SpecializedCensusFalse SC1F = new SpecializedCensusFalse();
		SpecializedCensusTrue SC2T = new SpecializedCensusTrue();
		SpecializedCensusFalse SC2F = new SpecializedCensusFalse();
		SpecializedCensusTrue SC3T = new SpecializedCensusTrue();
		SpecializedCensusFalse SC3F = new SpecializedCensusFalse();
		SpecializedCensusTrue SC4T = new SpecializedCensusTrue();
		SpecializedCensusFalse SC4F = new SpecializedCensusFalse();
		SpecializedCensusTrue SC5T = new SpecializedCensusTrue();
		SpecializedCensusFalse SC5F = new SpecializedCensusFalse();	
		
		// Let's vote
		try { SC1T.voting(v1t); } catch (Exception e) { e.printStackTrace(); }
		try { SC1F.voting(v1f); } catch (Exception e) { e.printStackTrace(); }
		try { SC2T.voting(v2t); } catch (Exception e) { e.printStackTrace(); }
		try { SC2F.voting(v2f); } catch (Exception e) { e.printStackTrace(); }
		try { SC3T.voting(v3t); } catch (Exception e) { e.printStackTrace(); }
		try { SC3F.voting(v3f); } catch (Exception e) { e.printStackTrace(); }
		try { SC4T.voting(v4t); } catch (Exception e) { e.printStackTrace(); }
		try { SC4F.voting(v4f); } catch (Exception e) { e.printStackTrace(); }
		try { SC5T.voting(v5t); } catch (Exception e) { e.printStackTrace(); }
		try { SC5F.voting(v5f); } catch (Exception e) { e.printStackTrace(); }	
		
		// Check
		
		if( SC1T.getTrueVotes() == 0) {
			System.out.println("##### Succes on SC1T #####");
		} else {
			System.out.println("##### Fail on SC1T #####");
		}
		
		if( SC1F.getFalseVotes() == 0) {
			System.out.println("##### Succes on SC1F #####");
		} else {
			System.out.println("##### Fail on SC1F #####");
		}
		
		if( SC2T.getTrueVotes() == 0) {
			System.out.println("##### Succes on SC2T #####");
		} else {
			System.out.println("##### Fail on SC2T #####");
		}
		
		if( SC2F.getFalseVotes() == 0) {
			System.out.println("##### Succes on SC2F #####");
		} else {
			System.out.println("##### Fail on SC2F #####");
		}
		
		if( SC3T.getTrueVotes() == 1) {
			System.out.println("##### Succes on SC3T #####");
		} else {
			System.out.println("##### Fail on SC3T #####");
		}
		
		if( SC3F.getFalseVotes() == 0) {
			System.out.println("##### Succes on SC3F #####");
		} else {
			System.out.println("##### Fail on SC3F #####");
		}
		
		if( SC4T.getTrueVotes() == 0) {
			System.out.println("##### Succes on SC4T #####");
		} else {
			System.out.println("##### Fail on SC4T #####");
		}
		
		if( SC4F.getFalseVotes() == 1) {
			System.out.println("##### Succes on SC4F #####");
		} else {
			System.out.println("##### Fail on SC4F #####");
		}
		
		if( SC5T.getTrueVotes() == 1) {
			System.out.println("##### Succes on SC5T #####");
		} else {
			System.out.println("##### Fail on SC5T #####");
		}
		
		if( SC5F.getFalseVotes() == 1) {
			System.out.println("##### Succes on SC5F #####");
		} else {
			System.out.println("##### Fail on SC5F #####");
		}		
	
	}

}

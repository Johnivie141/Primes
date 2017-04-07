import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertEquals;
public class PrimesTest {

  private Primes primecode;
  
  @Before public void setup() {
    primecode= new Primes();
  }

  @Test public void testPrimes() {
                      Integer[] primeArray = new Integer[]{ 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541 };
                      ArrayList<Integer> testprimes = new ArrayList<Integer>(Arrays.asList(primeArray));

		      for (int i=1;i<10;i++)
		      {
			      int numberOfPrimes=(i+1)*(i+1);
                              ArrayList<Integer> subPrimes = new ArrayList<Integer>(testprimes.subList(0, numberOfPrimes));
		              ArrayList<Integer> findprimes = primecode.findPrimes(numberOfPrimes);

                              assertEquals(subPrimes, primecode.findPrimes(numberOfPrimes));
		      }
  }
}

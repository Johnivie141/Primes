import java.util.*;
import java.lang.Math.*;
class Primes
{
	public static void main(String args[]){

		int columns = Integer.parseInt(args[0]) +1;
		if (columns<1)
		{
		  System.out.println("please enter a number greater than 1");
		  return;
		}
		// number of Primes we need to find
		int numberOfPrimes= columns *columns;

		System.out.println("Number of Primes is" + numberOfPrimes) ;
		// upper bound on how many numbers to check to find our primes
		double maxNumber =  numberOfPrimes*(Math.log((double)numberOfPrimes)) + numberOfPrimes *(Math.log(Math.log((double)numberOfPrimes)));

		// round this to integer
		int max = (int)Math.round(maxNumber);
	        	
		int[] Numbers = new int[max];
		int lastPrime=0;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		//Sieve of Eratosthenes 
		// Cross out all numbers that are multiples
		// when done 
		for (int i=2;i*i<=max;i++)
		{
			for (;Numbers[i]==1;i++);
			
		   
			lastPrime=i;
			primes.add(lastPrime);
			// if we have reached the square root of max we are finished
			if (i*i >max) break;
			for (int j=i+i;j<max;j=j+i)
			{
				Numbers[j]=1;
			}
		}

		for (int j=lastPrime;j<max;j++)	{
			 
			if (Numbers[j]==0){
				primes.add(j);
				lastPrime=j;
			}
			
		}
		int maxSize=("" + lastPrime).length();
			int primesSize=primes.size();
			
		for (int row=0;row <columns;row++)
		{
			StringBuilder sb = new StringBuilder("");
			for (int primeIndex=row *columns;primeIndex< row *columns +columns && primeIndex <primesSize;primeIndex++)
			{
				String numberString = String.format("%1$" + maxSize + "s",("" +primes.get(primeIndex)));

			    sb.append("|" + numberString);
			}
			System.out.println(sb.toString() + "|");
		}
		
	}

}


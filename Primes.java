import java.util.*;
import java.lang.Math.*;
class Primes
{
	public static void main(String args[]){

		int columns = Integer.parseInt(args[0]) +1;
		// maybe we will change this later for 3x100 etc.
		int rows=columns;
		if (columns<1)
		{
		  System.out.println("please enter a number greater than 1");
		  return;
		}
		// number of Primes we need to find
		int numberOfPrimes= columns *rows;

		
		// upper bound on how many numbers to check to find our primes
		// We will likely more primes than we need
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
			//skip all numbers already marked
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
                // It may be better to wrap this into the output and forget the ArrayList<Integer> primes ??
		// complete the list of primes
		for (int j=lastPrime;j<max;j++)	{
			 
			if (Numbers[j]==0){
				// perhaps stop when we have enough?
				primes.add(j);
				lastPrime=j;
			}
			
		}
		// find the biggest number we might display and use that for formatting
		int maxSize=("" + lastPrime).length();
			int primesSize=primes.size();
			
		for (int row=0;row <rows;row++)
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


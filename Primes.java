import java.util.*;
import java.lang.Math.*;
class Primes
{

	public static ArrayList<Integer> findPrimes(int numberOfPrimes){
		// We will likely more primes than we need
		double maxNumber =  numberOfPrimes*(Math.log((double)numberOfPrimes)) + numberOfPrimes *(Math.log(Math.log((double)numberOfPrimes)));

		// round this to integer
		// add 1 so we get 0...maxNumber
		int max = (int)Math.round(maxNumber)+1;
	        	
		// Hey we only need to store odd numbers in the array
		int[] Numbers = new int[max/2+1];
		int lastPrime=0;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		//Sieve of Eratosthenes 
		// Cross out all numbers that are multiples
		// when done 
		// should go to number <=max
		int index;
		for (int number=3;number<=max;number+=2)
		{

			index=(number -3)/2;
			for (;Numbers[index]==1;index++);
			
		   
			
			lastPrime=3+(index*2);
			primes.add(lastPrime);
			// if we have reached the square root of max we are finished
			if (number*number > max) break;
			for (int j=3*number;j<max;j=j+2*number)
			{
				index= (j-3) /2;
				Numbers[index]=1;
			}
		}
                // It may be better to wrap this into the output and forget the ArrayList<Integer> primes ??
		// complete the list of primes
		for (int j=lastPrime+2;j<max;j+=2)	{
			 
			index=(j-3)/2;
			if (Numbers[index]==0){
				// perhaps stop when we have enough?
				primes.add(j);
				if (primes.size() ==numberOfPrimes) break;
			}
			
		}			//skip all numbers already marked

		return primes;

	}
	public static void displayPrimes(int maxSize,int columns, int rows,ArrayList<Integer> primes)
	{
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
	public static void main(String args[]){
		
		// forgot this check
		if (args.length <1){
	          System.out.println("please enter a number greater than 1");
		  return;
		}

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

		// find the biggest number we might display and use that for formatting
	        ArrayList<Integer> primes = findPrimes(numberOfPrimes);		
		int maxSize=("" + primes.get(primes.size() -1)).length();
		displayPrimes(maxSize,columns, rows,primes);
		
		
	}

}


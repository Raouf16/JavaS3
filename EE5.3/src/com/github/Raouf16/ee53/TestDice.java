package com.github.Raouf16.ee53;
import com.github.Raouf16.dice.PairOfDice;
import com.github.Raouf16.statcalc.StatCalc;

public class TestDice {
	public TestDice(){}
	
	public static int rollFor( int N ) {
		
		PairOfDice pair = new PairOfDice();
		
	       if ( N < 2 || N > 12 )
	          throw new IllegalArgumentException("Impossible total for a pair of dice.");
	       
	       int die1, die2;  // Numbers between 1 and 6 representing the dice.
	       int roll;        // Total showing on dice.
	       int rollCt;      // Number of rolls made.
	       rollCt = 0;
	       do {
	    	  pair.roll();
	          die1 = pair.getDie1();
	          die2 = pair.getDie2();
	          roll = die1 + die2;
	          rollCt++;
	       } while ( roll != N );
	       return rollCt;
	  }
	
	public static double getAverageFor( int N ){
		
		StatCalc calc = new StatCalc();
		int resultat;
		
		for(int i = 0 ; i < 10000 ; i++){
			resultat = rollFor(N);
			calc.enter(resultat);
		}
		
		return calc.getMean();
	}
	
	public static double getStandardDeviationFor( int N ){
		
		StatCalc calc = new StatCalc();
		int resultat;
		
		for(int i = 0 ; i < 10000 ; i++){
			resultat = rollFor(N);
			calc.enter(resultat);
		}
		
		return calc.getStandardDeviation();
	}
	
	public static double getMaxFor( int N ){
		
		StatCalc calc = new StatCalc();
		int resultat;
		
		for(int i = 0 ; i < 10000 ; i++){
			resultat = rollFor(N);
			calc.enter(resultat);
		}
		
		return calc.getMax();
	}
	

	public static void main(String[] args){
		
		
		System.out.println("Total On Dice     Average Number of Rolls     Standard Deviation of Rolls     Maximum");
	    System.out.println("-------------     -----------------------     ---------------------------     -------");
		for(int i = 2 ; i <= 12 ; i++){
			System.out.printf("%10d%22.4f%22.4f%28.0f\n", i, getAverageFor(i), getStandardDeviationFor(i), getMaxFor(i));
            // Use 10 spaces to output dice, and use 22 spaces to output
            // average and standard deviation, with 4 digits after the decimal.
		}
	}
}

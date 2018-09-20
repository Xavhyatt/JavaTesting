package com.qa.quickstart.first;
import java.util.Random;

public class Blackjack {


	public int blackjackapp(int a, int b) {
			
	Random rand = new Random();
//		int a = rand.nextInt(42);
//		int b = rand.nextInt(42);
			
			
		int c = 0;
			
				
		if (a>=b & a<=21 & a>0) {
			return a;
		}			
		else if (b>a & b<=21 & b>0) {
			return b;
		}			
		else if (a>21 & b<=21 & b >0) {
			return b;
		}			
		else if (b>21 & a<=21 & a>0) {
			return a;
		}			
		return c;
	}

			
	public static void main(String[] args) {
			Blackjack b = new Blackjack();
			
			System.out.println(b.blackjackapp(22,22));
}
}

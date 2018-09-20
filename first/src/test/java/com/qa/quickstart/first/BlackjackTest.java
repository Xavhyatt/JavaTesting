package com.qa.quickstart.first;
import static org.junit.Assert.*;
import org.junit.Test;


public class BlackjackTest {

	@Test
	public void test() {
		Blackjack blackjack = new Blackjack();
		
	assertEquals(10, blackjack.blackjackapp(10,22));
	assertEquals(11, blackjack.blackjackapp(22,11));
	assertEquals(21, blackjack.blackjackapp(21,11));
	assertEquals(21, blackjack.blackjackapp(22,21));
	assertEquals(0, blackjack.blackjackapp(22,24));
	
}
}

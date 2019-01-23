package com.qa.quickstart.first;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class BlackjackTest {
	Blackjack blackjack;
	
	@Before
	public void setup() {
		blackjack = new Blackjack();
	}

	@Test
	public void test() {		
	assertEquals(10, blackjack.blackjackapp(10,22));
	}
	
	@Test
	public void test1() {
		assertEquals(11, blackjack.blackjackapp(22,11));
	}
	
	@Test
	public void test2() {
		assertEquals(21, blackjack.blackjackapp(21,11));
	}
	
	@Test
	public void test3() {
		assertEquals(21, blackjack.blackjackapp(22,21));
	}
	
	@Test
	public void test4() {
		assertEquals(0, blackjack.blackjackapp(22,24));
	}
	
	
}

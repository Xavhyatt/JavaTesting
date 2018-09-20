package com.qa.quickstart.first;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class ParametisedBlackJackTest {

	
	@Parameters
	public static List<Integer[]> data() {
		return Arrays.asList(new Integer[][] {{0,22,0},{0,22,22},
			{18,18,12}, {21,21,18}, {21,12,21}, {5,24,5}, {20,2,20}});
		
		}
	private int Input1;
	private int Input2;
	private int Expected;
	
	public ParametisedBlackJackTest(int expected, int input2, int input1) {
		Input1 = input1;
		Input2 =input2;
		Expected = expected;
	}
	
	@Test
	public void test() {
		
		Blackjack BlackJack = new Blackjack();
		
		assertEquals(Expected, BlackJack.blackjackapp(Input1, Input2));
	
	
	}
	
	
}

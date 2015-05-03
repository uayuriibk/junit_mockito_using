package com.yuriyb.tdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class MockitoTesting2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void testMockito1(){
		List<String> list = new ArrayList<String>();
		List<String> spyList = Mockito.spy(list);
		
		spyList.add("one");
		spyList.add("two");
		
		assertEquals(2, spyList.size());
	}
	
	
	
	

}

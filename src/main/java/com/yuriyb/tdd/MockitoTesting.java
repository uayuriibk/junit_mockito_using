package com.yuriyb.tdd;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class MockitoTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Test
	public void testMockito() {
		List mockedList = mock(List.class);

		mockedList.add("one");
		mockedList.clear();

		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
	
	@Test
	public void testMockito2(){
		LinkedList mockedList = mock(LinkedList.class);
		
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		
		System.out.println(mockedList.get(0));
		//System.out.println(mockedList.get(1));
		
		System.out.println(mockedList.get(999));
	}
	
	@Test
	public void testMockito3(){
		LinkedList mockedList = mock(LinkedList.class);
		
		mockedList.add("once");
		
		mockedList.add("twice");
		mockedList.add("twice");
		
		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");
		
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");
		
		verify(mockedList, never()).add("never happened");
		
		verify(mockedList, atLeastOnce()).add("three times");
		//verify(mockedList, atLeast(2)).add("five times");
		verify(mockedList, atMost(5)).add("three times");
	}
	
	@Test
	public void testMockito4(){
		List list = new LinkedList();
		List spy = spy(list);
		
		when(spy.size()).thenReturn(100);
		
		spy.add("one");
		spy.add("two");
		
		System.out.println(spy.get(0));		
		System.out.println(spy.size());
		
		verify(spy).add("one");
		verify(spy).add("two");		
	}
}

package com.yuriyb.tdd;

import java.util.AbstractList;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MockitoVerifyCookBook {

	@Test
	public void verifySimpleIvocationOnMock(){
		List<String> mockedList = mock(MyList.class);
		mockedList.size();
		verify(mockedList).size();
	}
	
	@Test
	public void verifyInteractionsNumberWithMock(){
		List<String> mockedList = mock(MyList.class);
		mockedList.size();
		verify(mockedList, times(1)).size();
	}
	
	@Test
	public void verifyNoInteractionWithWholeMockOccurred(){
		List<String> mockedList = mock(MyList.class);
		verifyZeroInteractions(mockedList);
	}
	
	@Test
	public void verifyNoInteractionWithSpecificMethodOccurred(){
		List<String> mockedList = mock(MyList.class);
		verify(mockedList, times(0)).size();
	}
	
	@Test
	public void verifyThereAreNoUnexpectedInteractions(){
		List<String> mockedList = mock(MyList.class);
		mockedList.size();
		mockedList.clear();
		verify(mockedList).size();
		//verifyNoMoreInteractions(mockedList);
	}
	
	@Test
	public void verifyInteractionOrder(){
		List<String> mockedList = mock(MyList.class);
		mockedList.size();
		mockedList.add("x");
		mockedList.clear();
		
		InOrder inOrder = Mockito.inOrder(mockedList);
		inOrder.verify(mockedList).size();
		inOrder.verify(mockedList).add("x");
		inOrder.verify(mockedList).clear();
	}
	
	@Test
	public void verifyInteractionHasNotOccrred(){
		List<String> mockedList = mock(MyList.class);
		mockedList.size();
		verify(mockedList, never()).clear();
	}
	
	@Test
	public void verifyInteractionHasOccuredAtLeastCertainNumberTimes(){
		List<String> mockedList = mock(MyList.class);
		mockedList.clear();
		mockedList.clear();
		mockedList.clear();
		
		verify(mockedList, atLeast(1)).clear();
		verify(mockedList, atMost(10)).clear();
	}
	
	@Test
	public void verifyInteractionWithExactArgument(){
		List<String> mockedList = mock(MyList.class);
		mockedList.add("test");
		verify(mockedList).add("test");
	}
	
	@Test
	public void verifyInteractionWithAnyStringArgument(){
		List<String> mockedList = mock(MyList.class);
		mockedList.add("test");
		verify(mockedList).add(anyString());
	}
}

class MyList extends AbstractList<String>{
	
	@Override
	public String get(final int index){
		return null;
	}
	
	@Override
	public int size(){
		return 0;
	}
}
package com.yuriyb.tdd;

import java.util.AbstractList;
import java.util.List;

import org.junit.Test;
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
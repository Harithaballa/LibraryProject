package com.redshift.TestCases;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.redshift.LibrarApplicationn.Model.Custom;



public class Case2 {
	

	@Test
	public void test()
	{
		Custom custom=mock(Custom.class);
		InputStream in = new ByteArrayInputStream("12456666342".getBytes());
		when(custom.testUserInput(in)).thenReturn(3);
	}
}



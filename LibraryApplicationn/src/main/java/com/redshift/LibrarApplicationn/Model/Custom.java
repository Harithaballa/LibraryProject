package com.redshift.LibrarApplicationn.Model;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Custom {
	
	public  int testUserInput(InputStream in) {
	    Scanner key = new Scanner(in);
	    PrintStream out=new PrintStream(System.out);
	    out.println("Give a number between 1 and 10");
	    int input = key.nextInt();

	    while (input < 1 || input > 10) {
	        out.println("Wrong number, try again.");
	        input = key.nextInt();
	    }

	    return input;
	}
}

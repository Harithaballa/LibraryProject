package com.redshift.LibrarApplicationn;

import java.util.Scanner;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//import ch.qos.logback.classic.Logger;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class LibraryApplicationnApplication implements CommandLineRunner{
	 private static Logger log = Logger.getLogger(LibraryApplicationnApplication.class);
	public static void main(String[] args) {
//		Layout layout=new SimpleLayout();
//		Layout layout2=new HTMLLayout();
//		Layout layout3=new XMLLayout();
//		
//		Appender appender=new ConsoleAppender(layout);
//		Appender appender2=new ConsoleAppender(layout2);
//		 Appender appender3=new ConsoleAppender(layout3);
		 
		SpringApplication.run(LibraryApplicationnApplication.class, args);
		
//		logger.addAppender(appender);
//		logger.addAppender(appender2);
//		logger.addAppender(appender3);
//      logger.info("main class info");
//		logger.debug("main class debug");
//		logger.fatal("main class fatal");
//		logger.error("main class error");
//		logger.warn("main class info");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hi");
		  System.out.println("Enter word!");
	        Scanner scanner = new Scanner(System.in);
	        String line = scanner.nextLine();
	 System.out.println(line);
		
	}
	

}

package com.redshift.LibrarApplicationn;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LibraryApplicationnApplication //implements CommandLineRunner
{
	 private static Logger log = Logger.getLogger(LibraryApplicationnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplicationnApplication.class, args);
		
		
	}
}

















//		Layout layout=new SimpleLayout();
//		Layout layout2=new HTMLLayout();
//		Layout layout3=new XMLLayout();
//		
//		Appender appender=new ConsoleAppender(layout);
//		Appender appender2=new ConsoleAppender(layout2);
//		 Appender appender3=new ConsoleAppender(layout3);
		 
		
		
//		logger.addAppender(appender);
//		logger.addAppender(appender2);
//		logger.addAppender(appender3);
//      logger.info("main class info");
//		logger.debug("main class debug");
//		logger.fatal("main class fatal");
//		logger.error("main class error");
//		logger.warn("main class info");
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("Hi");
//		  System.out.println("Enter word!");
//	        Scanner scanner = new Scanner(System.in);
//	        String line = scanner.nextLine();
//	 System.out.println(line);
//		
//	}
	

//}

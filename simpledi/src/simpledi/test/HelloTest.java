package simpledi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import simpledi.bean.Hello;
import simpledi.service.Printer;

public class HelloTest {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("conf/beans.xml");
		
		Hello hello = (Hello)context.getBean("hello");
		System.out.println(hello);

		Hello hello2 = (Hello)context.getBean("hello");
		System.out.println(hello==hello2);
		
		Printer stringPrinter = (Printer)context.getBean("stringPrinter");
		stringPrinter.print("stringPrinter");
		System.out.println(stringPrinter.toString());
		
		Printer consolePrinter = (Printer)context.getBean("consolePrinter");
		consolePrinter.print("consolePrinter");
		
	} // main

} // class
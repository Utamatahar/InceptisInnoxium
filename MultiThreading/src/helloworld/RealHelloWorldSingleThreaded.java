package helloworld;

import java.util.Arrays;

public class RealHelloWorldSingleThreaded {

	public RealHelloWorldSingleThreaded() {
		String countries []= {"France","India","China","USA","Germany"};
		
		for(String country:countries) {
			System.out.println("Hello "+country+"!");
		}
		
		System.out.println("\nJava 8 :");
		
		Arrays.stream(countries).forEach(country -> System.out.println("Hello "+country+"!"));
		
	}
	
}

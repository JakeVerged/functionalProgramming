package my.using.biconsumer;

//Using BiConsumers
//refer: https://www.geeksforgeeks.org/java-8-biconsumer-interface-in-java-with-examples/
// Java Program to demonstrate
// BiConsumer's andThen() method
//refer2: https://medium.com/swlh/exception-handling-in-java-streams-5947e48f671c

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
	public static void main(String args[])
	{

		// Create first list
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(2);
		lista.add(1);
		lista.add(3);

		// Create second list
		List<Integer> listb = new ArrayList<Integer>();
		listb.add(2);
		listb.add(1);
		listb.add(2);

		// BiConsumer to compare 2 lists of integers
		BiConsumer<List<Integer>, List<Integer> > doEquals = (list1, list2) ->
		{
			if (list1.size() != list2.size()) {
				System.out.println("False");
			}
			else {
				for (int i = 0; i < list1.size(); i++)
					if (list1.get(i) != list2.get(i)) {
						System.out.println("False");
						return;
					}
				System.out.println("True");
			}
		};

		// BiConsumer to print 2 lists
		BiConsumer<List<Integer>, List<Integer> > doDisplay = (list1, list2) ->
		{
			list1.stream().forEach(a -> System.out.print(a + " "));
			System.out.println();
			list2.stream().forEach(a -> System.out.print(a + " "));
			System.out.println();
		};

		// Using addThen() method
		doEquals.andThen(doDisplay).accept(lista, listb);
		
		//Exception handling with Consumer
		handleExceptions_with_Consumer();
	}
	
	
	public static void handleExceptions_with_Consumer(){
	    
        List<String> integers = Arrays.asList("44", "xyz", "145");
        
        //1.Traditional way of exception handling
        //integers.forEach(str -> System.out.println(Integer.parseInt(str)));
        
        //2.Better approach of exception handling: returning back the Consumer for futher processing
        integers.forEach(exceptionHandledConsumer(str -> System.out.println(Integer.parseInt(str))));

	}
	
	static Consumer<String> exceptionHandledConsumer(Consumer<String> unhandledConsumer) {
        return (obj -> {
            try {
                unhandledConsumer.accept(obj);
            } catch (NumberFormatException e) {
                System.err.println("Can't format this string: " + obj.toString());
            }
        });
    }
}
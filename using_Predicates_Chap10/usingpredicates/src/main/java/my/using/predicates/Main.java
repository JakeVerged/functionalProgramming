package my.using.predicates;


//Using BiConsumers
//Refer: https://www.journaldev.com/17072/java-predicate
//https://www.evernote.com/shard/s42/nl/4558384/6deac404-33c9-4617-9aad-624e9ac29e5d?title=Studies:%20FuncInterface%20:%20Predicate

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    
    public static void main(String[] args) {
    	List<Apple> apples = 
    	    Arrays.asList(new Apple("green", 120.0), 
    	                 new Apple("red", 110.0),
    			        new Apple("brown", 150.0), 
    			        new Apple("green", 160.0), 
    			        new Apple("red", 122.0));
    
        //Test 1: Print the apples	
    	ApplePredicates
    	            .filterApples(apples, ApplePredicates.isWeightAbove150())
    	            .forEach(System.out::println);
    	
    	//Test 2: Print only non greens within weights
    	Predicate<Apple> andPredicate = ApplePredicates.isColorGreen().and(ApplePredicates.isWeightAbove150());
    	apples.stream().filter(andPredicate).forEach(System.out::println);
    	
    	
    }
    
    	
    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
    	return apples.stream().filter(predicate).collect(Collectors.toList());
    }
    	
    	
    static class ApplePredicates {
    
        public static Predicate<Apple> isWeightAbove150() {
    	return apple -> apple.getWeight() >= 150;
        }
        
        
        
        Predicate<Apple> negateGreens = ApplePredicates.isColorGreen().negate();
        
        public static Predicate<Apple> isColorGreen() {
           return apple -> apple.getColor().equals("green");
        }
        
        Predicate<Apple> negateExample = ApplePredicates.isColorGreen().negate();
        
        public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
    	    return apples.stream().filter(predicate).collect(Collectors.toList());
        }
    }
        
    static class Apple {
        private String color;
        private Double weight;
    
        public Apple(String c, Double w) {
    	    this.color = c;
    	    this.weight = w;
        }
    
        @Override
        public String toString() {
    	    return "Apple{color:" + this.getColor() + ",weight:" + this.getWeight() + "}";
        }
    
        public String getColor() {
    	    return color;
        }
    
        public void setColor(String color) {
    	    this.color = color;
        }
    
        public Double getWeight() {
    	    return weight;
        }
    
        public void setWeight(Double weight) {
    	    this.weight = weight;
        }
    }
}

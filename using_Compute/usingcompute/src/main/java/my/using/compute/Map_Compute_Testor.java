package my.using.compute;

import static java.lang.System.out;
import java.util.function.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;



/* 
* Refer: 
* 1. Baeldung
* https://sourcegraph.com/github.com/eugenp/tutorials@master/-/blob/core-java-modules/core-java-collections-maps-3/src/test/java/com/baeldung/map/computeifabsent/ComputeIfAbsentUnitTest.java
* 
* 2. Geeks for Geeks
*/

public class Map_Compute_Testor{
    
    public static void main(String[] args){
        out.println("Running Test Assertions");
        
        //System under test
        whenKeyIsPresent_thenFetchTheValue();
        whenKeyIsNotPresent_thenComputeTheValueUsingMappingFunctionAndStore();
        whenMappingFunctionReturnsNull_thenDoNotRecordMapping();
        
    
        //System out to see working of compute() to ReMap
        using_MapCompute();
        using_Map_computeIfPresent();
    }

    public static void whenKeyIsPresent_thenFetchTheValue() {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("John", 5);
        
        assertEquals((long)myMap.computeIfAbsent("John", s -> s.length()), 5);
            
    }
    
    public static void whenKeyIsNotPresent_thenComputeTheValueUsingMappingFunctionAndStore() {
        Map<String, Integer> myMap = new HashMap<>();
        
        assertEquals((long)myMap.computeIfAbsent("John", s -> s.length()), 4);
        
        //check if Map is now mutated
        assertEquals((long)myMap.get("John"), 4);
    }
    
    
    public static void whenMappingFunctionReturnsNull_thenDoNotRecordMapping() {
        Map<String, Integer> stringLength = new HashMap<>();
        
        assertEquals(stringLength.computeIfAbsent("John", s -> null), null);
        assertNull(stringLength.get("John"));
    }
    
    /*
    *Refer: https://www.geeksforgeeks.org/hashmap-compute-method-in-java-with-examples/
    */
    public static void using_MapCompute(){
        
        System.out.println("\n@using_MapCompute(): Doing..");
        
        // Create a Map and add some values
        Map<String, String> map = new HashMap<>();
        map.put("Name", "Aman");
        map.put("Address", "Kolkata");
  
        // Print the map
        System.out.println("Map: " + map);
  
        // remap the values using compute() method
        map.compute("Name", (key, val)
                                -> val.concat(" Singh"));
        map.compute("Address", (key, val)
                                   -> val.concat(" West-Bengal"));
  
        // print new mapping
        System.out.println("New Map: " + map);
    }
    
    /*
    *Refer: https://www.geeksforgeeks.org/hashmap-computeifpresentkey-bifunction-method-in-java-with-examples/
    */
    public static void using_Map_computeIfPresent(){
        
        System.out.println("\n@using_Map_computeIfPresent(): Doing..");
        
        // Create a HashMap and add some values
        HashMap<String, Integer> wordCount = new HashMap<>();
        wordCount.put("Geeks", 1);
        wordCount.put("for", 2);
        wordCount.put("geeks", 3);
  
        // print HashMap details
        System.out.println("Hashmap before operation :\n "
                           + wordCount);
  
        // provide new value for keys which is present
        // using computeIfPresent method
        wordCount.computeIfPresent("Geeks",
                                   (key, val) -> val + 100);
  
        // print new mapping
        System.out.println("HashMap after operation :\n "
                           + wordCount);
    }
}
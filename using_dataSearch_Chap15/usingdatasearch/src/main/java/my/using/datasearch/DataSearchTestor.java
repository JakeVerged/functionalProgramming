package my.using.datasearch;

import static java.lang.System.out;
import java.util.function.*;
import java.util.Optional;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;

/* 
* Includes use of Assertions
*/

public class DataSearchTestor{
    
    public static void main(String[] args){
  
        //Method under test
        findAny_Optional();
        findFirst_ifPresent();
        testAnyMatch();
        testAll_None_Match();
        
    }
    
    public static void findAny_Optional(){
        
        out.println("@findAny_Optional=>");
        IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7);
        OptionalInt x = stream.filter(i -> i > 4).findAny();
        out.println(x.getAsInt());
    }
    
    public static void findFirst_ifPresent(){
        out.println("@findFirst=>");
        IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7);
        stream
        .filter(i -> i > 4)
        .findFirst()
        .ifPresent(System.out::println); // 5
    }
    
    
    public static void testAnyMatch(){
    out.println("@testAnyMatch=>");
    IntStream stream = IntStream.empty();
    System.out.println(
       stream.anyMatch(i -> i%3 == 0)
        ); // false
    
    IntStream stream2 = IntStream.of(1, 2, 3, 4, 5, 6, 7);
    System.out.println(
       stream2.anyMatch(i -> i%10 == 0)
        ); // false
    }
    
    
    public static void testAll_None_Match(){
        out.println("@testAll_None_Match=>");
        IntStream stream2 = IntStream.of(1, 2, 3, 4, 5, 6, 7);
        //System.out.println( stream2.allMatch(i -> i%3 == 0) );
        assertFalse(stream2.allMatch(i -> i%3 == 0));
        
        IntStream stream3 = IntStream.of(1, 2, 3, 4, 5, 6, 7);
        assertTrue(stream3.noneMatch(i->i>10));
    }
    
}

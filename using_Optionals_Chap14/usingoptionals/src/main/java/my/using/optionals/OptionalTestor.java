package my.using.optionals;

import java.lang.System.*;
import static java.lang.System.out;
import java.util.function.*;
import java.util.Optional;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

/* 
* Using Optional for Testing
* Includes use of Assertions
*/

public class OptionalTestor{
    
    public static void main(String[] args){
    
        
        //Method under test
        //optionalBasicTest();
        
        //Test 2
        //optionalStratchTest();
        
        
        Arrays.asList(1,2,3,6,10,15,12).stream().forEach(j -> out.println(fizzBuzzInJava8(j)) );
        
        
    }
    
    
    /*
    * also a FizzBuzz test
    * Refer: EverNote: FizzBuzz using functional programming:
    *   https://www.evernote.com/shard/s42/nl/4558384/d5b7ea7d-3c44-4960-a523-e5d20b182b90?title=Javarevisited:%20How%20to%20solve%20FizzBuzz%20Problem%20in%20Java%208?%20Stream.map()%20Example
    */
     public static String fizzBuzzInJava8(int number) {
        String result = Optional.of(number)
                .map(n -> (n % 3 == 0 ? "Fizz" : "") 
                               + (n % 5 == 0 ? "Buzz" : ""))
                .get();
        return result.isEmpty() ? Integer.toString(number) : result;
    }
    
    
    public static void optionalStratchTest(){
        
        //Optional<String> summary = Optional.empty();
        Optional<String> summary = Optional.of("short summary");

        String s1 = summary.get();
        out.println(s1);
        
        //Vs.
        String s2 = summary.orElse("Default summary");
        out.println(s2);
        
        //Vs.
        String s3 = summary.orElse( "other");
        out.println(s3);

        //Vs.
        String s4 = summary.orElseGet( () -> "Default summary" );
        out.println(s4);
        
        
        try{
            String s5 = summary.orElseThrow( () -> new Exception() );
            out.println(s5);
        }catch (Exception e){
            out.println("Exception");
        }


        //Vs. - //will not compile
        //String s5 = Optional.of(summary).orElseGet(() -> "Default summary" ); 
        //out.println(s1);

    }
    
    
    public static void optionalBasicTest(){
        Optional<String> r = Optional.empty();
        
        //Basic
        String s="foo";
        Optional<String> r1 = Optional.of(s);
        println(r1.get());
        assertEquals(r1.get(), "foo");
        
        //When Null
        s=null;
        Optional<String> r2 = Optional.ofNullable(s);
        
        //using isPresent
        if (r2.isPresent()){
            println(r2.get());    
        }else{
            println("Nothing to print");
        }
        
        //using ifPresent. It takes a Consumer
        String s3="bar";
        Optional<String> r3 = Optional.ofNullable(s3);
        r3.ifPresent(x->println(x));
        
        
        //using OrElseGet. It takes a Supplier
         String s4=null;
         Optional<String> r4 = Optional.ofNullable(s4);
         String out = r4.orElseGet(()->"gof");
         println(out);
         
         //using ifPresent with filter or map: to take a Supplier
         //apply the map transformation if the value is present
         String s5="The fox jumped over the fence.";
         Optional<String> op5 = Optional.ofNullable(s5);
         op5.map(x->x.length()).ifPresent(y->println(y));
        
    }
    
    
    /*
    * print utility
    */
    private static void println(Object s){
     out.println("=>"+s.toString());
    }
    
}


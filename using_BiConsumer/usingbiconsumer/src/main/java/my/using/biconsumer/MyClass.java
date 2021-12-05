package my.using.biconsumer;

import static java.lang.System.out;
import java.util.*;
import java.util.function.*;

public class MyClass {
    public static void main(String args[]) {

    
      biConsumerNoLambdaTest();
      biConsumerWithLambdaTest();
      
    }
    
    public static void biConsumerNoLambdaTest(){
        out.println("\nStarting biConsumerNoLambdaTest...");
        
        Map<String, Integer> map = new HashMap<>();
        map.put("John", 1000);
        map.put("Jacob", 2000);
        map.put("Mary", 4000);
        
        BiConsumer<String, Integer> doAction = new MyBiConsumer();
        map.forEach(doAction);
    }
    
    
    public static void biConsumerWithLambdaTest(){
        out.println("\n\nStarting biConsumerWithLambdaTest...");
        
        Map<String, Integer> map = new HashMap<>();
        map.put("John_Lamb", 1000);
        map.put("Jacob_Lamb", 2000);
        map.put("Mary_Lamb", 4000);
        
        BiConsumer<String, Integer> doAction = (k,v) -> {
                                                    out.println("\n=> Value of k: " +k);
                                                    out.println("=> Value of v: " +v);
                                                    };
        map.forEach(doAction);
    }
    
    static class MyBiConsumer implements BiConsumer<String, Integer>{
            public void accept(String k, Integer v){
                out.println("\n=> Value of k: " +k);
                out.println("=> Value of v: " +v);
            }
    }
    
    
        
    }//end of class


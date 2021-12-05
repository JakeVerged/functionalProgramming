package my.using.compute;

import static java.lang.System.out;
import java.util.function.*;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;

/* 
* Using Filtering examples used in Chap13
* Includes use of Assertions
*/

public class FilteringTestor{
    
        public static void main(String[] args){
        int x=1;
        out.println(x);
        
        //Method under test
        removeIf_test();
        removeIf_test2();
        removing_withFilter_test();
        removing_withFilter_test2();
        
        listOf_test();
    }
    
    
    public static void removeIf_test2(){
        out.println("\n\n=>@removeIf_test2()");
        
        // create an ArrayList which going to
        // contains a list of Student names which is actually
        // string values
        ArrayList<String> students = new ArrayList<String>();
  
        // Add Strings to list
        // each string represents student name
        students.add("Ram");
        students.add("Mohan");
        students.add("Sohan");
        students.add("Rabi");
        students.add("Shabbir");
        students.add("");
        students.add(null);
        students.stream().forEach(out::println);
  
        // apply removeIf() method
        // we are going to remove names
        // start with S
        
        students.removeIf(t->t==null || t.isEmpty()); //remove all nulls 
        students.removeIf(n -> (n.charAt(0) == 'S')); //remove names that start with S
  
        System.out.println("\n@removeIf_test2: Students name Does not start with S and non-empty values");
        
        // print list
        for (String str : students) {
            System.out.println(str);
        }
    }
    
    
    public static void removeIf_test(){
        
        out.println("\n\n=>@removeIf_test()");
        List<String> words = Arrays.asList(new String[] { "A", "B", "C", "D" });
        out.println("@removeIf_test() : Before:" + words.toString());
        
        // Using a lambda expression
        words.removeIf(t -> t == null || t.isEmpty());
        out.println("@removeIf_test(): After:" + words.toString());


    }
    
    public static void removing_withFilter_test(){
        out.println("\n\n=>@removing_withFilter_test()");
        List<String> words = Arrays.asList("hello", null, "");
        words.stream()
           .filter(t -> t != null)   // ["hello", ""]
           .filter(t -> !t.isEmpty())   // ["hello"]
           .forEach(System.out::println);
    }
    
    
    
    public static void removing_withFilter_test2(){
        
        out.println("\n\n=>@removing_withFilter_test2()");
        List<String> words = Arrays.asList("hello", "World with no nulls", null, "");
        words.stream()
        .filter(StringUtils::isNotNullOrEmpty)
        .forEach(System.out::println);
    }
    
    
    public static void listOf_test(){
        
        out.println("\n\n=>@listOf_test()");
        var x = List.of(1,2,3);
        var xarr = List.of(new String[]{"J","A"});
        
        
        List<Integer[]> z = new ArrayList<>();
        z.add(new Integer[]{5,10});
        
        Integer[] q = new Integer[]{5,10};
        var z1 = List.of(new Integer[]{5,10});
        
        ////using List.of()
        var xarrVals = List.of(new Integer[]{1,2});
        
        x.stream().forEach(System.out::println);
        xarr.stream().forEach(System.out::println);
        
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        Integer[] arr = new Integer[]{10,20};
        
        //map.put(30, List.of(new Integer[]{ arr[0], arr[1]}));
        map.put(30, xarrVals);
        

    }
    
    /*
    *Utility class
    */
    static class StringUtils {
        public static boolean isNotNullOrEmpty(String s) {
            return s != null && !s.isEmpty();
        }
    }


    
}

package my.using.peemapredcol;


import static java.lang.System.out;
import java.util.function.*;
import java.util.*;
import java.util.Optional;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

/* 
* Includes use of Assertions
*/

public class PeekingMappingCollectingTestor{
    
    public static void main(String[] args){
        int x=1;
        out.println(x);
        
        //Method under test
        peeking();
        mapping();
        groupingBy();
        groupingBy_counting();
        multiLevel_groupingBy();
        System.out.println(doStringSum(new String[]{"Parallel", "streams", "are", "great"}));  //map-reduce pattern

        
    }
    
    public static void peeking(){
        out.println("@peeking()==>");
        System.out.format("\n%d",
        IntStream.of(1, 2, 3, 4, 5, 6)
        .limit(3)
        .peek( i -> System.out.format("%d ", i) )
        .sum() );

    }
    
    public static void mapping(){
        out.println("\n\n@mapping()==>");
        Stream.of('a', 'b', 'c', 'd', 'e')
       .map(c -> (int)c)
       .forEach(i -> System.out.format("%d ", i));
    }
    

    public static void groupingBy(){
        out.println("\n\n@groupingBy()==>");
        Map<Integer, List<Integer>> map = Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                                .collect(Collectors.groupingBy(i -> i/10 * 10));
        out.println(map.toString());
    }
    
    
    /*
    to count the elements in each group.
    
Herrera, Esteban. Java 8 Programmer II Study Guide: Exam 1Z0-809 (p. 428). Kindle Edition. 
    */
    public static void groupingBy_counting(){
        out.println("\n\n@groupingBy_counting()==>");
        Map<Integer, Long> map = Stream
                            .of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                            .collect(Collectors.groupingBy(i -> i/10 * 10, Collectors.counting()));
        out.println(map.toString());
    }
    
    
    /*
    We can even use another groupingBy() to classify the elements in a second level. For instance, instead of counting, 
    we can further classify the elements in even or odd:

    Herrera, Esteban. Java 8 Programmer II Study Guide: Exam 1Z0-809 (p. 429). Kindle Edition. 
    */
    public static void multiLevel_groupingBy(){
        out.println("\n\n@multiLevel_groupingBy()==>");
        Map<Integer, Map<String, List<Integer>>> map =
        Stream.of(2,34,54,23,33,20,59,11,19,37)
                .collect(Collectors.groupingBy(i -> i/10 * 10,
                            Collectors.groupingBy(i -> i%2 == 0 ? "EVEN" : "ODD")
               )
            );

        out.println(map.toString());
    }

    //Map-reduce pattern
    public static Integer doStringSum(String[] arr){
        int length = arr.length;
        mapToInt(s -> s.length()).
            reduce(0, (sum, strLength) ->sum + strLength);
        return length;
    }
    
    
}

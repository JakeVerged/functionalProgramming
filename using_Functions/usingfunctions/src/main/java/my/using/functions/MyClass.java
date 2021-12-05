package my.using.functions;

import java.util.function.*;

public class MyClass {
    
    public static void main(String args[]) {
      int x=10;
      int y=25;
      int z=x+y;

      System.out.println("Sum of x+y = " + z);
      
      round(5.4, r->Math.round(r));
      
      round(8.4, new Function<Double, Long>() {
          public Long apply(Double d){
              return Math.round(d);
          }
      });
}

    public static void round(double d, Function<Double, Long> f){
        long result = f.apply(d);
        System.out.println("Printing...");
        System.out.println(result);
    }

}

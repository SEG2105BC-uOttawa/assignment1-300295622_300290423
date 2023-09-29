package code_part2;

import java.util.*;

public class ArrayTest {
    

    //Array Size = 600,000,000

    public static int ArrayListCreate(){
        ArrayList<String> arr = new ArrayList<String>();
        long startTime = System.nanoTime();
        long afterTime = 0;
        long time = afterTime - startTime;
        long timeSec = 0;
        while (timeSec < 10){
            arr.add("1");
            afterTime = System.nanoTime();
            time = afterTime - startTime;
            timeSec = time/(10*10*10*10*10*10*10*10*10);
        }
        int x = arr.size();
        return x;
    }

    public static void main(String[] args){
        int avg = 0;
        for (int i=0; i<10; i++){
            int a = 0;
            a = ArrayListCreate();
            avg += a;
            System.out.println("Sum at Run" + (i+1) + ": " + avg);
            System.out.println("Average by Run " + (i+1) + ": " + avg/(i+1));
            System.out.println("Run " + (i+1) +": " + a);
        }

        
        avg = avg/10;
        System.out.println(avg);
        
    }


}

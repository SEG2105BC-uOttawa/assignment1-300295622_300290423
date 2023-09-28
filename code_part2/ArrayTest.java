package code_part2;

import java.util.*;

public class ArrayTest {
    

    public static int ArrayListCreate(){
        ArrayList<String> arr = new ArrayList<String>();
        long startTime = System.nanoTime();
        long afterTime = 0;
        long time = afterTime - startTime;
        long timeSec = 0;
        System.out.println(timeSec);
        while (timeSec < 10){
            arr.add("1");
            afterTime = System.nanoTime();
            time = afterTime - startTime;
            System.out.println(afterTime);
            System.out.println(startTime);
            System.out.println(time);
            timeSec = time/(10^9);
            System.out.println(timeSec);
        }
        int x = arr.size();
        return x;
    }

    public static void main(String[] args){
        int a = ArrayListCreate();
        System.out.println(a);
    }


}

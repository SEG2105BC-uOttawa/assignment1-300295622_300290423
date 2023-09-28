package code_part2;

import java.util.*;

public class ArrayTest {
    

    public int ArrayListCreate(){
        ArrayList<String> arr = new ArrayList<String>();
        long startTime = System.nanoTime();
        long afterTime = 0;
        long time = afterTime - startTime;
        long timeSec = time/(10*9);
        while (timeSec < 10){
            arr.add("1");
            afterTime = System.nanoTime();
            time = afterTime - startTime;
            timeSec = time/(10*9);
        }
        int x = arr.size();
        return x;
    }

    public void main(String args[]){
        int a = ArrayListCreate();
        System.out.println(a);
    }


}

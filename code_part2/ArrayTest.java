package code_part2;

import java.util.*;

public class ArrayTest {

    public static ArrayList<Integer> ArrayListCreate(int size){
        Random randomNumber = new Random();
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i=0; i<size; i++){
            arrList.add(randomNumber.nextInt(9));
        }
        return arrList;
    }

    public static Vector<Integer> VectorCreate(int size){
        Random randomNumber = new Random();
        Vector<Integer> vector = new Vector<Integer>();
        for (int i=0; i<size; i++){
            vector.add(randomNumber.nextInt(9));
        }
        return vector;
    }

    public static int[] ArrayCreate(int size){
        Random randomNumber = new Random();
        int[] arr = new int[size];
        for (int i=0; i<size; i++){
            arr[i]= randomNumber.nextInt(9);
        }
        return arr;
    }

    public static int ArrayListSum(ArrayList<Integer> arrList){
        Iterator<Integer> iterator = arrList.iterator();
        int sum = 0;
        while (iterator.hasNext()){
            int value = iterator.next();
            sum = sum + value;
        }
        return sum;
    }

    public static int VectorSum(Vector<Integer> vector){
        Iterator<Integer> iterator = vector.iterator();
        int sum = 0;
        while (iterator.hasNext()){
            int value = iterator.next();
            sum = sum + value;
        }
        return sum;
    }

    public static int ArraySum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            int value = arr[i];
            sum = sum + value;
        }
        return sum;
    }

    public static void main(String[] args){
        int size = 250000000;

        ArrayList<Integer> arrList = ArrayListCreate(size);

        Vector<Integer> vector = VectorCreate(size);

        int[] arr = ArrayCreate(size);

        long arraylistStartTime = System.nanoTime();
        int arraylistSum = ArrayListSum(arrList);
        long arraylistEndTime = System.nanoTime();
        long arraylistTime = arraylistEndTime - arraylistStartTime;
        double arraylistTimeinSeconds = ((double) arraylistTime)/(10*10*10*10*10*10*10*10*10);
        System.out.println("Array List Sum: " + arraylistSum);
        System.out.println("Array List Sum Time with 250,000,000 elements: " + arraylistTimeinSeconds);

        long vectorStartTime = System.nanoTime();
        int vectorSum = VectorSum(vector);
        long vectorEndTime = System.nanoTime();
        long vectorTime = vectorEndTime - vectorStartTime;
        double vectorTimeinSeconds = ((double) vectorTime)/(10*10*10*10*10*10*10*10*10);
        System.out.println("Vector Sum: " + vectorSum);
        System.out.println("Vector Sum Time with 250,000,000 elements: " + vectorTimeinSeconds);

        long arrayStartTime = System.nanoTime();
        int arraySum = ArraySum(arr);
        long arrayEndTime = System.nanoTime();
        long arrayTime = arrayEndTime - arrayStartTime;
        double arrayTimeinSeconds = ((double) arrayTime)/(10*10*10*10*10*10*10*10*10);
        System.out.println("Array Sum: " + arraySum);
        System.out.println("Array Sum Time with 250,000,000 elements: " + arrayTimeinSeconds);
    }


}

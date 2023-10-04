
import java.util.*;
/*THIS IS THE TEMPLATE CODE THAT IS GOING TO BE USED TO TEST THE PERFORMANCE OF ALL 3 DESIGNS.  */

public class PerformanceAnalysis {
    public static void main(String[] args){
        Random random = new Random();
        //number of times we test our methods
        int numberOfInstances = 11001;
        //array holding performance times for each instance
        long[] performanceTimes = new long[numberOfInstances];
        //array with randomly generated coordinates for x and y
        double[][] randomCoordinates = new double[2][numberOfInstances];
        //array with randomly generated C or P coordinate types
        char[] randomTypes = new char[numberOfInstances];

        for(int i=0; i<numberOfInstances; i++){
            boolean randomType = random.nextBoolean();
            double randomX = random.nextDouble();
            double randomY = random.nextDouble();

            //setting random test values for the designs
            if(randomType==true){
                randomTypes[i]='C';
            }else{
                randomTypes[i]='P';
            }
            randomCoordinates[0][i]=randomX;
            randomCoordinates[1][i]=randomY;

            //start timer
            long start = System.currentTimeMillis();
            /*INSERT BODY CODE HERE */


            //end timer
            long finish = System.currentTimeMillis();
            //time elapsed found + stored
            long timeElapsed = (finish-start)/1000;
            performanceTimes[i]=timeElapsed;
        }
        //finding max, min and sorting the array
        long maxTime = Arrays.stream(performanceTimes).max().getAsLong();
        long minTime = Arrays.stream(performanceTimes).min().getAsLong();
        Arrays.sort(performanceTimes);

        System.out.println("After running " + numberOfInstances + " tests:\n"+ "The median time is: "+ performanceTimes[numberOfInstances/2] 
        +"\n The max time is: "+maxTime + "\n The min time is: "+minTime);              
    }
}

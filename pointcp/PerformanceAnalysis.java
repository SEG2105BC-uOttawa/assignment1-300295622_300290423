
import java.util.*;
/*THIS IS THE TEMPLATE CODE THAT IS GOING TO BE USED TO TEST THE PERFORMANCE OF ALL 3 DESIGNS.  */

public class PerformanceAnalysis {
    public static void main(String[] args){
        Random random = new Random();
        //number of times we test our methods
        int numberOfInstances = 11001;
        //array with randomly generated coordinates for x and y
        double[][] randomCoordinates = new double[2][numberOfInstances];
        //array with randomly generated C or P coordinate types
        char[] randomTypes = new char[numberOfInstances];

        for(int j=0; j<numberOfInstances; j++){
            boolean randomType = random.nextBoolean();
            double randomX = random.nextDouble();
            double randomY = random.nextDouble();

            //setting random test values for the designs
            if(randomType==true){
                randomTypes[j]='C';
            }else{
                randomTypes[j]='P';
            }
            randomCoordinates[0][j]=randomX;
            randomCoordinates[1][j]=randomY;

        }
            //start timer
            long start = System.nanoTime();

            /*INSERT BODY CODE HERE */
            

            //end timer
            long finish = System.nanoTime();
            //time elapsed found + stored
            long timeElapsed = (finish-start);
        //finding max, min and sorting the array
       System.out.println("Time Elapsed: "+ timeElapsed);            
    }
}

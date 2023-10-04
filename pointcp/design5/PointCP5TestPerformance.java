package design5;
import java.io.*;
import java.util.Arrays;
import java.util.Random;
public class PointCP5TestPerformance
{
  public static void main(String[] args){
    System.out.println("Cartesian-Polar Coordinates Conversion Program");
    int timeCount = 0;
    Random random = new Random();
        //number of times we test our methods
        int numberOfInstances = 11001;
        //array holding performance times for each instance
        long[] performanceTimes = new long[numberOfInstances];
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
            char theInput1=randomTypes[j];
            randomCoordinates[0][j]=randomX;
            double theInput2 = randomX;
            randomCoordinates[1][j]=randomY;
            double theInput3 = randomY;
            
            //start timer
            long start = System.nanoTime();
try{
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    char coordType = 'A'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 3; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid
          
        // Prompt the user
        if (i == 0) // First argument - type of coordinates
        {
          System.out.print("Enter the type of Coordinates you "
            + "are inputting ((C)artesian / (P)olar): ");
        }
        else // Second and third arguments
        {
          System.out.print("Enter the value of " 
            + (coordType == 'C' 
              ? (i == 1 ? "X " : "Y ")
              : (i == 1 ? "Rho " : "Theta ")) 
            + "using a decimal point(.): ");
        }

        // Get the user's input      
       
        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';        
             
        //System.in.read(buffer);
        //theInput = new String(buffer).trim();
        
        // Verify the user's input
        try
        {
          if (i == 0) // First argument -- type of coordinates
          {
            if (!((theInput1 == 'C') 
              || (theInput1 == 'P')))
            {
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            }
            else
            {
              coordType = theInput1;
            }
          }
          else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput2).doubleValue();
            else
              b = Double.valueOf(theInput3).doubleValue();
          }
          if (coordType=='C'){
                try
                    {
                        PointCP3 point=new PointCP3(coordType, a, b);

                        if(coordType=='C' && a>0 && b>0){
                        System.out.println("\nYou entered:\n" + point);
                        point.convertStorageToCartesian();
                        System.out.println("\nAfter asking to store as Cartesian:\n" + point);
                        point.convertStorageToPolar();
                        System.out.println("\nAfter asking to store as Polar:\n" + point);
                        }
                    }
                    catch(Exception e)
                    {
                    // If we arrive here, it is because either there were no
                    // command line arguments, or they were invalid
                    if(args.length != 0)
                        System.out.println("Invalid arguments on command line");}
                            }
        
            else if (coordType=='P'){
                try
                    {
                        PointCP2 point=new PointCP2(coordType, a, b);

                        if(coordType=='P' && a>0 && b>0){
                        System.out.println("\nYou entered:\n" + point);
                        point.convertStorageToCartesian();
                        System.out.println("\nAfter asking to store as Cartesian:\n" + point);
                        point.convertStorageToPolar();
                        System.out.println("\nAfter asking to store as Polar:\n" + point);
                        }
                    }
                    catch(Exception e)
                    {
                    // If we arrive here, it is because either there were no
                    // command line arguments, or they were invalid
                    if(args.length != 0)
                        System.out.println("Invalid arguments on command line");}
                            }
          }
        
        catch(Exception e)
        {
        	System.out.println("Incorrect input");
        	isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }}
    catch(Exception ex)
    {
      System.out.println("Error getting input. Ending program.");
      return;
    }
 //end timer
            long finish = System.nanoTime();
            //time elapsed found + stored
            long timeElapsed = (finish-start)/1000000;
            timeCount+=timeElapsed;
            performanceTimes[j]=timeElapsed;
        }
       System.out.println("TIME ELAPSED: "+timeCount);
    }}





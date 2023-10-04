package design3;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCP3TestPerformance
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */
  public static void main(String[] args)
  {
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
    PointCP3 point;

    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Check if the user input coordinates from the command line
    // If he did, create the PointCP object from these arguments.
    // If he did not, prompt the user for them.
    try
    {
        point = new PointCP3(randomTypes[i],randomCoordinates[0][i],randomCoordinates[1][i]);
    }
    catch(Exception e)
    {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if(args.length != 0)
        System.out.println("Invalid arguments on command line");

      try
      {
        point = getInput();
      }
      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }
    System.out.println("\nYou entered:\n" + point);
    point.convertStorageToCartesian();
    System.out.println("\nAfter asking to store as Cartesian:\n" + point);
    point.convertStorageToPolar();
    System.out.println("\nAfter converting Cartesian to Polar:\n" + point);

    //end timer
            long finish = System.currentTimeMillis();
            //time elapsed found + stored
            long timeElapsed = (finish-start);
            performanceTimes[i]=timeElapsed;
        }
        //finding max, min and sorting the array
        long maxTime = Arrays.stream(performanceTimes).max().getAsLong();
        long minTime = Arrays.stream(performanceTimes).min().getAsLong();
        Arrays.sort(performanceTimes);
        System.out.println(Arrays.toString(performanceTimes));
        System.out.println("After running " + numberOfInstances + " tests:\n"+ "The median time is: "+ performanceTimes[numberOfInstances/2] 
        +"\n The max time is: "+maxTime + "\n The min time is: "+minTime);  
    }            

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @return A PointCP constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static PointCP3 getInput() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    char coordType = 'A'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 1; i < 3; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid
        {
          System.out.println("Using Cartesian coordinates: ");
          System.out.print("Enter the value of " 
            + (coordType == 'C' 
              ? (i == 1 ? "X " : "Y ")
              : (i == 1 ? "X " : "Y ")) 
            + "using a decimal point(.): ");
        }

        // Get the user's input      
       
        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';        
             
        System.in.read(buffer);
        theInput = new String(buffer).trim();
        
        // Verify the user's input
        try
        {
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
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
    }
    //Return a new PointCP object
    return (new PointCP3(coordType, a, b));
  }
}


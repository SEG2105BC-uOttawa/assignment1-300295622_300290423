package design5;
import java.io.*;
public class PointCPTest5
{
  public static void main(String[] args){
    System.out.println("Cartesian-Polar Coordinates Conversion Program");
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
             
        System.in.read(buffer);
        theInput = new String(buffer).trim();
        
        // Verify the user's input
        try
        {
          if (i == 0) // First argument -- type of coordinates
          {
            if (!((theInput.toUpperCase().charAt(0) == 'C') 
              || (theInput.toUpperCase().charAt(0) == 'P')))
            {
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            }
            else
            {
              coordType = theInput.toUpperCase().charAt(0);
            }
          }
          else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
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
    catch(IOException ex)
    {
      System.out.println("Error getting input. Ending program.");
      return;
    }}}





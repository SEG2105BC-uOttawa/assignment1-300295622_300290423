package design5;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointCP3 extends PointCP5
{
  //Instance variables ************************************************
  
  /**
   * Contains the current value of X or RHO depending on the type
   * of coordinates.
   */
  //private double xOrRho;
  
  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  //private double yOrTheta;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP3(char type, double xOrRho, double yOrTheta)
  {
    super('C', xOrRho, yOrTheta);
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
    if (getType() == 'C'){
      return getxOrRho();
    }
    else{
      return (Math.cos(Math.toRadians(getyOrTheta())) * getxOrRho());
    }
    
  }
  
  public double getY()
  {
    if (getType() == 'C'){
      return getyOrTheta();
    }
    else{
      return (Math.sin(Math.toRadians(getyOrTheta())) * getxOrRho());
    }
    
  }

  public double getRho()
  {
    if (getType() == 'P'){
       return getxOrRho();
    }
    else{
      return (Math.sqrt(Math.pow(getxOrRho(), 2) + Math.pow(getyOrTheta(), 2)));
    }
   
  }
  
  public double getTheta()
  {
    if (getType() == 'P'){
      return getyOrTheta();
    }
    else{
      return Math.toDegrees(Math.atan2(getyOrTheta(), getxOrRho()));
    } 
  }

  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar()
  {
    if(getType() != 'P')
    {
      //Calculate RHO and THETA
      double temp = getRho();
      setyOrTheta(getTheta());
      setxOrRho(temp);
      
      setType('P'); //Change coord type identifier
    }
  }

  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public void convertStorageToCartesian()
  {
    if(getType() != 'C')
    {
      //Calculate X and Y
      double temp = getX();
      setyOrTheta(getY());
      setxOrRho(temp);
   
      setType('C');	//Change coord type identifier
    }
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP3 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP3('C',
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }
}

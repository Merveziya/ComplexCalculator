/**
 * @Author Merve Ziya
 * Represents a mathematical function.
 */
public interface Function{
  
  /**
   * Calculates the value of the function at the given input.
   * @param x as input
   */
  public double value(double x) ;
  
  /**
   * @throws UnsupportedOperationException if the function does not support value calculation
   */
  public double value();
 
  
 /**
   * Calculates the derivative of the function
   */
  public Function derivative();

}

/**
 * @Author Merve Ziya
 * Represents a number value
 */
public class Number implements Function{
 
  private double x;
 
  /**
   * Constructs a Number with the given value.
   * @param value the number value
   */
  public Number(double value) {
    this.x = value;
  }
  
  
  /**
   * Calculates the value of the number.
   * @param value the number value
   * @return the x value
   */
  @Override
  public double value(double x) {
    return x;
  }

  /**
   * Calculates the value of the number.
   * @return the x value
   */
  @Override
  public double value(){
    return x;
  }

  /**
   * Gets the value of x.
   * @return the value of x
   */
  public double getValue() {
    return x;
  }

 
  /**
   * Sets the value of x.
   * @param value the new value to set for x
   */
  public void setValue(double value) {
    this.x = value;
  }
 
  /**
   * Calculates the derivative of the number
   * @return a constant zero function because of the number's derivate is equal to 0.0
   */
  @Override
  public Function derivative(){
    return new Number(0.0); 
  }
  
 
  /**
   * @return the string representation of the number value as double
   */
  @Override
  public String toString() {
    return Double.toString(x);
  }
  
  /**
   * Checks if number is equal to the object.
   * @param obj the object to compare for equality
   * @return true if the objects are equal if it is not return false
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Number) {
       Number o = (Number) obj;
       return x == o.x;
    }
       return false;
    }

}
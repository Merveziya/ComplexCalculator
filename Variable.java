/**
 * @Author Merve Ziya
 * Represents a variable in function.
 * The value of the variable is set by the input provided to the function.
 */
public  class Variable  implements Function{
  
  private double x;
  
  /**
   * Constructs a new Variable object.
   */
  public Variable(){}
  
  /**
   * Calculates the value for a given input.
   * @param x as a input value
   * @return the value of the variable 
   * @throws UnsupportedOperationException if the value can't calculate
   */
  @Override
  public double value(double x) {
    return x;
  }
  
  /**
   * Calculates the value of the variable.
   * @return the x value
   */
  @Override
   public double value() {
     return value(x);
  }
 
  /**
   * Sets the value of x.
   * @param value the new value to set for x
   */
  public void setValue(double x) {
    this.x = x;
  }
  
  /**
   * Gets the value of x.
   * @return the value of x
   */
  public double getValue() {
    return x;
  }

  /**
   * Calculates the derivative of the variable.
   * @return a constant value of 1.0 the derivative of the variable 
   */
  @Override
  public Function derivative(){
    return new Number(1.0);
  }
  
  /**
   * @return the string "x" representing the variable
   */
  @Override
  public String toString(){
    return "x"; 
  }
  
  
  /**
   * Checks if number is equal to the object.
   * @param obj the object to be compared for equality
   * @return true if the objects are equal, if it's not return false
   */
  @Override
  public boolean equals(Object obj) {
    if(obj == null){
      return false;
    }
    if(!(obj instanceof Variable)){
      return false;
    }
    Variable other = (Variable) obj;
    return this.x == other.x;
  }
}
  
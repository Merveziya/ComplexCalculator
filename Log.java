import java.lang.Math;
/**
 * @Author Merve Ziya
 * Represents a polynomial function with operand and power.
 */
public  class Log implements Function {

    private Function operand;

    /**
     * Constructs a Polynomial with the given operand and power
     * @param operand of the polynomial
     * @param power of the polynomial
     */
    public Log(Function operand) {
      this.operand = operand;
    }

    /**
     * Calculates the value of the polynomial for a given input value.
     * @param x as input value
     * @return the value of the polynomial for input value
     */
    @Override
    public double value(double x){
        return Math.log10(operand.value(x));
    }
    
   
    /**
     * Calculates the value of the polynomial for a given input value.
     * @return the value of the polynomial for input value
     * @throws UnsupportedOperationException if the value cannot be calculated
     */ 
   @Override
    public double value()throws UnsupportedOperationException{
     if(operand.value()<=0 ){
       throw new UnsupportedOperationException("Can't calculate");
     }
     else
       return Math.log10(operand.value());
    
    }
    

    /**
     * Calculates the derivative of the polynomial.
     * @return the derivative of the polynomial as a BinaryOp Function
     */
    @Override
    public Function derivative() {
        return new BinaryOp(BinaryOp.Op.DIV, new Log(operand), operand.derivative());
    }
    
    /**
     * @return the operand of the polynomial
     */
    public Function getOperand() {
      return this.operand;
    }

    /**
     * @return a string representation of the polynomial
     */
    @Override
    public String toString() {
      return "Exp[" + operand.toString() + "]";
    }

   /**
     * Checks if the polynomial is equal to another object.
     * @param other object to be compared for equality
     * @return true if the polynomial is equal to the other object, if it's not return false
     */
    @Override
    public boolean equals(Object other) {
      if (other == null) {
        return false;
      }

      if (this == other) {
        return true;
       }

      if (!(other instanceof Log)) {
        return false;
      }

      Log log = (Log) other;
      return this.operand.equals(log.operand);
    }
}

/**
 * @Author Merve Ziya
 * Represents a polynomial function with a specified operand and power.
 */
public class Polynomial implements Function {
    private Function operand;
    private double power;
    private double x ;

    /**
     * Constructs a Polynomial with the given operand and power.
     * @param operand of the polynomial
     * @param power of the polynomial
     */
     public Polynomial(Function operand, double power) {
       this.operand = operand;
       this.power = power;
     }
    
    /**
     * Calculates the value of the polynomial 
     * @param x as input
     * @return the value of the polynomial for the given input value
     */
    @Override
     public double value(double x) {
       double result = Math.pow(operand.value(x), power);
       return result;
    }
    
    /**
     * Calculates the value of the polynomial 
     * @return the value of the polynomial for the given input value
     */
    public double value() {
      double operandValue = operand.value();
      return Math.pow(operandValue, power);
    }
   
   /**
    * @return the value of x
    */
   public double getValue(){
     return x;
    }
     
   /**
    * Calculates the derivative of the polynomial.
    * @return the derivative of the polynomial as a Function
    */
   @Override
   public Function derivative() {
    return new BinaryOp(BinaryOp.Op.MULT,
       new BinaryOp(BinaryOp.Op.MULT,
          new Number(power),
          new Polynomial(operand, power - 1)),
       operand.derivative());
   }

   /**
    * @return the operand of the polynomial
    */
   public Function getOperand() {
     return operand;
   }

   /**
    * @return the power of the polynomial
    */
   public double getPower() {
     return power;
   }

   /**
    * @return a string representation of the polynomial which operation is wanted
    */
   @Override
   public String toString() {
     return operand.toString() + "^" + power;
   }

   /**
    * Checks if the polynomial is equal to another object.
    * @param o object to be compared for equality
    * @return true if the polynomial is equal to the other object, if it's not return false
    */
   @Override
   public boolean equals(Object o) {
     if (o == null) {
       return false;
     }
     if (this == o) {
       return true;
     }
     if (!(o instanceof Polynomial)) {
       return false;
    }
     Polynomial isEqual = (Polynomial) o;
     return this.power == isEqual.power && this.operand.equals(isEqual.operand);
   }
}




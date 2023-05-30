/**
 * @Author Merve Ziya
 * Represents a binary operation in a mathematical function.
 */
public class BinaryOp  implements Function {
  /**
   *List of supported binary operators using nested type inside of the BinaryOp type.
   */
  public enum Op {
    PLUS,SUB,MULT,DIV;
  }
  
   protected final Op operator;
   private final Function leftOperand;
   private final Function rightOperand;
    
   /**
    * Constructs a new BinaryOp object.
    * @param operator of the binary operator
    * @param leftOperand of the left operand
    * @param rightOperand of the right operand
    */
    public BinaryOp(Op operator, Function leftOperand, Function rightOperand) {
      this.operator = operator;
      this.leftOperand = leftOperand;
      this.rightOperand = rightOperand;
    }
    
  
   /**
    * Retrieves the operator of the operation.
    * @return the operator
    */
    public Op getOperator() {
      return operator;
    }
    
   /**
    * Retrieves the left operand of the operation.
    * @return the left operand
    */
    public Function getLeftOperand() {
      return leftOperand;
    }
    
   /**
    * Retrieves the right operand of the operation.
    * @return the right operand
    */
    public Function getRightOperand() {
      return rightOperand;
    }
    
   /**
    * Calculates the value of the binary operation for input.
    * @param x is input 
    * @return the result of the binary operation
    */
   public double value(double x) {
        return x;
    }
        switch (operator) {
            case PLUS:
                return x + x ;
            case SUB:
                return x - x ;
            case MULT:
                return x * x ;
            case DIV:
                if (x== 0) {
                    throw new UnsupportedOperationException("Division by zero is not allowed.");
                }
                return x / x;
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }

   /**
    * Calculates the value of the binary operation for input.
    * @return the result of the binary operation
    */
    public double value() {
        double leftValue = (double)getLeftOperand().value();
        double rightValue = (double)getRightOperand().value();
        
        switch (operator) {
            case PLUS:
                return leftValue + rightValue ;
            case SUB:
                return leftValue - rightValue ;
            case MULT:
                return leftValue * rightValue ;
            case DIV:
                if (rightValue == 0) {
                    throw new UnsupportedOperationException("Division by zero is not allowed.");
                }
                return leftValue / rightValue;
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }

    
    
    /**
     * Calculates the derivative of the operation.
     * @return the derivative of the operation
     */
    @Override
    public Function derivative() {
         switch (operator) {
            case PLUS:
                return new BinaryOp(Op.PLUS, leftOperand.derivative(), rightOperand.derivative());
            case SUB:
                return new BinaryOp(Op.SUB, leftOperand.derivative(), rightOperand.derivative());
            case MULT:
                return new BinaryOp(Op.PLUS, new BinaryOp(Op.MULT, leftOperand.derivative(), rightOperand), new BinaryOp(Op.MULT, leftOperand, rightOperand.derivative()));
            case DIV:
                return new BinaryOp(Op.DIV, new BinaryOp(Op.SUB, rightOperand.derivative(), new BinaryOp(Op.MULT, rightOperand, rightOperand)), leftOperand);
            default:
                throw new UnsupportedOperationException();
          }
     }
    
    
   /**
    *  Checks if number is equal to the object.
    * @param o the object to be compared for equality
    * @return true if the objects are equal, if it's not return false
    */
    @Override
    public boolean equals(Object o) {
      if (o == null) {
        return false;
      }
      if (this == o) {
        return true;
       }
      if (!(o instanceof BinaryOp)) {
        return false;
       }

      BinaryOp binaryOp = (BinaryOp) o;

      return this.operator == binaryOp.operator &&
         this.leftOperand.equals(binaryOp.leftOperand) &&
         this.rightOperand.equals(binaryOp.rightOperand);
      }

    
   /**
    * @return the string representation of the number value as double
    */
    @Override
    public String toString() {
      switch (this.operator) {
        case PLUS:
            return "(" + this.leftOperand + " + " + this.rightOperand + ")";
        case SUB:
            return "(" + this.leftOperand + " - " + this.rightOperand + ")";
        case MULT:
            return "(" + this.leftOperand + " * " + this.rightOperand + ")";
        case DIV:
            return "(" + this.leftOperand + " / " + this.rightOperand + ")";
        default:
            return this.leftOperand + " " + this.operator + " " + this.rightOperand;
       }
     }
}
package Instructions;

import Operands.BasicOperand;

public interface Instruction {
  public void operate();
  public BasicOperand getOperand();
}

package Instructions;

import Operands.BasicOperand;

public class HaltInstruction implements Instruction {
  public void operate() {
    System.out.println("Program finished.");
  }
  public BasicOperand getOperand() {
    return null;
  }
}

package Instructions;

import Operands.BasicOperand;

public class HaltInstruction implements Instruction {
  public void operate() {
    System.out.println("Programa terminado");
  }
  public BasicOperand getOperand() {
    return null;
  }
}

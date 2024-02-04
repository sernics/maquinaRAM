package Instructions;
import Operands.*;
import ProgramMemory.ProgramMemory;
import Registers.*;

public class JumpInstruction implements Instruction {
  public JumpInstruction(ProgramMemory programMemory, BasicOperand operand, RegisterBank registerBank) {
    this.programMemory = programMemory;
    this.operand = operand;
    this.registerBank = registerBank;
  }
  public void operate() {
    programMemory.setHead(operand.getAddress(registerBank));
  }
  private ProgramMemory programMemory;
  private BasicOperand operand;
  private RegisterBank registerBank;
}

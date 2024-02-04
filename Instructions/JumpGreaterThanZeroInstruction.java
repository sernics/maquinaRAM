package Instructions;
import Operands.*;
import ProgramMemory.ProgramMemory;
import Registers.*;

public class JumpGreaterThanZeroInstruction implements Instruction{
  public JumpGreaterThanZeroInstruction(ProgramMemory programMemory, BasicOperand operand, RegisterBank registerBank) {
    this.programMemory = programMemory;
    this.operand = operand;
    this.registerBank = registerBank;
  }
  public void operate() {
    if (registerBank.getRegister(0).getValue() > 0) {
      programMemory.setHead(operand.getAddress(registerBank));
    }
  }
  private ProgramMemory programMemory;
  private BasicOperand operand;
  private RegisterBank registerBank;
}
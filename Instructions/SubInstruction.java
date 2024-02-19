package Instructions;

import Operands.BasicOperand;
import Registers.IntegerRegister;
import Registers.RegisterBank;

public class SubInstruction implements Instruction {
  public SubInstruction(RegisterBank registerBank, BasicOperand operand) {
    this.registerBank = registerBank;
    this.operand = operand;
  }
  public void operate() {
    registerBank.putRegister(
      0, 
      new IntegerRegister(registerBank.getRegisterValue(0, this.operand.getArrayIndex(registerBank)) - operand.getValue(registerBank))
    );
  }
  public BasicOperand getOperand() {
    return operand;
  }
  private RegisterBank registerBank;
  private BasicOperand operand;
}
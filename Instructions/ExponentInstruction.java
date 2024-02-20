package Instructions;

import Operands.BasicOperand;
import Registers.IntegerRegister;
import Registers.RegisterBank;

public class ExponentInstruction implements Instruction {
  public ExponentInstruction(RegisterBank registerBank, BasicOperand operand) {
    this.registerBank = registerBank;
    this.operand = operand;
  }
  public void operate() {
    Double value = Math.pow(registerBank.getRegisterValue(0, this.operand.getArrayIndex(registerBank)), operand.getValue(registerBank));
    registerBank.putRegister(
      0, 
      new IntegerRegister(value.intValue())
    );
  }
  public BasicOperand getOperand() {
    return operand;
  }
  private RegisterBank registerBank;
  private BasicOperand operand;
}

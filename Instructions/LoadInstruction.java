package Instructions;
import Registers.*;
import Operands.*;

public class LoadInstruction implements Instruction {
  public LoadInstruction(RegisterBank registerBank, BasicOperand operand) {
    this.registerBank = registerBank;
    this.operand = operand;
  }
  public void operate () {
    registerBank.putRegister(0, new IntegerRegister(operand.getValue(registerBank)));
  }
  private RegisterBank registerBank;
  private BasicOperand operand;
}

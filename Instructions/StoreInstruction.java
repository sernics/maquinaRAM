package Instructions;
import Registers.*;
import Operands.*;

public class StoreInstruction implements Instruction {
  public StoreInstruction(RegisterBank registerBank, BasicOperand operand) {
    this.registerBank = registerBank;
    this.operand = operand;
  }
  public void operate () {
    // Save on operand address the value of r0
    registerBank.putRegister(operand.getAddress(registerBank), registerBank.getRegister(0));
  }
  public BasicOperand getOperand() {
    return operand;
  }
  private RegisterBank registerBank;
  private BasicOperand operand;
}

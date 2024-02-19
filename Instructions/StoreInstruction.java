package Instructions;
import Registers.*;
import Operands.*;

public class StoreInstruction implements Instruction {
  public StoreInstruction(RegisterBank registerBank, BasicOperand operand) {
    this.registerBank = registerBank;
    this.operand = operand;
  }
  public void operate () {
    if (operand.isArray()) {
      System.out.println("Es un array");
      registerBank.putArrayValue(operand.getArrayIndex(registerBank), registerBank.getRegister(0).getValue());
    } else {
      registerBank.putRegister(operand.getAddress(registerBank), registerBank.getRegister(0));
    }
  }
  public BasicOperand getOperand() {
    return operand;
  }
  private RegisterBank registerBank;
  private BasicOperand operand;
}

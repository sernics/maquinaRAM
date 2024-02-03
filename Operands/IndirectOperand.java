package Operands;
import Registers.*;

public class IndirectOperand implements BasicOperand {
  public IndirectOperand(int value) {
    this.value = value;
  }
  public int getValue(RegisterBank registerBank) {
    Register register = registerBank.getRegister(value);
    return registerBank.getRegister(register.getValue()).getValue();
  }
  public int getAddress(RegisterBank registerBank) {
    return registerBank.getRegister(value).getValue();
  }
  private int value;
}

package Operands;
import Registers.*;

public class IndirectOperand implements BasicOperand {
  public IndirectOperand(int value) {
    this.value = value;
  }
  public int getValue(RegisterBank dataMemory) {
    Register register = dataMemory.getRegister(value);
    return dataMemory.getRegister(register.getValue()).getValue();
  }
  private int value;
}

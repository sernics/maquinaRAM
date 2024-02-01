package Operands;
import RegisterBank.*;

public class IndirectOperand implements BasicOperand {
  public IndirectOperand(int value) {
    this.value = value;
  }
  public int getValue(DataMemory dataMemory) {
    Register register = dataMemory.getRegister(value);
    return dataMemory.getRegister(register.getValue()).getValue();
  }
  private int value;
}

package Operands;

import Registers.RegisterBank;

public class ArrayOperand implements BasicOperand {
  public ArrayOperand(int value, BasicOperand index) {
    this.value = value;
    this.index = index;
  }
  public int getValue(RegisterBank registerBank) {
    return registerBank.getRegister(value).getValue(index.getAddress(registerBank));
  }
  public int getAddress(RegisterBank registerBank) {
    return value;
  }
  public Boolean isArray() {
    return true;
  }
  private Integer value;
  private BasicOperand index;
}

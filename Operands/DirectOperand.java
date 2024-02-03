package Operands;

import Registers.RegisterBank;

public class DirectOperand implements BasicOperand {
  public DirectOperand(int value) {
    this.value = value;
  }
  public int getValue(RegisterBank registerBank) {
    return registerBank.getRegister(value).getValue();
  }
  public int getAddress(RegisterBank registerBank) {
    return value;
  }
  private int value;
}

package Operands;

import Registers.RegisterBank;

public class DirectOperand implements BasicOperand {
  public DirectOperand(int value) {
    this.value = value;
  }
  public int getValue(RegisterBank dataMemory) {
    return dataMemory.getRegister(value).getValue();
  }
  private int value;
}

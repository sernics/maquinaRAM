package Operands;

import RegisterBank.DataMemory;

public class DirectOperand implements BasicOperand {
  public DirectOperand(int value) {
    this.value = value;
  }
  public int getValue(DataMemory dataMemory) {
    return dataMemory.getRegister(value).getValue();
  }
  private int value;
}

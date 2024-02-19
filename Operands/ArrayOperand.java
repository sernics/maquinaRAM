package Operands;

import Registers.RegisterBank;

public class ArrayOperand implements BasicOperand {
  public ArrayOperand(int value, BasicOperand index) {
    this.value = value;
    this.index = index;
  }

  public int getValue(RegisterBank registerBank) {
    Integer solvedIndex = index.getAddress(registerBank);
    return registerBank.getRegister(value).getValue(solvedIndex);
  }

  public int getAddress(RegisterBank registerBank) {
    return value;
  }

  public Boolean isArray() {
    return true;
  }

  public Integer getArrayIndex(RegisterBank registerBank) {
    return index.getAddress(registerBank);
  }

  private Integer value;
  private BasicOperand index;
}

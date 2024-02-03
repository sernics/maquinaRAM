package Operands;
import Registers.*;

public class InmediateOperand implements BasicOperand {
  public InmediateOperand(int value) {
    this.value = value;
  }
  public int getValue(RegisterBank registerBank) {
    return value;
  }
  public int getAddress(RegisterBank registerBank) {
    return value;
  }
  private int value;
}

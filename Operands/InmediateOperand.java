package Operands;
import Registers.*;

public class InmediateOperand implements BasicOperand {
  public InmediateOperand(int value) {
    this.value = value;
  }
  public int getValue(RegisterBank dataMemory) {
    return value;
  }
  private int value;
}

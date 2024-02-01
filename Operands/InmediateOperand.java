package Operands;
import RegisterBank.*;

public class InmediateOperand implements BasicOperand {
  public InmediateOperand(int value) {
    this.value = value;
  }
  public int getValue(DataMemory dataMemory) {
    return value;
  }
  private int value;
}

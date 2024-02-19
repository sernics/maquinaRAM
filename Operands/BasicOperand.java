package Operands;
import Registers.*;

public interface BasicOperand {
  public int getValue(RegisterBank registerBank);
  public int getAddress(RegisterBank registerBank);
  public default Boolean isArray() {
    return false;
  }
  public default Integer getArrayIndex(RegisterBank registerBank) {
    return null;
  }
}
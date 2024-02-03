package Operands;
import Registers.*;

public interface BasicOperand {
  public int getValue(RegisterBank registerBank);
  public int getAddress(RegisterBank registerBank);
}
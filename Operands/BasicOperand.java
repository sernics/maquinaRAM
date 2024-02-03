package Operands;
import Registers.*;

public interface BasicOperand {
  public int getValue(RegisterBank dataMemory);
}
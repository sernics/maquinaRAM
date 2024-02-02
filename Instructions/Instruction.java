package Instructions;
import RegisterBank.DataMemory;
import ProgramData.Operator;
import Operands.*;
import Tapes.*;
import ProgramData.ProgramMemory;

public interface Instruction {
  public default void execute(DataMemory dataMemory) {
    throw new UnsupportedOperationException("executeUnsopported");
  }
  public default void execute(Tape tape, DataMemory dataMemory) {
    throw new UnsupportedOperationException("executeUnsopported");
  }
  public default void execute() {
    throw new UnsupportedOperationException("executeUnsopported");
  }
  public default void execute(ProgramMemory programMemory, DataMemory dataMemory) {
    throw new UnsupportedOperationException("executeUnsopported");
  }
  public Operator getOperator();
  public default BasicOperand getOperand() {
    throw new UnsupportedOperationException("getOperandUnsopported");
  }
  public default Boolean isJump() {
    return false;
  }
  public default Boolean isHalt() {
    return false;
  }
  public default Boolean useTape() {
    return false;
  }
}

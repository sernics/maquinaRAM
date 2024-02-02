package Instructions;
import RegisterBank.DataMemory;
import ProgramData.Operator;
import Operands.*;

public interface Instruction {
  public default void execute(DataMemory dataMemory) {
    throw new UnsupportedOperationException("executeUnsopported");
  }
  public Operator getOperator();
  public BasicOperand getOperand();
  public default int getLabelIndex() {
    throw new UnsupportedOperationException("getLabelIndexUnsopported");
  }
  public default Boolean isJump() {
    return false;
  }
}

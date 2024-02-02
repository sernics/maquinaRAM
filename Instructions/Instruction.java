package Instructions;
import RegisterBank.DataMemory;
import ProgramData.Operator;
import Operands.*;

public interface Instruction {
  public void execute(DataMemory dataMemory);
  public Operator getOperator();
  public BasicOperand getOperand();
  public default int getLabelIndex() {
    throw new UnsupportedOperationException("getLabelIndexUnsopported");
  }
  public default Boolean isJump() {
    return false;
  }
}

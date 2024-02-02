package Instructions;
import RegisterBank.DataMemory;
import ProgramData.Label;
import Operands.*;

public interface Instruction {
  public void execute(DataMemory dataMemory);
  public Label getLabel();
  public BasicOperand getOperand();
  public default int getLabelIndex() {
    throw new UnsupportedOperationException("getLabelIndexUnsopported");
  }
  public default Boolean isJump() {
    return false;
  }
}

package Instructions;
import RegisterBank.*;
import ProgramData.Label;
import Operands.*;

public class AddInstruction implements Instruction {
  public AddInstruction() {
  }
  public void execute(DataMemory dataMemory) {
    Register register0 = dataMemory.getRegister(0);
    register0.setValue(register0.getValue() + operand.getValue(dataMemory));
    dataMemory.putRegister(0, register0);
  }
  public Label getLabel() {
    return label;
  }
  public BasicOperand getOperand() {
    return operand;
  }
  private Label label;
  private BasicOperand operand;
}

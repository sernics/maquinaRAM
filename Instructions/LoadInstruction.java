package Instructions;
import Operands.BasicOperand;
import ProgramData.Label;
import RegisterBank.*;

public class LoadInstruction implements Instruction {
  public void execute(DataMemory dataMemory) {
    Register register = new IntegerRegister();
    register.setValue(operand.getValue(dataMemory));
    dataMemory.putRegister(0, register);
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

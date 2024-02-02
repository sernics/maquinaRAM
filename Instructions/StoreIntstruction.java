package Instructions;

import Operands.BasicOperand;
import ProgramData.Label;
import RegisterBank.DataMemory;
import RegisterBank.IntegerRegister;
import RegisterBank.Register;

public class StoreIntstruction implements Instruction {
  public StoreIntstruction(Label label, BasicOperand operand) {
    this.label = label;
    this.operand = operand;
  }
  public void execute(DataMemory dataMemory) {
    Register register = new IntegerRegister();
    register.setValue(operand.getValue(dataMemory));
    dataMemory.putRegister(dataMemory.getRegister(0).getValue(), register);
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

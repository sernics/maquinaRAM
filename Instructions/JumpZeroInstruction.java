package Instructions;
import ProgramData.*;
import RegisterBank.DataMemory;

public class JumpZeroInstruction implements Instruction {
  public JumpZeroInstruction(Label label, Operator operator) {
    this.label = label;
    this.operator = operator;
  }
  public void execute(ProgramMemory programMemory, DataMemory dataMemory) {
    if (dataMemory.containsRegister(0))
      programMemory.setProgramCounter(programMemory.getLabelPosition(label));
  }
  public Label getLabel() {
    return label;
  }
  public Operator getOperator() {
    return operator;
  }
  Operator operator;
  Label label;
}


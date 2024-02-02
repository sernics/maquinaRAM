package Instructions;
import ProgramData.*;

public class JumpInstruction implements Instruction {
  public JumpInstruction(Label label, Operator operator) {
    this.label = label;
    this.operator = operator;
  }
  public void execute(ProgramMemory programMemory) {
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


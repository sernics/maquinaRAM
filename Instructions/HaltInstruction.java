package Instructions;
import ProgramData.Operator;

public class HaltInstruction implements Instruction {
  public HaltInstruction(Operator operator) {
    this.operator = operator;
  }
  public Operator getOperator() {
    return operator;
  }
  public void execute() {
    System.exit(0);
  }
  public Boolean isHalt() {
    return true;
  }
  Operator operator;
}

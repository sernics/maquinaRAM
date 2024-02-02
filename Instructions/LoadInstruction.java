package Instructions;
import Operands.BasicOperand;
import ProgramData.Operator;
import RegisterBank.*;

public class LoadInstruction implements Instruction {
  public LoadInstruction(Operator operator, BasicOperand operand) {
    this.operator = operator;
    this.operand = operand;
  }
  public void execute(DataMemory dataMemory) {
    Register register = new IntegerRegister();
    register.setValue(operand.getValue(dataMemory));
    dataMemory.putRegister(0, register);
  }
  public Operator getOperator() {
    return operator;
  }
  public BasicOperand getOperand() {
    return operand;
  }
  private Operator operator;
  private BasicOperand operand;
}

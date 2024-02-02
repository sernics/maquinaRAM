package Instructions;
import RegisterBank.*;
import ProgramData.Operator;
import Operands.*;

public class DivInstruction implements Instruction {
  public DivInstruction(Operator operator, BasicOperand operand) {
    this.operator = operator;
    this.operand = operand;
  }
  public void execute(DataMemory dataMemory) {
    Register register0 = dataMemory.getRegister(0);
    register0.setValue(register0.getValue() / operand.getValue(dataMemory));
    dataMemory.putRegister(0, register0);
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


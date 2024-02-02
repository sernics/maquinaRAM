package Instructions;

import Operands.BasicOperand;
import ProgramData.Operator;
import RegisterBank.DataMemory;
import RegisterBank.IntegerRegister;
import RegisterBank.Register;

public class StoreInstruction implements Instruction {
  public StoreInstruction(Operator operator, BasicOperand operand) {
    this.operator = operator;
    this.operand = operand;
  }
  public void execute(DataMemory dataMemory) {
    Register register = new IntegerRegister();
    register.setValue(operand.getValue(dataMemory));
    dataMemory.putRegister(dataMemory.getRegister(0).getValue(), register);
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

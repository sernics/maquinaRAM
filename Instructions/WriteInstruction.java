package Instructions;

import Operands.BasicOperand;
import ProgramData.Operator;
import RegisterBank.DataMemory;
import Tapes.*;

public class WriteInstruction implements Instruction {
  public WriteInstruction(Operator operator, BasicOperand operand) {
    this.operator = operator;
    this.operand = operand;
  }
  public void execute(Tape tape, DataMemory dataMemory) {
    tape.write(operand.getValue(dataMemory));
  }
  public Operator getOperator() {
    return operator;
  }
  public BasicOperand getOperand() {
    return operand;
  }
  public Boolean useTape() {
    return true;
  }
  private Operator operator;
  private BasicOperand operand;
}

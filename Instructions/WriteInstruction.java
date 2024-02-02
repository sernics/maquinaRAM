package Instructions;

import Operands.BasicOperand;
import ProgramData.Operator;
import RegisterBank.DataMemory;
import RegisterBank.IntegerRegister;
import RegisterBank.Register;
import Tapes.*;

public class WriteInstruction implements Instruction {
  public WriteInstruction(Operator operator, BasicOperand operand) {
    this.operator = operator;
    this.operand = operand;
  }
  public void execute(Tape outpuTape, DataMemory dataMemory) {
    outpuTape.write(operand.getValue(dataMemory));
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

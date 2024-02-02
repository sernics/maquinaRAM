package Instructions;

import Operands.BasicOperand;
import ProgramData.Operator;
import RegisterBank.DataMemory;
import RegisterBank.IntegerRegister;
import RegisterBank.Register;
import Tapes.*;

public class ReadInstruction implements Instruction {
  public ReadInstruction(Operator operator, BasicOperand operand) {
    this.operator = operator;
    this.operand = operand;
  }
  public void execute(Tape tape, DataMemory dataMemory) {
    Register register = new IntegerRegister(tape.read());
    dataMemory.putRegister(operand.getValue(dataMemory), register);
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

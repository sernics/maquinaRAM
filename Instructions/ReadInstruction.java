package Instructions;

import Operands.BasicOperand;
import Operands.InmediateOperand;
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
    dataMemory.putRegister(0, new IntegerRegister(tape.read()));
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

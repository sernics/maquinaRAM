package Instructions;
import Tapes.*;
import Registers.*;
import Operands.*;

public class ReadInstruction implements Instruction {
  public ReadInstruction(Tape tape, RegisterBank registerBank, BasicOperand operand) {
    this.tape = tape;
    this.registerBank = registerBank;
    this.operand = operand;
  }
  public void operate() {
    this.registerBank.putRegister(this.operand.getAddress(registerBank), new IntegerRegister(this.tape.read()));
  }
  public BasicOperand getOperand() {
    return operand;
  }
  private Tape tape;
  private RegisterBank registerBank;
  private BasicOperand operand;
}
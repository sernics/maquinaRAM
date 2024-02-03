package Instructions;
import Tapes.*;
import Registers.*;
import Operands.*;


public class WriteInstruction implements Instruction {
  public WriteInstruction(Tape tape, RegisterBank registerBank, BasicOperand operand) {
    this.tape = tape;
    this.registerBank = registerBank;
    this.operand = operand;
  }
  public void operate() {
    this.tape.write(this.registerBank.getRegisterValue(this.operand.getAddress(registerBank)));
  }
  private Tape tape;
  private RegisterBank registerBank;
  private BasicOperand operand;
}

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
    Integer address = this.operand.getAddress(registerBank);
    this.tape.write(this.registerBank.getRegisterValue(address, this.operand.getArrayIndex(registerBank)));
  }

  public BasicOperand getOperand() {
    return operand;
  }

  private Tape tape;
  private RegisterBank registerBank;
  private BasicOperand operand;
}

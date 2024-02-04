import Tapes.*;
import Operands.*;
import Registers.*;
import Instructions.*;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Tape tape = new InputTape("./inputs/input.txt");
    RegisterBank registerBank = new RegisterBank();
    BasicOperand operand = new DirectOperand(0);
    Instruction instruction = new ReadInstruction(tape, registerBank, operand);
    
  }
}

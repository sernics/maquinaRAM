import Tapes.*;
import Operands.*;
import Registers.*;
import Instructions.*;
import ProgramMemory.ProgramMemory;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Tape tape = new InputTape("./inputs/input.txt");
    RegisterBank registerBank = new RegisterBank();
    BasicOperand operand = new DirectOperand(0);
    Instruction instruction = new ReadInstruction(tape, registerBank, operand);
    ProgramMemory programMemory = new ProgramMemory();
    programMemory.add(instruction);
    programMemory.add(instruction);
    operand = new InmediateOperand(4);
    instruction = new JumpInstruction(programMemory, operand, registerBank);
    programMemory.add(instruction);
    operand = new DirectOperand(0);
    instruction = new AddInstruction(registerBank, operand);
    programMemory.add(instruction);
    instruction = new HaltInstruction();
    programMemory.add(instruction);
    while (true) {
      System.out.println(programMemory.getHead());
      instruction = programMemory.read();
      instruction.operate();
    }
  }
}

import Tapes.*;
import Operands.*;
import Registers.*;
import Instructions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Instructions.ReadInstruction;

public class Programa {
  public static void main(String[] args) {
    Tape tape = new InputTape("./inputs/input.txt");
    RegisterBank registerBank = new RegisterBank();
    BasicOperand operand = new DirectOperand(0);
    Instruction instruction = new ReadInstruction(tape, registerBank, operand);
    instruction.operate();
    instruction.operate();
    instruction.operate();
    instruction.operate();
    operand = new DirectOperand(1);
    instruction = new ReadInstruction(tape, registerBank, operand);
    instruction.operate();
    // Imprimir r0
    System.out.println(registerBank.getRegister(0).getValue());
    // Imprimir r1
    System.out.println(registerBank.getRegister(1).getValue());
  }
}

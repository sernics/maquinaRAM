import Tapes.*;
import Operands.*;
import Registers.*;
import Instructions.*;

import java.util.ArrayList;

public class Programa {
  public static void main(String[] args) {
    Tape tape = new InputTape("./inputs/input.txt");
    RegisterBank registerBank = new RegisterBank();
    BasicOperand operand = new DirectOperand(0);
    Instruction instruction = new ReadInstruction(tape, registerBank, operand);
    instruction.operate();
    instruction.operate();
    // Imprimir r0
    System.out.println(registerBank.getRegisterValue(0));
    operand = new DirectOperand(1);
    instruction = new ReadInstruction(tape, registerBank, operand);
    instruction.operate();
    // Imprimir r1
    System.out.println(registerBank.getRegisterValue(1));
    instruction = new AddInstruction(registerBank, operand);
    instruction.operate();
    // Imprimir r0
    System.out.println(registerBank.getRegisterValue(0));
    instruction = new SubInstruction(registerBank, operand);
    instruction.operate();
    // Imprimir r0
    System.out.println(registerBank.getRegisterValue(0));
    operand = new DirectOperand(1);
    instruction = new MulInstruction(registerBank, operand);
    instruction.operate();
    // Imprimir r0
    System.out.println(registerBank.getRegisterValue(0));
    instruction = new HaltInstruction();
    instruction.operate();
    operand = new InmediateOperand(2);
    instruction = new DivInstruction(registerBank, operand);
    instruction.operate();
    // Imprimir r0
    System.out.println(registerBank.getRegisterValue(0));
  }
}

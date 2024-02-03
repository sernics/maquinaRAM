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
    instruction.operate();
    instruction.operate();
    operand = new DirectOperand(1);
    instruction = new ReadInstruction(tape, registerBank, operand);
    instruction.operate();
    // Imprimir r0
    System.out.println("r0: " + registerBank.getRegister(0).getValue());
    // Imprimir r1
    System.out.println("r1: " + registerBank.getRegister(1).getValue());
    Tape outputTape = new OutputTape();
    instruction = new WriteInstruction(outputTape, registerBank, new DirectOperand(0));
    instruction.operate();
    operand = new DirectOperand(1);
    instruction = new LoadInstruction(registerBank, operand);
    instruction.operate();
    // Imprimir r0
    System.out.println("r0: " + registerBank.getRegister(0).getValue());
    ArrayList<Integer> values = outputTape.getTape();
    operand = new DirectOperand(3);
    instruction = new StoreInstruction(registerBank, operand);
    instruction.operate();
    // Imprimir r3
    System.out.println("r3: " + registerBank.getRegister(3).getValue());
    System.out.print("Output tape: ");
    for (int i = 0; i < values.size(); i++) {
      System.out.println(values.get(i));
    }
    System.out.println("End of program");
  }
}

import Tapes.*;
import RegisterBank.*;
import Operands.*;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import Instructions.*;
import ProgramData.*;

public class Programa {
  public static void main(String[] args) {
    Tape inputTape = new InputTape("./inputs/input.txt");
    Tape outputTape = new OutputTape();
    DataMemory dataMemory = new DataMemory();
    Instruction instruction = new ReadInstruction(new Operator("READ"), new DirectOperand(0));
    instruction.execute(outputTape, dataMemory);
  }
}

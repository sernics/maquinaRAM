import java.util.ArrayList;

import Instructions.WriteInstruction;
import Registers.RegisterBank;
import Operands.ArrayOperand;
import Operands.BasicOperand;
import Operands.DirectOperand;
import Operands.IndirectOperand;
import Operands.InmediateOperand;
import Tapes.Tape;
import Instructions.Instruction;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> aleatoryNumbers = new ArrayList<Integer>();
    for (int i = 0; i < 9; i++) {
      // Generar 9 números aleatorios
      aleatoryNumbers.add((int) (Math.random() * 100) + 1);
    }
    RamMachine ramMachine = new RamMachine("test/insertion.ram", "inputs/input.txt", "outputs/output.txt");
    ramMachine.setArray(aleatoryNumbers);
    ramMachine.run(2);
    RegisterBank registerBank = ramMachine.getRegisterBank();
    BasicOperand operand = parseOperand("R1[*0]");
    Tape outputTape = ramMachine.getOutputTape();
    Instruction writeInstruction = new WriteInstruction(outputTape, registerBank, operand);
    writeInstruction.operate();
    // RamMachine ramMachine = new RamMachine("test/test7.ram", "inputs/input.txt", "outputs/output.txt");
    // ramMachine.run(2);
  }

  private static Boolean isOperand(String value) {
    return value.charAt(0) == '=' || value.charAt(0) == '*' || Character.isDigit(value.charAt(0)) || value.matches("R\\d+\\[(=|\\*)?\\d+\\]");
  }

  public static BasicOperand parseOperand(String value) {
    if (value.charAt(0) == '=') {
      return new InmediateOperand(Integer.parseInt(value.substring(1)));
    } else if (value.charAt(0) == '*') {
      return new IndirectOperand(Integer.parseInt(value.substring(1)));
    } else if (value.matches("R\\d+\\[(=|\\*)?\\d+\\]")) {
      String[] parts = value.split("\\[");
      String register = parts[0];
      String index = parts[1].substring(0, parts[1].length() - 1);
      return new ArrayOperand(Integer.parseInt(register.substring(1)), parseOperand(index));
    }
    else {
      return new DirectOperand(Integer.parseInt(value));
    }
  }
}

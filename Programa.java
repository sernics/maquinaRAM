import Tapes.*;
import RegisterBank.*;
import Operands.*;
import java.util.ArrayList;
import java.util.Random;

public class Programa {
  public static void main(String[] args) {
    Tape input = new InputTape("inputs/input.txt");
    // Imprimir input
    System.out.println("Input:");
    ArrayList<Integer> tape = input.getTape();
    for (int i = 0; i < tape.size(); i++) {
      System.out.println(tape.get(i));
    }
    Tape output = new OutputTape();
    // Escribir output
    output.write(1);
    output.write(2);
    output.write(3);
    // Imprimir output
    System.out.println("Output:");
    tape = output.getTape();
    for (int i = 0; i < tape.size(); i++) {
      System.out.println(tape.get(i));
    }
    DataMemory dataMemory = new DataMemory();
    for (int i = 0; i < 10; i++) {
      Register register = new IntegerRegister();
      // Numero random entre el 0 y el 10
      Random random = new Random();
      Integer j = random.nextInt(10);
      register.setValue(j);
      dataMemory.putRegister(i, register);
    }
    // Imprimir dataMemory
    System.out.println("DataMemory:");
    for (int i = 0; i < 10; i++) {
      if (dataMemory.containsRegister(i)) {
        System.out.println(dataMemory.getRegister(i).getValue());
      } else {
        System.out.println("null");
      }
    }
    BasicOperand operand = new InmediateOperand(5);
    System.out.println("InmediateOperand:");
    System.out.println(operand.getValue(dataMemory));
    operand = new DirectOperand(5);
    System.out.println("DirectOperand:");
    System.out.println(operand.getValue(dataMemory));
    operand = new IndirectOperand(5);
    System.out.println("IndirectOperand:");
    System.out.println(operand.getValue(dataMemory));
  }
}

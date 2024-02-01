import Tapes.*;
import RegisterBank.*;
import java.util.ArrayList;


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
    Register register = new IntegerRegister();
    register.setValue(10);
    dataMemory.putRegister(0, register);
    register.setValue(11);
    // Imprimir dataMemory
    System.out.println("DataMemory:");
    for (int i = 0; i < 10; i++) {
      if (dataMemory.containsRegister(i)) {
        System.out.println(dataMemory.getRegister(i).getValue());
      } else {
        System.out.println("null");
      }
    }
  }
}

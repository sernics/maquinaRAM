import Tapes.*;
import RegisterBank.*;


public class Programa {
  public static void main(String[] args) {
    Tape input = new InputTape("inputs/input.txt");
    // Imprimir input
    System.out.println("Input:");
    while (input.hasNext()) {
      System.out.println(input.read());
    }
    Tape output = new OutputTape();
    // Escribir output
    output.write(1);
    output.write(2);
    output.write(3);
    // Imprimir output
    System.out.println("Output:");
    while (output.hasNext()) {
      System.out.println(output.read());
    }
    DataMemory dataMemory = new DataMemory();
    IntegerRegister register = new IntegerRegister();
    register.setValue(10);
    dataMemory.putRegister(0, register);
    register.setValue(100);
    dataMemory.putRegister(0, register);
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

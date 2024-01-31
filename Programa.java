import Tapes.*;


public class Programa {
  public static void main(String[] args) {
    InputTape input = new InputTape("inputs/input.txt");
    // Imprimir input
    System.out.println("Input:");
    while (input.hasNext()) {
      System.out.println(input.read());
    }
    OutputTape output = new OutputTape();
    // Escribir output
    output.write(1);
    output.write(2);
    output.write(3);
    // Imprimir output
    System.out.println("Output:");
    while (output.hasNext()) {
      System.out.println(output.read());
    }
  }
}

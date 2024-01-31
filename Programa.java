import Tapes.*;


public class Programa {
  public static void main(String[] args) {
    InputTape input = new InputTape("input.txt");
    // Imprimir input
    System.out.println("Input:");
    while (input.hasNext()) {
      System.out.println(input.read());
    }
  }
}

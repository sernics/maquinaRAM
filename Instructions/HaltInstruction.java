package Instructions;

public class HaltInstruction implements Instruction {
  public void operate() {
    System.out.println("Programa terminado");
    System.exit(0);
  }
}

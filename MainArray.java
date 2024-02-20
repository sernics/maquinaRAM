import java.util.ArrayList;

public class MainArray {
  public static void main(String[] args) {
    ArrayList<Integer> aleatoryNumbers = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
      // Generar 10 números aleatorios
      aleatoryNumbers.add((int) (Math.random() * 100) + 1);
    }
    RamMachine ramMachine = new RamMachine("test/insertion.ram", "inputs/input.txt", "outputs/output.txt");
    ramMachine.setArray(aleatoryNumbers);
    ramMachine.run(1);
  }
}

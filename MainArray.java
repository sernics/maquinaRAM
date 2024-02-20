import java.util.ArrayList;

public class MainArray {
  public static void main(String[] args) {
    ArrayList<Integer> aleatoryNumbers = new ArrayList<Integer>();
    // Haz que aleatoryNumbers tenga los siguientes valores: {87, 12, 45, 67, 23, 98, 34, 56, 78, 10};
    aleatoryNumbers.add(87);
    aleatoryNumbers.add(12);
    aleatoryNumbers.add(45);
    aleatoryNumbers.add(67);
    aleatoryNumbers.add(23);
    aleatoryNumbers.add(98);
    aleatoryNumbers.add(34);
    aleatoryNumbers.add(56);
    aleatoryNumbers.add(78);
    aleatoryNumbers.add(10);
    // for (int i = 0; i < 10; i++) {
    //   // Generar 10 números aleatorios
    //   aleatoryNumbers.add((int) (Math.random() * 100) + 1);
    // }
    RamMachine ramMachine = new RamMachine("test/insertion.ram", "inputs/input.txt", "outputs/output.txt");
    ramMachine.setArray(aleatoryNumbers);
    ramMachine.run(2);
  }
}

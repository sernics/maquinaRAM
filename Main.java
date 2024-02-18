import java.util.ArrayList;
public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    // Introducir 10 numeros aleatorios
    for (int i = 0; i < 10; i++) {
      list.add((int) (Math.random() * 100));
    }
    System.out.println("Original List: " + list);
    RamMachine ramMachine = new RamMachine("test/insertion.ram", "inputs/input.txt", "outputs/output.txt");
    ramMachine.setArray(list);
    ramMachine.run(2);
  }
}

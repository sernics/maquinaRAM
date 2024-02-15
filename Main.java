public class Main {
  public static void main(String[] args) {
    ControlUnit controlUnit = new ControlUnit("test/test3.ram", "inputs/input.txt", "outputs/output.txt");
    controlUnit.run();
  }
}

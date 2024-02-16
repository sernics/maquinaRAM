public class RamMachine {
  public RamMachine(String filename, String inputTape, String outputTape) {
    controlUnit = new ControlUnit(filename, inputTape, outputTape);
  }
  public void run() {
    controlUnit.run();
  }
  ControlUnit controlUnit;
}

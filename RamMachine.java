public class RamMachine {
  public RamMachine(String filename, String inputTape, String outputTape) {
    controlUnit = new ControlUnit(filename, inputTape, outputTape);
  }
  
  public void run() {
    run(0);
  }

  public void run(Integer debugMode) {
    Integer instructionsCounter = 0;
    Integer haltInteger = controlUnit.getHaltInteger();
    while (controlUnit.getProgramHead() <= haltInteger) {
      if (debugMode == 2) {
        System.out.println("Hola");
      }
      controlUnit.operate();
      instructionsCounter++;
    }
    if (debugMode == 1) {
      System.out.println("Número de instrucciones ejecutadas: " + instructionsCounter);
    }
    // Finalizar programa
    return;
  }
  ControlUnit controlUnit;
}

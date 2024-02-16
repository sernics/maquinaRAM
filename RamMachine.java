import Instructions.Instruction;

public class RamMachine {
  public RamMachine(String filename, String inputTape, String outputTape) {
    controlUnit = new ControlUnit(filename, inputTape, outputTape);
  }
  
  public void run() {
    run(0);
  }

  public void run(Integer debugMode) {
    Integer instructionsCounter = 0;
    while (controlUnit.getActualInstruction().isHalt() == false) {
      controlUnit.operate();
      instructionsCounter++;
    }
    controlUnit.operate();
    instructionsCounter++;
    if (debugMode == 1) {
      System.out.println("Número de instrucciones ejecutadas: " + instructionsCounter);
    }
    // Finalizar programa
    System.exit(0);
  }
  ControlUnit controlUnit;
}

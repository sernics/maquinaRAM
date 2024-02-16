import java.util.ArrayList;

public class RamMachine  {
  public RamMachine(String filename, String inputTape, String outputTape) {
    this.controlUnit = new ControlUnit(filename, inputTape, outputTape);
  }
  
  public void run() {
    run(0);
  }

  public void run(Integer debugMode) {
    Integer instructionsCounter = 0;
    Integer haltInteger = controlUnit.getHaltInteger();
    while (controlUnit.getProgramHead() <= haltInteger) {
      if (debugMode == 2) {
        System.out.println(controlUnit.getActualInstruction().toString());
        controlUnit.getRegisterBank().print();
        System.out.print("La cinta de entrada: ");
        ArrayList<Integer> inputTape = controlUnit.getInputTape().getTape();
        Integer inputTapePosition = controlUnit.getInputTape().getHead();
        for (Integer value : inputTape) {
          System.out.print(value + " ");
        }
        System.out.print("Actual Position -> " + inputTapePosition);
        System.out.println();
        // Cinta de salida
        System.out.print("La cinta de salida: ");
        ArrayList<Integer> outputTape = controlUnit.getOutputTape().getTape();
        for (Integer value : outputTape) {
          System.out.print(value + " ");
        }
        System.out.println("Actual Position -> " + controlUnit.getOutputTape().getHead());
        System.out.println();
      }
      controlUnit.operate();
      instructionsCounter++;
    }
    if (debugMode == 1 || debugMode == 2) {
      System.out.println("Número de instrucciones ejecutadas: " + instructionsCounter);
    }
    // Finalizar programa
    return;
  }
  private ControlUnit controlUnit;
}

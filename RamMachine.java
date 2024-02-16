import java.util.ArrayList;

public class RamMachine extends ControlUnit {
  public RamMachine(String filename, String inputTape, String outputTape) {
    super(filename, inputTape, outputTape);
  }
  
  public void run() {
    run(0);
  }

  public void run(Integer debugMode) {
    Integer instructionsCounter = 0;
    Integer haltInteger = getHaltInteger();
    while (getProgramHead() <= haltInteger) {
      if (debugMode == 2) {
        System.out.println(getActualInstruction().toString());
        getRegisterBank().print();
        System.out.print("La cinta de entrada: ");
        ArrayList<Integer> inputTape = getInputTape().getTape();
        Integer inputTapePosition = getInputTape().getHead();
        for (Integer value : inputTape) {
          System.out.print(value + " ");
        }
        System.out.print("Actual Position -> " + inputTapePosition);
        System.out.println();
        // Cinta de salida
        System.out.print("La cinta de salida: ");
        ArrayList<Integer> outputTape = getOutputTape().getTape();
        for (Integer value : outputTape) {
          System.out.print(value + " ");
        }
        System.out.println("Actual Position -> " + getOutputTape().getHead());
        System.out.println();
      }
      operate();
      instructionsCounter++;
    }
    if (debugMode == 1 || debugMode == 2) {
      System.out.println("Número de instrucciones ejecutadas: " + instructionsCounter);
    }
    // Finalizar programa
    return;
  }
}

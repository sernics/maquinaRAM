import Tapes.*;
import ProgramMemory.ProgramMemory;
import Registers.*;
import Instructions.*;
import java.io.File;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class ControlUnit {
  public ControlUnit(String filename, String inputTape, String outputTape) {
    this.inputTape = new InputTape(inputTape);
    this.outputTape = new OutputTape(outputTape);
    this.registerBank = new RegisterBank();
    this.programMemory = new ProgramMemory();
    ArrayList<String> tokens = new ArrayList<String>();
    try {
      Scanner scanner = new Scanner(new File(filename));
      String pattern = "(?m)(?<=^|\\s)#.*$";
      String pattern2 = "\\s+";
      Pattern p = Pattern.compile(pattern);
      Pattern p2 = Pattern.compile(pattern2);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().toLowerCase();
        Matcher m = p.matcher(line);
        String lineWithoutComments = m.replaceAll("");
        m = p2.matcher(lineWithoutComments);
        lineWithoutComments = m.replaceAll(" ");
        if (!lineWithoutComments.equals("")) {
          // split the line by spaces
          String[] values = lineWithoutComments.split(" ");
          for (String value : values) {
            if (!value.equals("")) {
              tokens.add(value);
            }
          }
        }
      }
      scanner.close();
    } catch (java.io.FileNotFoundException e) {
      System.out.println("File not found: " + filename);
    }
    // Imprimir tokens
    for (String token : tokens) {
      System.out.println(token);
    }
    Parser parser = new Parser();
    parser.Parse(tokens, programMemory, registerBank, this.inputTape, this.outputTape);
  }

  protected void operate() {
    Instruction instruction = programMemory.read();
    instruction.operate();
  }

  protected Instruction getActualInstruction() {
    return programMemory.getActualInstruction();
  }

  protected Integer getProgramHead() {
    return programMemory.getHead();
  }

  protected Integer getHaltInteger() {
    return programMemory.getProgramMemory().size() - 1;
  }

  protected RegisterBank getRegisterBank() {
    return registerBank;
  }

  protected Tape getInputTape() {
    return inputTape;
  }

  protected Tape getOutputTape() {
    return outputTape;
  }

  private Tape inputTape;
  private Tape outputTape;
  private RegisterBank registerBank;
  private ProgramMemory programMemory;
}

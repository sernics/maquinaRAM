import Tapes.*;
import Operands.*;
import ProgramMemory.ProgramMemory;
import Registers.*;
import Instructions.*;
import java.io.File;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class ControlUnit {
  public ControlUnit(String filename, String inputTape) {
    try {
      this.inputTape = new InputTape(inputTape);
      this.outputTape = new OutputTape();
      this.registerBank = new RegisterBank();
      this.programMemory = new ProgramMemory();
      Scanner scanner = new Scanner(new File(filename));
      String pattern = "(?m)(?<=^|\\s)#.*$";
      String pattern2 = "\\s+";
      Pattern p = Pattern.compile(pattern);
      Pattern p2 = Pattern.compile(pattern2);
      ArrayList<String> values = new ArrayList<String>();
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        Matcher m = p.matcher(line);
        String lineWithoutComments = m.replaceAll("");
        m = p2.matcher(lineWithoutComments);
        lineWithoutComments = m.replaceAll(" ");
        if (!lineWithoutComments.equals("")) {
          // split the line by spaces
          String[] tokens = lineWithoutComments.split(" ");
          // Imprimir tokens
          for (String token : tokens) {
            if (!token.equals("")) {
              values.add(token);
            }
          }
        }
      }
      // imprimir values
      for (String value : values) {
        System.out.println(value);
      }
      scanner.close();
    } catch (java.io.FileNotFoundException e) {
      System.out.println("File not found: " + filename);
    }
  }
  public void run() {
    while (true) {
      operate();
    }
  }
  public void operate() {
    Instruction instruction = programMemory.read();
    instruction.operate();
  }
  private Boolean isInmediate(String value) {
    return value.charAt(0) == '=';
  }
  private Boolean isIndirect(String value) {
    return value.charAt(0) == '*';
  }
  private Tape inputTape;
  private Tape outputTape;
  private RegisterBank registerBank;
  private ProgramMemory programMemory;
}

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
      // Otro patron que sea muchos espacios a uno solo
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
          String[] split = lineWithoutComments.split(" ");
          for (String s : split) {
            if (!s.equals("")) 
              values.add(s);
          }
        }
        // Imprimir values
        for (String s : values) {
          System.out.println(s);
        }
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
  private Tape inputTape;
  private Tape outputTape;
  private RegisterBank registerBank;
  private ProgramMemory programMemory;
}

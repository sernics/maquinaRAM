import Tapes.*;
import Operands.*;
import ProgramMemory.ProgramMemory;
import Registers.*;
import Instructions.*;
import java.io.File;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ControlUnit {
  public ControlUnit(String filename, String inputTape) {
    this.inputTape = new InputTape(inputTape);
    this.outputTape = new OutputTape();
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
        String line = scanner.nextLine();
        Matcher m = p.matcher(line);
        String lineWithoutComments = m.replaceAll("");
        m = p2.matcher(lineWithoutComments);
        lineWithoutComments = m.replaceAll(" ");
        if (!lineWithoutComments.equals("")) {
          // split the line by spaces
          String[] values = lineWithoutComments.split(" ");
          // Print tokens
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
    Parse(tokens);
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

  private void Parse(ArrayList<String> tokens) {
    int programIndex = 0;
    HashMap<String, Integer> labels = new HashMap<String, Integer>();
    for (int i = 0; i < tokens.size(); i++) {
      String token = tokens.get(i);
      System.out.println( "/" + token + "/ " + token.length());
      if (isLabel(token)) {
        String label = token.substring(0, token.length() - 1);
        labels.put(label, programIndex);
      } else {
        switch (token) {
          case "load":
            System.out.println("load instruction");
            break;
          case "store":
            System.out.println("store instruction");
            break;
            
          default:
            break;
        }
      }
    }
  }

  private Boolean isInmediate(String value) {
    return value.charAt(0) == '=';
  }

  private Boolean isIndirect(String value) {
    return value.charAt(0) == '*';
  }

  private Boolean isLabel(String value) {
    return value.charAt(value.length() - 1) == ':';
  }

  private Tape inputTape;
  private Tape outputTape;
  private RegisterBank registerBank;
  private ProgramMemory programMemory;
}

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
    HashMap<String, Integer> labels = parseLabels(tokens);
    for (int i = 0; i < tokens.size(); i++) {
      String token = tokens.get(i);
      System.out.println( "/" + token + "/ " + token.length());
      Instruction instruction;
      instruction = null;
      BasicOperand operand;
      switch (token) {
        case "load":
          System.out.println("load instruction");
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new LoadInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "store":
          System.out.println("store instruction");
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new StoreInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "add":
          System.out.println("add instruction");
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new AddInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "sub":
          System.out.println("sub instruction");
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new SubInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "mult":
          System.out.println("mul instruction");
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new MulInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "div":
          System.out.println("div instruction");
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new DivInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "read":
          System.out.println("read instruction");
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new ReadInstruction(inputTape, registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "write":
          System.out.println("write instruction");
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new WriteInstruction(outputTape, registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "jump":
          System.out.println("jump instruction");
          i++;
          if (labels.containsKey(tokens.get(i))) {
            System.out.println(labels.get(tokens.get(i)));
            operand = new InmediateOperand(labels.get(tokens.get(i)));
            instruction = new JumpInstruction(programMemory, operand, registerBank);
          } else {
            throw new RuntimeException("Invalid label");
          }
          break;
        case "jzero":
          System.out.println("jzero instruction");
          i++;
          if (labels.containsKey(tokens.get(i))) {
            System.out.println(labels.get(tokens.get(i)));
            operand = new InmediateOperand(labels.get(tokens.get(i)));
            instruction = new JumpZeroInstruction(programMemory, operand, registerBank);
          } else {
            throw new RuntimeException("Invalid label");
          }
          break;
        case "jgtz":
          System.out.println("jgtz instruction");
          i++;
          if (labels.containsKey(tokens.get(i))) {
            operand = new InmediateOperand(labels.get(tokens.get(i)));
            instruction = new JumpGreaterThanZeroInstruction(programMemory, operand, registerBank);
          } else {
            throw new RuntimeException("Invalid label");
          }
          break;
        case "halt":
          System.out.println("halt instruction");
          instruction = new HaltInstruction();
          break;
        default:
          break;
      }
      if (instruction != null) {
        programMemory.add(instruction);
      }
    }
    for (Instruction instruction : programMemory.getProgramMemory()) {
      System.out.println(instruction);
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

  private Boolean isOperand(String value) {
    return value.charAt(0) == '=' || value.charAt(0) == '*' || Character.isDigit(value.charAt(0));
  }

  private BasicOperand parseOperand(String value) {
    if (isInmediate(value)) {
      return new InmediateOperand(Integer.parseInt(value.substring(1)));
    } else if (isIndirect(value)) {
      return new IndirectOperand(Integer.parseInt(value.substring(1)));
    } else {
      return new DirectOperand(Integer.parseInt(value));
    }
  }

  private HashMap<String, Integer> parseLabels(ArrayList<String> tokens) {
    HashMap<String, Integer> labels = new HashMap<String, Integer>();
    Integer programIndex = 0;
    for (int i = 0; i < tokens.size(); i++) {
      String token = tokens.get(i);
      if (isLabel(token)) {
        labels.put(token.substring(0, token.length() - 1), programIndex);
      } else {
        if (isOperand(token) || token.equals("halt") || token.equals("jump") || token.equals("jzero") || token.equals("jgtz")) {
          programIndex++;
        }
      }
    }
    return labels;
  }

  private Tape inputTape;
  private Tape outputTape;
  private RegisterBank registerBank;
  private ProgramMemory programMemory;
}

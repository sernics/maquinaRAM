import java.util.ArrayList;
import java.util.HashMap;

import Instructions.*;
import ProgramMemory.ProgramMemory;
import Registers.RegisterBank;
import Tapes.*;
import Operands.*;

public class Parser {
  public void Parse(ArrayList<String> tokens, ProgramMemory programMemory, RegisterBank registerBank, Tape inputTape, Tape outputTape) {
    HashMap<String, Integer> labels = parseLabels(tokens);
    for (int i = 0; i < tokens.size(); i++) {
      String token = tokens.get(i);
      Instruction instruction;
      instruction = null;
      BasicOperand operand;
      switch (token) {
        case "load":
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new LoadInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "store":
          i++;
          if (this.isInmediate(tokens.get(i))) {
            throw new RuntimeException("Inmediate operand, invalid for store instruction");
          }
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new StoreInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "add":
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new AddInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "sub":
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new SubInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "mul" :
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new MulInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "div":
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new DivInstruction(registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "read":
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new ReadInstruction(inputTape, registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "write":
          i++;
          if (isOperand(tokens.get(i))) {
            operand = parseOperand(tokens.get(i));
            instruction = new WriteInstruction(outputTape, registerBank, operand);
          } else {
            throw new RuntimeException("Invalid operand");
          }
          break;
        case "jump":
          i++;
          if (labels.containsKey(tokens.get(i))) {
            operand = new InmediateOperand(labels.get(tokens.get(i)));
            instruction = new JumpInstruction(programMemory, operand, registerBank);
          } else {
            throw new RuntimeException("Invalid label");
          }
          break;
        case "jzero":
          i++;
          if (labels.containsKey(tokens.get(i))) {
            operand = new InmediateOperand(labels.get(tokens.get(i)));
            instruction = new JumpZeroInstruction(programMemory, operand, registerBank);
          } else {
            throw new RuntimeException("Invalid label");
          }
          break;
        case "jgtz":
          i++;
          if (labels.containsKey(tokens.get(i))) {
            operand = new InmediateOperand(labels.get(tokens.get(i)));
            instruction = new JumpGreaterThanZeroInstruction(programMemory, operand, registerBank);
          } else {
            throw new RuntimeException("Invalid label");
          }
          break;
        case "halt":
          instruction = new HaltInstruction();
          break;
        default:
          break;
      }
      if (instruction != null) {
        programMemory.add(instruction);
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

  private Boolean isOperand(String value) {
    return value.charAt(0) == '=' || value.charAt(0) == '*' || Character.isDigit(value.charAt(0)) || isArray(value);
  }

  private Boolean isArray(String value) {
    return value.matches("R[0-9]+\\[[0-9]+\\]");
  }

  public BasicOperand parseOperand(String value) {
    if (isInmediate(value)) {
      return new InmediateOperand(Integer.parseInt(value.substring(1)));
    } else if (isIndirect(value)) {
      return new IndirectOperand(Integer.parseInt(value.substring(1)));
    } else if (isArray(value)) {
      String[] parts = value.split("\\[");
      String register = parts[0];
      String index = parts[1].substring(0, parts[1].length() - 1);
      return new ArrayOperand(Integer.parseInt(register.substring(1)), parseOperand(index));
    }
    else {
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
}

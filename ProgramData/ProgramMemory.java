package ProgramData;
import java.util.HashMap;
import java.util.ArrayList;
import RegisterBank.DataMemory;
import Instructions.*;

public class ProgramMemory {
  public ProgramMemory() {
    operators = new HashMap<Operator, Integer>();
    instructions = new ArrayList<Instruction>();
    programCounter = 0;
  }
  public ProgramMemory(String filename) {
    // TODO: Implement this constructor
  }
  public int getLabelPosition(Operator operator) {
    return operators.get(operator);
  }
  public void operate(DataMemory dataMemory) {
    if (!instructions.get(programCounter).isJump()) {
      programCounter = instructions.get(programCounter).getLabelIndex();
      programCounter++;
    }
    else
      // Make a jump
      programCounter++;
  }
  public void addLabel(Operator operator) {
    operators.put(operator, programCounter);
  }
  public void addInstruction(Instruction instruction) {
    instructions.add(instruction);
  }
  private HashMap<Operator, Integer> operators;
  private ArrayList<Instruction> instructions;
  private int programCounter;
}

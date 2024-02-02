package ProgramData;
import java.util.HashMap;
import java.util.ArrayList;
import Operands.*;
import RegisterBank.DataMemory;
import Instructions.*;

public class ProgramMemory {
  public ProgramMemory() {
    labels = new HashMap<Label, Integer>();
    instructions = new ArrayList<Instruction>();
    programCounter = 0;
  }
  public ProgramMemory(String filename) {
    // TODO: Implement this constructor
  }
  public int getLabelPosition(Label label) {
    return labels.get(label);
  }
  public void operate(DataMemory dataMemory) {
    instructions.get(programCounter).execute(dataMemory);
  }
  public void addLabel(Label label) {
    labels.put(label, programCounter);
  }
  public void addInstruction(Instruction instruction) {
    instructions.add(instruction);
  }
  private HashMap<Label, Integer> labels;
  private ArrayList<Instruction> instructions;
  private int programCounter;
}

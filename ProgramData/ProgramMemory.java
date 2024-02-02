package ProgramData;
import java.util.HashMap;
import java.util.ArrayList;
import Operands.*;
import Instructions.*;

public class ProgramMemory {
  public ProgramMemory() {
    labels = new HashMap<Label, Integer>();
    instructions = new ArrayList<Instruction>();
    programCounter = 0;
  }
  public ProgramMemory(String filename) {

  }
  public int getLabelPosition(Label label) {
    return labels.get(label);
  }
  private HashMap<Label, Integer> labels;
  private ArrayList<Instruction> instructions;
  private int programCounter;
}

package ProgramMemory;
import Instructions.*;
import java.util.ArrayList;

public class ProgramMemory {
  public ProgramMemory() {
    programMemory = new ArrayList<Instruction>();
    head = 0;
  }
  public void add(Instruction instruction) {
    programMemory.add(instruction);
  }
  public ArrayList<Instruction> getProgramMemory() {
    return programMemory;
  }
  public Instruction read() {
    Instruction value = programMemory.get(head);
    head++;
    return value;
  }
  public Integer getHead() {
    return head;
  }
  public void setHead(Integer head) {
    this.head = head;
  }
  private ArrayList<Instruction> programMemory;
  private Integer head;
}

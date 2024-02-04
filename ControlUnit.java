import Tapes.*;
import Operands.*;
import Registers.*;
import Instructions.*;

public class ControlUnit {
  public ControlUnit(String filename) {
    
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

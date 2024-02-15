package Registers;
import java.util.HashMap;

public class RegisterBank {
  public RegisterBank() {
    memory = new HashMap<Integer, Register>();
    memory.put(0, new IntegerRegister());
  }
  public Register getRegister(int address) {
    return memory.get(address);
  }
  public int getRegisterValue(int address) {
    return memory.get(address).getValue();
  }
  public void putRegister(int address, Register register) {
    memory.put(address, register);
  }
  public boolean containsRegister(int address) {
    return memory.containsKey(address);
  }
  public HashMap<Integer, Register> getMemory() {
    return memory;
  }
  public void print() {
    for (Integer key : memory.keySet()) {
      System.out.println("Register " + key + ": " + memory.get(key).getValue());
    }
    System.out.println();
  }
  private HashMap<Integer, Register> memory;
}

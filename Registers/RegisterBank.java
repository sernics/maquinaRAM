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
  private HashMap<Integer, Register> memory;
}

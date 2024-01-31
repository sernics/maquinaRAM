package RegisterBank;

public class IntegerRegister implements Register {
  public IntegerRegister() {
    value = 0;
  }
  public int getValue() {
    return value;
  }
  public void setValue(int value) {
    this.value = value;
  }
  private int value;
}

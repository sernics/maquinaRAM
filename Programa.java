import valores.*;
import java.util.HashMap;

// Creame una clase abstracta que sirva para poder tener un entero o un array de enteros
public abstract class Symbol {
  public abstract int getValor();
  public abstract int[] getValores();
}

// Creame una clase que herede de Symbol y que tenga un entero
public class Entero extends Symbol {
  private int valor;
  public Entero(int valor) {
    this.valor = valor;
  }
  public int getValor() {
    return this.valor;
  }
  public int[] getValores() {
    return null;
  }
}

// Creame una clase que herede de Symbol y que tenga un array de enteros
public class Array extends Symbol {
  private int[] valores;
  public Array(int[] valores) {
    this.valores = valores;
  }
  public int getValor() {
    return -1;
  }
  public int[] getValores() {
    return this.valores;
  }
}

public class Programa {
  public static void main(String[] args) {
    int a = 5;
    int b = 6;
    Abracadabra prueba = new Abracadabra();
    System.out.println(prueba.suma(a, b));
    HashMap<String, Symbol> tabla = new HashMap<String, Symbol>();
  }
}

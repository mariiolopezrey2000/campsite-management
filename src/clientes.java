import java.io.Serializable;

public abstract class clientes implements Serializable  {
    private static final long serialVersionUID = 1L;
    private String dni;
    private int dias;
    private int numeroplaza;
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    public int getNumeroplaza() {
        return numeroplaza;
    }
    public void setNumeroplaza(int numeroplaza) {
        this.numeroplaza = numeroplaza;
    }
    abstract double calcularfactura(clientes c);




}
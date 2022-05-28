public class caravanas extends clientes {
    private static final long serialVersionUID = 1L;
    String matricula;
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }
    @Override
    double calcularfactura(clientes c) {
        return c.getDias()*35;
    }
}

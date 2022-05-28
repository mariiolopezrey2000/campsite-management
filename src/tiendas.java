
public class tiendas extends clientes{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    double calcularfactura( clientes c) {
        return c.getDias()*25;
    }
}
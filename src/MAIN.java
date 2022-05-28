import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MAIN {
    public static void main(String[] args) throws Exception {
        String op="";
        do {
            util u=new util();
            op=JOptionPane.showInputDialog("A-->Check in\nB-->Check out\nC-->Salir").toUpperCase();
            switch(op) {
                case "A":
                    u.checkin();
                    break;
                case "B":
                    u.checkout();
                    break;
                case "C":
                    break;
                case "D":
                    gestionfichero gf=new gestionfichero();
                    ArrayList<clientes> listac=gf.leer();
                    for (clientes c : listac) {
                        JOptionPane.showInternalMessageDialog(null,c.getDni()+" "+c.getNumeroplaza());
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } while (!op.equals("C"));
    }
}
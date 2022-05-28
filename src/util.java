import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class util {
// El camping tiene un total de 100 parcelas. Las parcelas est�n numeradas de 1 a 100
//Seg�n el n�mero de plazas que hay ocupadas, debe localizar un n�mero de plaza libre. Es decir, puede que est�n ocupadas: 1,3,4,7; Libres ser�an 2,5,6; La primera a asignar es el n�mero m�s peque�o. Si hay 100 campistas, no hay plazas. 

    public void checkin() {
        gestionfichero gf=new gestionfichero();
        if(gf.leer().size()>=100){
            JOptionPane.showMessageDialog(null, "No hay plazas disponibles");
        } else {
            String op=JOptionPane.showInputDialog("CARAVANA o TIENDA").toUpperCase();
            switch (op) {
                case "CARAVANA":
                    caravanas c=new caravanas();
                    c.setDni(JOptionPane.showInputDialog("Escribe el DNI"));
                    c.setDias(Integer.parseInt(JOptionPane.showInputDialog("Escribe los dias que quieres alquilar")));
                    c.setNumeroplaza(disponibilidad());
                    c.setMatricula(JOptionPane.showInputDialog("Escribe la matricula"));
                    JOptionPane.showInternalMessageDialog(null, "La plaza para el campista con DNI "+c.getDni()+" es la "+c.getNumeroplaza());
                    gf.escritura(c);
                    break;
                case "TIENDA":
                    tiendas t=new tiendas();
                    t.setDni(JOptionPane.showInputDialog("Escribe el DNI"));
                    t.setDias(Integer.parseInt(JOptionPane.showInputDialog("Escribe los dias que quieres alquilar")));
                    t.setNumeroplaza(disponibilidad());
                    JOptionPane.showInternalMessageDialog(null, "La plaza para el campista con DNI "+t.getDni()+" es la "+t.getNumeroplaza());
                    gf.escritura(t);
                    break;
            }
        }
    }
    public void checkout() {
        String DNI=JOptionPane.showInputDialog("Escribe el DNI del campista");
        gestionfichero gf=new gestionfichero();
        clientes c=gf.buscar(DNI);
        ArrayList<clientes> lista=gf.leer();

        if(c instanceof caravanas) {
            File ficherocaravana=new File("caravanas.dat");
            ficherocaravana.delete();
            caravanas c1=(caravanas)c;
            int num=0;
                for(int i=0;i<lista.size();i++) {
                    if(lista.get(i).getDni().equals(c.getDni())) {
                        JOptionPane.showInternalMessageDialog(null, "El campista con DNI "+c.getDni()+" tiene una factura de "+c1.calcularfactura(lista.get(i))+" euros");
                        num=i;
                    }
                }
            lista.remove(num);
            for (clientes clientes : lista) {
                if (clientes instanceof caravanas) {
                    gf.escritura((caravanas) clientes);
                }
            }
            
        } else if(c instanceof tiendas){
            File ficherotiendas=new File("tiendas.dat");
            ficherotiendas.delete();
            tiendas t1=(tiendas)c;
            int num=0;
                for(int i=0;i<lista.size();i++) {
                    if(lista.get(i).getDni().equals(c.getDni())) {
                        JOptionPane.showInternalMessageDialog(null, "El campista con DNI "+c.getDni()+" tiene una factura de "+t1.calcularfactura(lista.get(i))+" euros");
                        num=i;
                    }
                }
            lista.remove(num);
            for (clientes clientes : lista) {
                if (clientes instanceof tiendas) {
                    gf.escritura((tiendas) clientes);
                }
            }
        }
    }

    public int disponibilidad() {
        gestionfichero gf=new gestionfichero();
        ArrayList<clientes> listac=gf.leer();
        int num=1;
        if (listac.size()!=0) {
            ArrayList<Integer> lista=new ArrayList<Integer>();
            for (clientes c : listac) {
                lista.add(c.getNumeroplaza());
            }
            Collections.sort(lista);
            for(int i=1;i<=lista.size();i++) {
                if(lista.get(i-1)==i) {
                    num=i;
                }else {
                    return i;
                }
            }
            return num+1;
        } else {
            return 1;
        }
        
    }
}
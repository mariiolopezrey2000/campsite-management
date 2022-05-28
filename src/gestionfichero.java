import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class gestionfichero {
    File ficherocaravanas=new File("caravanas.dat");
    File ficherotiendas=new File("tiendas.dat");
    
    public void escritura(caravanas c) {
        if(ficherocaravanas.exists()) {
            try {
                ArrayList<clientes> list=leer();
                ficherocaravanas.delete();
                ArrayList<clientes>aux=new ArrayList<clientes>();
                FileOutputStream fos=new FileOutputStream(ficherocaravanas);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                for (clientes clientes : list) {
					if (clientes instanceof caravanas) {
						aux.add(clientes);
					}
				}
                aux.add(c);
                oos.writeObject(aux);
                oos.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ArrayList<clientes> lista=new ArrayList<clientes>();
            lista.add(c);
            try {
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(ficherocaravanas));
                oos.writeObject(lista);
                oos.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void escritura(tiendas t) {
        if(ficherotiendas.exists()) {
            try {
                ArrayList<clientes> list=leer();
                ficherotiendas.delete();
                ArrayList<clientes>aux=new ArrayList<clientes>();
                FileOutputStream fos=new FileOutputStream(ficherotiendas);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                for (clientes clientes : list) {
					if (clientes instanceof tiendas) {
						aux.add(clientes);
					}
				}
                aux.add(t);
                oos.writeObject(aux);
                oos.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ArrayList<clientes> lista=new ArrayList<clientes>();
            lista.add(t);
            try {
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(ficherotiendas));
                oos.writeObject(lista);
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
	public ArrayList<clientes> leer() {
        ArrayList<clientes> lista1 = new ArrayList<clientes>();
        ArrayList<clientes> lista2 = new ArrayList<clientes>();
        ArrayList<clientes> lista3 = new ArrayList<clientes>();
        try {
            FileInputStream fis = new FileInputStream(ficherocaravanas);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista1=(ArrayList<clientes>)ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        try {
            FileInputStream fis2 = new FileInputStream(ficherotiendas);
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            lista2=(ArrayList<clientes>)ois2.readObject();
            ois2.close();
            fis2.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        for (clientes c : lista1) {
            lista3.add(c);
        }
        for (clientes c : lista2) {
            lista3.add(c);
        }
        return lista3;
    }



    public clientes buscar(String DNI) {
        clientes c=null;
        ArrayList<clientes> lista=leer();
        for (clientes clientes : lista) {
            if(clientes.getDni().equals(DNI)) {
                c=clientes;
            }
        }
        return c;
    }
    
}
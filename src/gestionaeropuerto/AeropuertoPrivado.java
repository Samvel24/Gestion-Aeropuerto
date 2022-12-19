
package gestionaeropuerto;

public class AeropuertoPrivado extends Aeropuerto
{
    private String listaEmpresas[] = new String[10];
    private int numEmpresas;

    public AeropuertoPrivado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais); // se llama al constructor de la clase padre (Aeropuerto)
    }

    public AeropuertoPrivado(String nombre, String ciudad, String pais, Compañia[] c, 
            String e[]) {
        super(nombre, ciudad, pais, c);
        
        this.listaEmpresas = e;
        numEmpresas = e.length;
    }
    
    public void insertarEmpresas(String e[]) {
        this.listaEmpresas = e;
        this.numEmpresas = e.length;
    }
    
    public void insertarEmpresas(String e) {
        listaEmpresas[numEmpresas] = e;
        numEmpresas++;
    }

    public String[] getListaEmpresas() {
        return listaEmpresas;
    }

    public int getNumEmpresas() {
        return numEmpresas;
    }
}

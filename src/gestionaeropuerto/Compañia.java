
package gestionaeropuerto;

public class Compañia 
{
    private String nombre;
    private Vuelo listaVuelos[] = new Vuelo[10];
    private int numVuelos = 0;

    public Compañia(String nombre) {
        this.nombre = nombre;
    }
    
    public Compañia(String nombre, Vuelo v[]) {
        this.nombre = nombre;
        listaVuelos = v;
        numVuelos = v.length;
    }
    
    public void insertarVuelo(Vuelo vuelo) {
        listaVuelos[numVuelos] = vuelo;
        numVuelos++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumVuelos() {
        return numVuelos;
    }
    
    public Vuelo getVuelo(int i) {
        return listaVuelos[i];
    }
    
    public Vuelo getVuelo(String id) {
        boolean encontrado = false;
        
        int i = 0;
        Vuelo v = null;
        
        while((!encontrado) && (i < listaVuelos.length)) {
            if (id.equals(listaVuelos[i].getIdentificador())) {
                encontrado = true;
                v = listaVuelos[i];
            }
            
            i++;
        }
        
        return v;
    }
}

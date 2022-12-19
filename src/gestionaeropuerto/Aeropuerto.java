
package gestionaeropuerto;

public class Aeropuerto 
{
    private String nombre;
    private String ciudad;
    private String pais;
    private Compañia listaCompañias[] = new Compañia[10];
    private int numCompañias;

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        
        this.numCompañias = 0;
    }
    
    public Aeropuerto(String nombre, String ciudad, String pais, 
            Compañia c[]) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        
        this.numCompañias = c.length;
        listaCompañias = c;
    }
    
    public void insertarCompañia(Compañia compañia) {
        listaCompañias[numCompañias] = compañia;
        numCompañias++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Compañia[] getListaCompañias() {
        return listaCompañias;
    }

    public int getNumCompañias() {
        return numCompañias;
    }
    
    public Compañia getCompañia(int i) {
        return listaCompañias[i];
    }
    
    public Compañia getCompañia(String nombre) {
        boolean encontrado = false;
        
        int i = 0;
        Compañia c = null;
        
        while((!encontrado) && (i < listaCompañias.length)) {
            if (nombre.equals(listaCompañias[i].getNombre())) {
                encontrado = true;
                c = listaCompañias[i];
            }
            
            i++;
        }
        
        return c;
    }
}

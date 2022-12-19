
package gestionaeropuerto;

import java.util.Scanner;

/**
 *
 * @author: github.com/Samvel24
 */

public class Principal 
{
    static Scanner entrada = new Scanner(System.in);
    final static int numAeropuertos = 4;
    static Aeropuerto aeropuertos[] = new Aeropuerto[numAeropuertos];
    
    public static void main(String[] args) 
    {
        
    }
    
    public static void insertarDatosAeropuerto(Aeropuerto aero[]) {
        // Creamos un aeropuerto en la posición 0 del arreglo de aeropuertos
        aero[0] = new AeropuertoPublico(80000000, "AIFA", "Zumpango", 
                "México");
        
        // Insertamos 2 compañias en el primer aeropuerto creado
        aero[0].insertarCompañia(new Compañia("AeroMéxico"));
        aero[0].insertarCompañia(new Compañia("LATAM"));
        
        // Colocamos vuelos en la compañia 'AeroMéxico'
        Vuelo v1 = new Vuelo("IB20", "Zumpango", "Lima", 
                200.50, 150);
        Vuelo v2 = new Vuelo("IB21", "Zumpango", "Buenos Aires", 
                210.80, 120);
        aero[0].getCompañia("AeroMéxico").insertarVuelo(v1);
        aero[0].getCompañia("AeroMéxico").insertarVuelo(v2);
        
        // Colocamos vuelos en la compañia 'LATAM'
        aero[0].getCompañia("LATAM").insertarVuelo(new Vuelo("FC12", 
                                                        "Zumpango","Londres",
                                                       400.20, 140));
        aero[0].getCompañia("LATAM").insertarVuelo(new Vuelo("FC13", 
                                                        "Zumpango","París",
                                                       460.70, 180));
        
        // Incluimos pasajeros en el vuelo 'IB20'
        aero[0].getCompañia("AeroMéxico").getVuelo("IB20")
                .insertarPasajero(new Pasajero("Samuel", "20GHP", "Mexicana"));
        aero[0].getCompañia("AeroMéxico").getVuelo("IB20")
                .insertarPasajero(new Pasajero("Alejandro", "34YCL", "Peruana"));
        
        // Incluimos pasajeros en el vuelo 'FC13'
        aero[0].getCompañia("LATAM").getVuelo("FC13")
                .insertarPasajero(new Pasajero("Rafael", "43MTR", "Brasileña"));
        aero[0].getCompañia("LATAM").getVuelo("FC13")
                .insertarPasajero(new Pasajero("Pablo", "51LVA", "Española"));
    }
}

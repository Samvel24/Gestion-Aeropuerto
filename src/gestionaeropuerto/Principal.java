
package gestionaeropuerto;

import java.util.Scanner;
import java.text.Normalizer;

/**
 *
 * @author: github.com/Samvel24
 */

public class Principal 
{
    /* La norma ISO 8859-1 es la que define la codificación del alfabeto latino, 
    incluyendo los diacríticos (como letras acentuadas, ñ, ç), y letras especiales 
     (como ß, Ø), esto permite usar caracteres acentuados del idioma español con la
    clase Scanner.
    Ver:
    https://es.wikipedia.org/wiki/ISO/IEC_8859-1
    https://es.stackoverflow.com/a/485831/101909
    */
    static Scanner entrada = new Scanner(System.in, "ISO-8859-1");
    final static int numAeropuertos = 4;
    static Aeropuerto aeropuertos[] = new Aeropuerto[numAeropuertos];
    
    public static void main(String[] args) 
    {
        insertarDatosAeropuerto(aeropuertos);
        menu();
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
        
        // Creamos un nuevo aeropuerto privado
        aero[1] = new AeropuertoPrivado("Central Ciudad Real",
                "Ciudad Real","España");
        aero[1].insertarCompañia(new Compañia("AirEuropa"));
        String empresas[] = {"Cobresol", "Anguila34"};
        ((AeropuertoPrivado)aero[1]).insertarEmpresas(empresas);
        aero[1].getCompañia("AirEuropa").insertarVuelo(new Vuelo("AE025",
                "Madrid","Buenos Aires",150.50,120));
        aero[1].getCompañia("AirEuropa").getVuelo("AE025")
                .insertarPasajero(new Pasajero("Alfonso","EA384794",
                        "Mexicana"));
        
        // Creamos un nuevo aeropuerto público
        aero[2] = new AeropuertoPublico(20000000,"Aeropuerto Bogotá",
                "Bogotá","Colombia");
        aero[2].insertarCompañia(new Compañia("AirAmerica"));
        aero[2].insertarCompañia(new Compañia("VuelaBogota"));
        aero[2].getCompañia("AirAmerica")
                .insertarVuelo(new Vuelo("AE030","Bogotá",
                        "Lima",130.90,110));
        aero[2].getCompañia("AirAmerica").getVuelo("AE030")
                .insertarPasajero(new Pasajero("Laura","000AA4G5",
                        "Colombiana"));
        
        // Creamos otro aeropuerto público
        aero[3] = new AeropuertoPublico(40000000,"Aeropuerto México",
                "CDMX","México");
        aero[3].insertarCompañia(new Compañia("AeroMexico"));
        aero[3].getCompañia("AeroMexico")
                .insertarVuelo(new Vuelo("IB2040",
                        "CDMX","Nueva York",130.90,140));
        aero[3].getCompañia("AeroMexico")
                .insertarVuelo(new Vuelo("IB2042","CDMX",
                        "Lima",100.80,150));
        aero[3].getCompañia("AeroMexico")
                .getVuelo("IB2040").insertarPasajero(new Pasajero("Emily",
                        "AA4794H","Inglesa"));
    }
    
    public static void menu() {
        int opcion;
        String nombreAeropuerto = "", nombreCompañia = "";
        Aeropuerto aeropuerto;
        Compañia compañia;
        
        do {            
            System.out.println("\t\t.::MENÚ::.");
            System.out.println("1. Consultar aeropuertos gestionados (Públicos o Privados)");
            System.out.println("2. Consultar empresas (Privada) o Subvención (Pública)");
            System.out.println("3. Listar compañias de un aeropuerto");
            System.out.println("4. Mostrar lista de vuelos por compañia");
            System.out.println("5. Listar posibles vuelos de origen a destino");
            System.out.println("6. Salir");
            System.out.println("Escribe una opcion: ");
            opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1: // Ver aeropuertos gestionados (Públicos o Privados)  
                    mostrarDatosAeropuerto(aeropuertos);
                    break;
                case 2: // Ver empresas (Privado) o subvención (Público)
                    mostrarPatrocinio(aeropuertos);
                    break;
                case 3: // Listar compañias de un aeropuerto
                    /* Limpiamos el buffer de entrada
                    Ver: https://www.clasesdeinformaticaweb.com/java-desde-cero/el-buffer-de-la-clase-scanner/
                    */
                    entrada.nextLine(); 
                    System.out.println("Escribe el nombre del Aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if(aeropuerto == null) {
                        System.out.println("El aeropuerto buscado no existe");
                    }
                    else {
                        mostrarCompañias(aeropuerto);
                    }
                    break;
                case 4: // Mostrar lista de vuelos por compañia
                    entrada.nextLine(); 
                    System.out.println("Escribe el nombre del Aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if(aeropuerto == null) {
                        System.out.println("El aeropuerto buscado no existe");
                    }
                    else {
                        System.out.println("Escribe el nombre de la compañia");
                        nombreCompañia = entrada.nextLine();
                        compañia = aeropuerto.getCompañia(nombreCompañia);
                        mostrarVuelos(compañia);
                    }
                    break;
                case 5: // Listar posibles vuelos de origen a destino
                    break;
                case 6: // Salir
                    break;
                default:
                    System.out.println("Error, se equivoco de opción de menú");
            }
            
            System.out.println("");
        } while (opcion != 6);
    }
    
    public static void mostrarDatosAeropuerto(Aeropuerto aeropuertos[]) {
        for (int i = 0; i < Principal.aeropuertos.length; i++) {
            // si el aeropuerto actual es un objeto de la clase AeropuertoPrivado
            if (aeropuertos[i] instanceof AeropuertoPrivado) { 
                System.out.println("Aeropuerto privado: ");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("Pais: " + aeropuertos[i].getPais());
            }
            else {
                System.out.println("Aeropuerto público: ");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("Pais: " + aeropuertos[i].getPais());
            }
            
            System.out.println("");
        }
    }
    
    public static void mostrarPatrocinio(Aeropuerto aeropuertos[]) {
        String empresas[]; // Arreglo de empresas de un aeropuerto Privado
        
        for (Aeropuerto aeropuerto : aeropuertos) {
            if (aeropuerto instanceof AeropuertoPrivado) {
                System.out.println("Aeropuerto Privado: " + aeropuerto.getNombre());
                empresas = ((AeropuertoPrivado) aeropuerto).getListaEmpresas(); // Downcasting
                
                System.out.println("Empresas: ");
                for (String empresa : empresas) {
                    System.out.println(empresa);
                }
            } 
            else {
                System.out.println("Aeropuerto Público: " + aeropuerto.getNombre());
                System.out.println("Subvencion: " 
                        + ((AeropuertoPublico) aeropuerto).getSubvencion()); // Downcasting
            }
            System.out.println("");
        }
    }
    
    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]) {
        boolean encontrado = false;
        int i = 0;
        
        String cadena1 = limpiarCadena(nombre);
        String cadena2 = "";
                
        Aeropuerto aero = null;
        while ((!encontrado) && (i < aeropuertos.length)) {
            cadena2 = limpiarCadena(aeropuertos[i].getNombre());
            if(cadena1.equals(cadena2)) {
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }

        return aero;
    }
    
    /* este método permite eliminar los diacríticos de una cadena de texto
    Ver: https://loquemeinteresadelared.wordpress.com/2015/10/01/eliminar-acentos-y-diacriticos-de-un-string-en-java/
    */
   public static String limpiarCadena(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
    
    public static void mostrarCompañias(Aeropuerto aeropuerto) {
        System.out.println("Las compañias del Aeropuerto: " + aeropuerto.getNombre());
        
        for (int i = 0; i < aeropuerto.getNumCompañias(); i++) {
            System.out.println(aeropuerto.getCompañia(i).getNombre());
        }
    }
    
    public static void mostrarVuelos(Compañia compañia) {
        Vuelo vuelo;
        System.out.println("Los vuelos de la compañia: " +compañia.getNombre());
        
        for (int i = 0; i < compañia.getNumVuelos(); i++) {
            vuelo = compañia.getVuelo(i);
            System.out.println("Identificador: "  + vuelo.getIdentificador());
            System.out.println("Ciudad de origen: " + vuelo.getCiudadOrigen());
            System.out.println("Ciudad destino: " + vuelo.getCiudadDestino());
            System.out.println("Precio: $" + vuelo.getPrecio());
            System.out.println("");
        }
    }
}

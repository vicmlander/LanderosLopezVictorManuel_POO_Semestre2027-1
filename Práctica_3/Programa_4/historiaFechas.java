import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.Set;
/**Práctica 3
    Programación Orientada a Objetos 2027-1

    Melgarejo Cervantes Manuel Alejandro
    Equipo 1
    No cuenta: 322063132
*/
public class historiaFechas {
  public static void main(String[] args) {
    //Seran metodos estaticos independientes
  LinkedList<Date> fechasModificadas = generarHistorialFechas();
    Set<String> reporteModificado = cambiarreportes(fechasModificadas);
    // con esta linea vere si publica despues
  System.out.println(" Reporte diario generado "); 
  for (String reporte : reportesFormateados) {
    System.out.println(reporte);
  }
  }
  /** Generaremos fechas y hora, */
private static LinkedList <Date> listasFechas = new LinkedList<>();

  //Date regrsitra el momento exacto
  Date fechaActual = new Date();
  listaFechas.add(fechaActual):
// Calendar; manipula el tiempo
  Calendar calendario = Calendar.getInstance();
calendario.setTime(fechaActual);

for(int i=0; i<3; i++) { 
  calendario.add(Calendar .DAY_OF_YEAR, 1)

    listaFechas.add(calendario.getTime());
}
return listaFachas;
}

private static Set<String> formatearReportes(LinkedList<Date> fechas) { 
  Set<String> conjuntoReportes = new LinkedHashSet<>();

  StringBuffer cabecera = new StringBuffer("Reporte oficial:");

  for(Date f : fechas) { 
    StringBuilder cuerpoReporte = new StringBuilder();
    cuerpoReporte.append(csbecera)
                  .append("Instante registrado")
                .append(f.toString());
    conjuntoReportes.add(cuerpoReporte.toString());
  }
  return conjuntoReportes;
}
}
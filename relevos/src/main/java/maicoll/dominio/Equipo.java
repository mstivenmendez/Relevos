package maicoll.dominio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Equipo {

   private String nombreEquipo;
   private ExecutorService organizador;
   private long tiempoInicio;
   private long tiempoFin;

   public Equipo(String nombreEquipo) {
      this.nombreEquipo = nombreEquipo;
      this.organizador = Executors.newSingleThreadExecutor();
   }

   public void comenzarCarrera() {
      System.out.println("El equipo " + nombreEquipo + " está listo en la línea de salida.");

      Corredor c1 = new Corredor(nombreEquipo + "-Corredor1");
      Corredor c2 = new Corredor(nombreEquipo + "-Corredor2");
      Corredor c3 = new Corredor(nombreEquipo + "-Corredor3");

      tiempoInicio = System.currentTimeMillis();

      organizador.execute(c1);
      organizador.execute(c2);
      organizador.execute(c3);

      organizador.shutdown();
   }

   public ExecutorService getOrganizador() {
      return organizador;
   }

   public void marcarFin() {
      tiempoFin = System.currentTimeMillis();
   }

   public long getTiempoTotal() {
      return tiempoFin - tiempoInicio;
   }

   public String getNombreEquipo() {
      return nombreEquipo;
   }
}

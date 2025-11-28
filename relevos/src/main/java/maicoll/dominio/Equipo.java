package maicoll.dominio;

public class Equipo extends Thread {

   private String nombreEquipo;
   private Corredor corredor1;
   private Corredor corredor2;
   private Corredor corredor3;

   private long tiempoInicio;
   private long tiempoFin;

   public Equipo(String nombreEquipo) {
      this.nombreEquipo = nombreEquipo;
      inicializarCorredores();
   }

   private void inicializarCorredores() {
      corredor1 = new Corredor(nombreEquipo + "-Corredor1", null, nombreEquipo);
      corredor2 = new Corredor(nombreEquipo + "-Corredor2", corredor1, nombreEquipo);
      corredor3 = new Corredor(nombreEquipo + "-Corredor3", corredor2, nombreEquipo);
   }

   @Override
   public void run() {
      try {
         mostrarMensaje(nombreEquipo + " está listo para competir!");

         tiempoInicio = System.currentTimeMillis();

         corredor1.start();
         corredor2.start();
         corredor3.start();

         corredor1.join();
         corredor2.join();
         corredor3.join();

         tiempoFin = System.currentTimeMillis();

         mostrarMensaje(nombreEquipo + " ha completado la carrera!");

      } catch (InterruptedException e) {
         mostrarMensaje("ERROR: " + nombreEquipo + " fue interrumpido");
      }
   }

   private void mostrarMensaje(String mensaje) {
      System.out.println(mensaje);
   }

   public String getNombreEquipo() {
      return nombreEquipo;
   }

   public long getTiempoTotal() {
      return tiempoFin - tiempoInicio;
   }
}

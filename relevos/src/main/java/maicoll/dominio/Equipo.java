package maicoll.dominio;


   public class Equipo extends Thread {
      private String nombreEquipo;
      private Corredor corredor1;
      private Corredor corredor2;
      private Corredor corredor3;

      public Equipo(String nombreEquipo) {
         this.nombreEquipo = nombreEquipo;
         inicializarCorredores();
      }

      private void inicializarCorredores() {
         // Crear los 3 corredores con la cadena de responsabilidad
         corredor1 = new Corredor(nombreEquipo + "-Corredor1", null, nombreEquipo);
         corredor2 = new Corredor(nombreEquipo + "-Corredor2", corredor1, nombreEquipo);
         corredor3 = new Corredor(nombreEquipo + "-Corredor3", corredor2, nombreEquipo);
      }

      @Override
      public void run() {
         try {
            mostrarMensaje("" + nombreEquipo + " está listo para competir!");

            // Iniciar todos los corredores
            corredor1.start();
            corredor2.start();
            corredor3.start();

            // Esperar a que todos terminen
            corredor1.join();
            corredor2.join();
            corredor3.join();

            mostrarMensaje("" + nombreEquipo + " ha completado la carrera!");

         } catch (InterruptedException e) {
            mostrarMensaje("ERROR: " + nombreEquipo + " fue interrumpido");
            e.printStackTrace();
         }
      }

      private void mostrarMensaje(String mensaje) {
         System.out.println(mensaje);
      }

      public String getNombreEquipo() {
         return nombreEquipo;
      }
   }


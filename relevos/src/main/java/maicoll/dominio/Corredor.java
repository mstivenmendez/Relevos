package maicoll.dominio;

import java.util.Random;


public class Corredor extends Thread {
   private String nombre;
   private Corredor anterior;
   private String nombreEquipo;

   public Corredor(String nombre, Corredor anterior, String nombreEquipo) {
      this.nombre = nombre;
      this.anterior = anterior;
      this.nombreEquipo = nombreEquipo;
   }

   @Override
   public void run() {
      try {
         // RELEVO - Esperar al corredor anterior
         if (anterior != null) {
            mostrarMensaje(this.nombre + " está esperando el testigo de " + anterior.getNombre());
            anterior.join(); // AQUÍ está el join() que pausa este hilo
            mostrarMensaje(this.nombre + " recibió el testigo! ");
         } else {
            mostrarMensaje(this.nombre + " inicia la carrera! ");
         }

         // CORRER - Simular el tiempo de la carrera
         mostrarMensaje(this.nombre + " está corriendo... ");
         int tiempoCorrida = new Random().nextInt(2000) + 1000; // Entre 1 y 3 segundos
         Thread.sleep(tiempoCorrida);

         // FIN DEL TRAMO
         mostrarMensaje(this.nombre + " terminó su tramo y pasa el testigo! ");

      } catch (InterruptedException e) {
         mostrarMensaje("ERROR: " + this.nombre + " fue interrumpido");
         e.printStackTrace();
      }
   }

   private void mostrarMensaje(String mensaje) {
      System.out.println("- " + nombreEquipo + "- " + mensaje);
   }

   public String getNombre() {
      return nombre;
   }
}

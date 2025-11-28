package maicoll;

import maicoll.dominio.Equipo;

public class Main {
   public static void main(String[] args) {

      System.out.println("¡Bienvenido a la Carrera de Relevos!");
      System.out.println("Competirán 3 equipos con 3 corredores cada uno.\n");

      Equipo equipoRojo = new Equipo("Rojo");
      Equipo equipoAzul = new Equipo("Azul");
      Equipo equipoVerde = new Equipo("Verde");

      System.out.println("======================================");
      System.out.println("        ¡LA CARRERA COMIENZA!");
      System.out.println("======================================\n");

      equipoRojo.start();
      equipoAzul.start();
      equipoVerde.start();

      try {
         equipoRojo.join();
         equipoAzul.join();
         equipoVerde.join();

         // Tiempos individuales
         long tiempoRojo = equipoRojo.getTiempoTotal();
         long tiempoAzul = equipoAzul.getTiempoTotal();
         long tiempoVerde = equipoVerde.getTiempoTotal();

         // Determinar ganador
         Equipo ganador = equipoRojo;
         if (tiempoAzul < ganador.getTiempoTotal())
            ganador = equipoAzul;
         if (tiempoVerde < ganador.getTiempoTotal())
            ganador = equipoVerde;

         System.out.println("\n======================================");
         System.out.println("          ¡CARRERA COMPLETADA!");
         System.out.println("======================================");

         System.out.println("Tiempo del equipo Rojo:  " + (tiempoRojo / 1000.0) + " s");
         System.out.println("Tiempo del equipo Azul:  " + (tiempoAzul / 1000.0) + " s");
         System.out.println("Tiempo del equipo Verde: " + (tiempoVerde / 1000.0) + " s");

         System.out.println("\n🏆 EL EQUIPO GANADOR ES: **" + ganador.getNombreEquipo() + "** 🏆");

         System.out.println("======================================");

      } catch (InterruptedException e) {
         System.out.println("Error en la carrera");
      }
   }
}

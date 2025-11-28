package maicoll;

import maicoll.dominio.Equipo;

public class Main {
   public static void main(String[] args) {

      // Mensaje de bienvenida
      System.out.println("¡Bienvenido a la Carrera de Relevos!");
      System.out.println("Competirán 3 equipos con 3 corredores cada uno.\n");

      Equipo equipoRojo = new Equipo(" Rojo");
      Equipo equipoAzul = new Equipo("Azul");
      Equipo equipoVerde = new Equipo("Verde");

      System.out.println("======================================");
      System.out.println("        ¡LA CARRERA COMIENZA!");
      System.out.println("======================================\n");

      long inicio = System.currentTimeMillis();

      equipoRojo.start();
      equipoAzul.start();
      equipoVerde.start();

      try {
         equipoRojo.join();
         equipoAzul.join();
         equipoVerde.join();

         long tiempoTotal = System.currentTimeMillis() - inicio;

         System.out.println("\n======================================");
         System.out.println("          ¡CARRERA COMPLETADA!");
         System.out.println("======================================");
         System.out.println("Tiempo total: " + (tiempoTotal / 1000.0) + " segundos");
         System.out.println("Revisa arriba los detalles de cada corredor.");
         System.out.println("======================================");

      } catch (InterruptedException e) {
         System.out.println("Error en la carrera");
      }
   }
}

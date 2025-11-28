package maicoll;

import maicoll.dominio.Equipo;

import java.util.concurrent.TimeUnit;

public class Main {
   public static void main(String[] args) {

      System.out.println("¡Bienvenido a la Carrera de Relevos!");
      System.out.println("Cada equipo correrá usando un pool de hilos.\n");

      Equipo equipoRojo = new Equipo("Rojo");
      Equipo equipoAzul = new Equipo("Azul");
      Equipo equipoVerde = new Equipo("Verde");

      System.out.println("======================================");
      System.out.println("        ¡LA CARRERA COMIENZA!");
      System.out.println("======================================\n");

      long inicioGeneral = System.currentTimeMillis();

      equipoRojo.comenzarCarrera();
      equipoAzul.comenzarCarrera();
      equipoVerde.comenzarCarrera();

      try {
         equipoRojo.getOrganizador().awaitTermination(10, TimeUnit.SECONDS);
         equipoAzul.getOrganizador().awaitTermination(10, TimeUnit.SECONDS);
         equipoVerde.getOrganizador().awaitTermination(10, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
         System.out.println("Error esperando los equipos");
      }

      // Registrar el final de cada equipo
      equipoRojo.marcarFin();
      equipoAzul.marcarFin();
      equipoVerde.marcarFin();

      long tiempoGeneral = System.currentTimeMillis() - inicioGeneral;

      // Calcular el equipo ganador
      Equipo ganador = equipoRojo;
      if (equipoAzul.getTiempoTotal() < ganador.getTiempoTotal())
         ganador = equipoAzul;
      if (equipoVerde.getTiempoTotal() < ganador.getTiempoTotal())
         ganador = equipoVerde;

      System.out.println("\n======================================");
      System.out.println("          ¡CARRERA COMPLETADA!");
      System.out.println("======================================");
      System.out.println("Tiempo TOTAL del sistema: " + (tiempoGeneral / 1000.0) + " segundos\n");

      System.out.println("Tiempo por equipo:");
      System.out.println("- Rojo: " + (equipoRojo.getTiempoTotal() / 1000.0) + " s");
      System.out.println("- Azul: " + (equipoAzul.getTiempoTotal() / 1000.0) + " s");
      System.out.println("- Verde: " + (equipoVerde.getTiempoTotal() / 1000.0) + " s");

      System.out.println("\n🏆 EL EQUIPO GANADOR ES: **" + ganador.getNombreEquipo() + "** 🏆");
      System.out.println("======================================");
   }
}

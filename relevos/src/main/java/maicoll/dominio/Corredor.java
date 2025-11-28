package maicoll.dominio;

import java.util.Random;

public class Corredor implements Runnable {

   private String nombre;

   public Corredor(String nombre) {
      this.nombre = nombre;
   }

   @Override
   public void run() {
      try {
         System.out.println(nombre + " recibe el testigo y comienza a correr 🏃");

         // Simular tiempo de carrera
         int tiempo = new Random().nextInt(2000) + 1000; // 1 a 3 segundos
         Thread.sleep(tiempo);

         System.out.println(nombre + " terminó su tramo y pasa el testigo ✋");

      } catch (InterruptedException e) {
         System.out.println(nombre + " fue interrumpido ❌");
      }
   }
}

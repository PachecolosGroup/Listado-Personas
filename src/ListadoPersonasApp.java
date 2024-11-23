package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        
        Scanner consola = new Scanner(System.in);
        //Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();

        // Empezamos con el menu
        var salir = false;
        while(!salir){
            mostrarMenu();
            try {
            salir = ejercutarOperacion(consola, personas);
            } catch(Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu(){
        // Mostramos las opciones
        System.out.print("""
                ***** Listado Personas App *****
                1. Agregar
                2. Listar
                3. Salir
                """);
                System.out.print("Propociona la opcion?: ");

    }
    
    private static boolean ejercutarOperacion(Scanner consola, List<Persona> personas){
        var opcion =   Integer.parseInt( consola.nextLine());
        var salir = false;
        // Revisamos la opcion dada
        switch (opcion){
            case 1 ->{ // Agregar persona a la lista
                System.out.println("Proporciona el Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Proporciona el Telefono: ");
                var tel = consola.nextLine();
                System.out.println("Proporciona el Email: ");
                var email = consola.nextLine();
                // Crear el objeto Persona
                var persona = new Persona(nombre, tel, email);
                // Lo agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
            }// fin caso 1
            case 2 -> { // Listar las personas
                System.out.println(" Listado de personas: ");
                // Mejora usando lambda y metodo de referencias
                personas.forEach(System.out::println);
            }
            case 3 -> { // salir del ciblo
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion erronea " + opcion);
        } //fin switch
        return salir;
    }
}


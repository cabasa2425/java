package edu.fje.daw2;

import java.util.Scanner;

public class web {

    private static Scanner scanner = new Scanner(System.in);

    public static Audio crearAudioLibro(String titulo, String autor, String isbn) {
        System.out.println("\n📚 Crear Audiolibro:");

        System.out.print("Duración en minutos: ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        Audio audio = new Audio(titulo, autor, isbn, duracion);
        return audio;
    }
}

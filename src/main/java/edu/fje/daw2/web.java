package edu.fje.daw2;

import java.util.ArrayList;
import java.util.Scanner;

public class web {

    private static ArrayList<AudioLibro> audiolibros = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static AudioLibro crearAudioLibro(String titulo,String autor,String isbn) {
        System.out.println("\n📚 Crear Audiolibro:");

        System.out.print("Duración en minutos: ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        AudioLibro audio = new AudioLibro(titulo, autor, isbn, duracion);
        return audio;
    }
}

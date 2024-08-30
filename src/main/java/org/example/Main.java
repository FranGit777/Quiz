package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pregunta> preguntas = cargarPreguntasDesdeArchivo("Pregunta.txt");

        if (preguntas != null) {
            Quiz quiz = new Quiz(preguntas.toArray(new Pregunta[0]));
            quiz.empezar();
        }
    }

    private static List<Pregunta> cargarPreguntasDesdeArchivo(String archivo) {
        List<Pregunta> preguntas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Leer la pregunta
                String textoPregunta = linea.trim();
                if (textoPregunta.isEmpty()) continue;

                // Leer las respuestas
                String[] respuestas = new String[4];
                for (int i = 0; i < respuestas.length; i++) {
                    String respuesta = br.readLine();
                    if (respuesta == null) {
                        throw new IOException("No se encontraron suficientes respuestas para la pregunta: " + textoPregunta);
                    }
                    respuestas[i] = respuesta.trim();
                }

                // Leer la respuesta correcta (índice basado en 1)
                String respuestaCorrectaStr = br.readLine();
                if (respuestaCorrectaStr == null) {
                    throw new IOException("Falta el índice de la respuesta correcta para la pregunta: " + textoPregunta);
                }
                respuestaCorrectaStr = respuestaCorrectaStr.trim();
                int respuestaCorrectaIndex;
                try {
                    respuestaCorrectaIndex = Integer.parseInt(respuestaCorrectaStr) - 1;
                } catch (NumberFormatException e) {
                    System.err.println("Índice de respuesta incorrecto: " + respuestaCorrectaStr + " para la pregunta: " + textoPregunta);
                    throw e;
                }

                // Crear y agregar la pregunta
                preguntas.add(new Pregunta(textoPregunta, respuestas, respuestaCorrectaIndex));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return preguntas;
    }
}

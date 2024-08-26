package org.example;

import java.util.Scanner;

public class Quiz {
    private Pregunta[] preguntas;
    private int puntaje;

    public Quiz(Pregunta[] preguntas) {
        this.preguntas = preguntas;
        this.puntaje = 0;
    }

    public void empezar() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < preguntas.length; i++) {
            Pregunta pregunta = preguntas[i];
            System.out.println("Pregunta " + (i + 1) + ": " + pregunta.getTexto());
            String[] respuestas = pregunta.getRespuestas();
            for (int j = 0; j < respuestas.length; j++) {
                System.out.println((j + 1) + ". " + respuestas[j]);
            }

            System.out.print("Selecciona una respuesta (1-" + respuestas.length + "): ");
            int respuestaIndex = scanner.nextInt() - 1;

            if (pregunta.esCorrecta(respuestaIndex)) {
                System.out.println("¡Correcto!");
                puntaje++;
            } else {
                System.out.println("Incorrecto.");
            }
        }

        System.out.println("Tu puntaje final es: " + puntaje + "/" + preguntas.length);
        scanner.close();
    }
}
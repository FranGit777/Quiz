package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pregunta[] preguntas = {
                new Pregunta("¿Cuál es la frase mitica de Bananirou? El salto del...", new String[]{"Creeper", "Papu", "Acuaman", "Tigre"}, 1),
                new Pregunta("¿Quien se encarga del lanzacuetes Dave?", new String[]{"El hongo recontra enojado", "El zapallo enojado", "La estrella", "El cactus"}, 1),
                new Pregunta("¿Cuantos pelos tiene el Papu?", new String[]{"1", "Muchos", "0", "Usa peluca"}, 2),
                new Pregunta("¿Cual es el mayor hit de Banatroll?", new String[]{"Kuleando Narkos", "Camarada Comisario", "El rap del Outlas", "California"}, 3),
                new Pregunta("¿Cual es el juego favorito del Papu?", new String[]{"CsGo", "Outlas", "Lol", "Gta SA"}, 2),

        };

        Quiz quiz = new Quiz(preguntas);
        quiz.empezar();
    }
}
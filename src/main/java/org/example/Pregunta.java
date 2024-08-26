package org.example;

 public class Pregunta{
    private String texto;
    private String[] respuestas;
    private int respuestaCorrectaIndex;

    public Pregunta(String texto, String[] respuestas, int respuestaCorrectaIndex) {
    this.texto = texto;
    this.respuestas = respuestas;
    this.respuestaCorrectaIndex = respuestaCorrectaIndex;
    }

    public String getTexto() {
    return texto;
    }

    public String[] getRespuestas() {
    return respuestas;
    }

    public boolean esCorrecta(int respuestaIndex) {
    return respuestaIndex == respuestaCorrectaIndex;
    }
 }

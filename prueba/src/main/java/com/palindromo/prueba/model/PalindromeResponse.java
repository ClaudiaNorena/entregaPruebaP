package com.palindromo.prueba.model;

public class PalindromeResponse {
    private int lengthCadena;
    private int isPalindromo;
    private int lengthCaracteresEspeciales;

    // Constructor vacío para Jackson
    public PalindromeResponse() {}

    // Constructor, getters y setters
    public PalindromeResponse(int lengthCadena, int isPalindromo, int lengthCaracteresEspeciales) {
        this.lengthCadena = lengthCadena;
        this.isPalindromo = isPalindromo;
        this.lengthCaracteresEspeciales = lengthCaracteresEspeciales;
    }

    public int getLengthCadena() {
        return lengthCadena;
    }

    public void setLengthCadena(int lengthCadena) {
        this.lengthCadena = lengthCadena;
    }

    public int getIsPalindromo() {
        return isPalindromo;
    }

    public void setIsPalindromo(int isPalindromo) {
        this.isPalindromo = isPalindromo;
    }

    public int getLengthCaracteresEspeciales() {
        return lengthCaracteresEspeciales;
    }

    public void setLengthCaracteresEspeciales(int lengthCaracteresEspeciales) {
        this.lengthCaracteresEspeciales = lengthCaracteresEspeciales;
    }

}




package com.palindromo.prueba.model;

public class PalindromeRequest {
    private String palindromo;

    // Constructor vacío para Jackson
    public PalindromeRequest() {}

    // Constructor, getters y setters
    public PalindromeRequest(String palindromo) {
        this.palindromo = palindromo;
    }

    public String getPalindromo() {
        return palindromo;
    }

    public void setPalindromo(String palindromo) {
        this.palindromo = palindromo;
    }
}

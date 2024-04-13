package com.palindromo.prueba.controller;

import com.palindromo.prueba.model.PalindromeRequest;
import com.palindromo.prueba.model.PalindromeResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {
    @PostMapping("/")
    public PalindromeResponse processPalindrome(@RequestBody PalindromeRequest request) {
        String palindromo = request.getPalindromo();

        // Calcular lengthCadena
        int lengthCadena = palindromo.length();

        // Limpiar la cadena para verificar si es palíndromo
        String cleanedString = palindromo.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int isPalindromo = cleanedString.equals(new StringBuilder(cleanedString).reverse().toString()) ? 1 : 0;

        // Contar caracteres especiales excluyendo espacios en blanco
        int lengthCaracteresEspeciales = palindromo.replaceAll("[a-zA-Z0-9 ]", "").length();


        // Crear y devolver la respuesta
        PalindromeResponse response = new PalindromeResponse(lengthCadena, isPalindromo, lengthCaracteresEspeciales);
        return response;
    }
}

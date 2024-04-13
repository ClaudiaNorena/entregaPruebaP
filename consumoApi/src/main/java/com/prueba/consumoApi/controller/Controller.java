package com.prueba.consumoApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @GetMapping("/buscar")
    public ResponseEntity<String> buscarPorNombre(@RequestParam(value = "name", defaultValue = "Claudia") String name) {
        // URL base con el parámetro 'name'
        String baseUrl = "https://sisedevco.ikeasistencia.com/api-swagger/api/v1/controller/test";
        String url = baseUrl + "?name=" + name;

        //Instancia de RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Solicitud GET a la URL
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            // Manejo de códigos de estado HTTP
            int statusCode = response.getStatusCodeValue();

            if (statusCode == HttpStatus.FOUND.value()) {
                // Código 302 (FOUND): Maneja la respuesta cuando se encuentra el nombre
                String output = response.getBody();
                return ResponseEntity.ok("" + output);
            } else if (statusCode == HttpStatus.NOT_FOUND.value()) {
                // Código 404 (NOT FOUND): Maneja la respuesta cuando no hay resultados
                return ResponseEntity.ok("Sin resultados.");
            } else {
                // Códigos de estado inesperados
                return ResponseEntity.status(statusCode).body("Respuesta inesperada del servidor.");
            }

        } catch (HttpClientErrorException e) {
            // Errores del cliente (códigos de error 4xx)
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return ResponseEntity.ok("Sin resultados.");
            }
            // Manejo de códigos de error del cliente
            return ResponseEntity.status(e.getStatusCode()).body("Error del cliente: " + e.getMessage());
        } catch (HttpServerErrorException e) {
            // Manejo errores del servidor (códigos de error 5xx)
            return ResponseEntity.status(e.getStatusCode()).body("Error del servidor: " + e.getMessage());
        } catch (Exception e) {
            // Manejo excepciones generales
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió una excepción: " + e.getMessage());
        }
    }
}

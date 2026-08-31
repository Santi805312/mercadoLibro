package com.ingenieriaSoftware2.DTO.Response;

public record AuthResponseDTO(
        String token,
        String username,
        String email,
        String rol,
        Integer puntos
) {
}

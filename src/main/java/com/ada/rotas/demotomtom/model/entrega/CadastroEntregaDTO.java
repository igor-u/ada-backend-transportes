package com.ada.rotas.demotomtom.model.entrega;

import com.ada.rotas.demotomtom.model.rota.Rota;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record CadastroEntregaDTO(
        @NotBlank(message = "Descrição é obrigatória")
        String descricao,
        @DateTimeFormat
        LocalDateTime inicio,
        @DateTimeFormat
        LocalDateTime fim,
        @NotNull(message = "Rota é obrigatória")
                @Valid
        Rota rota) {
}

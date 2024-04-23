package com.ada.rotas.demotomtom.model;

import com.ada.rotas.demotomtom.model.rota.Rota;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Entrega")
@Table(name = "entregas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrega;
    @OneToOne
    private Rota rota;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public void atualizar(Entrega atualizacao) {
        this.rota = atualizacao.getRota();
        this.inicio = atualizacao.inicio;
        this.fim = atualizacao.fim;
    }
}

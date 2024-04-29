package com.ada.rotas.demotomtom.model.entrega;

import com.ada.rotas.demotomtom.model.rota.Rota;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;

@Entity(name = "Entrega")
@Table(name = "entregas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrega;
    private String descricao;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Boolean ativa = true;
    @ManyToOne
    private Rota rota;

    public Entrega(CadastroEntregaDTO dados) {
        this.descricao = dados.descricao();
        this.inicio = dados.inicio();
        this.fim = dados.fim();
        if(this.fim != null) {
            this.ativa = false;
        }
        this.rota = dados.rota();
    }

    public void atualizar(Entrega atualizacao) {
        if(atualizacao.getDescricao() != null) {
            this.descricao = atualizacao.getDescricao();
        }
        if(atualizacao.getInicio() != null) {
            this.inicio = atualizacao.inicio;
        }
        if(atualizacao.getFim() != null) {
            this.fim = atualizacao.fim;
            this.ativa = false;
        }
        if(atualizacao.getRota() != null) {
            this.rota = atualizacao.getRota();
        }
    }

    public void finalizar() {
        this.fim = LocalDateTime.now();
        excluir();
    }

    public void excluir() {
        this.ativa = false;
    }
}

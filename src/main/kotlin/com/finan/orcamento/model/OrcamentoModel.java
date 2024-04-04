package com.finan.orcamento.model;

import com.finan.orcamento.model.enums.IcmsEstados;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orcamento")
public class OrcamentoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private IcmsEstados icmsEstados;

    @NotNull
    @Column(name="valor_orcamento")
    private BigDecimal valorOrcamento;

    @Column(name="desconto_orcamento")//O valor inserido é calculado como porcentagem(ex:80 = 80%)
    private BigDecimal descontoOrcamento;

    @NotNull
    @Column(name="QtdItens")
    private BigDecimal qtdItens;


    @Column(name="valor_icms")
    private BigDecimal valorICMS;

    @Column(name="Final")
    private BigDecimal calculofinal;

    private BigDecimal cent = BigDecimal.valueOf(100);


    public BigDecimal getCalculofinal() {
       calculofinal = ((cent.subtract(descontoOrcamento)).divide(cent).multiply(valorOrcamento.multiply(qtdItens)));
        return calculofinal;
    }


    @ManyToOne
    @JoinColumn(name="usuario_id", referencedColumnName = "id")
    private UsuarioModel usuario;

    public void calcularIcms() {
        this.valorICMS = this.icmsEstados.getStrategy().calcular(this.valorOrcamento);
    }

}


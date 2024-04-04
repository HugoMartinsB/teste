package com.finan.orcamento.model;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import com.finan.orcamento.model.OrcamentoModel;

public class OrcamentoProxy extends OrcamentoModel {
    private BigDecimal descontoOrcamento;
    //Objeto original
    private  OrcamentoModel orcamentoModel;
    private BigDecimal calculoFinal;

    public OrcamentoProxy(OrcamentoModel orcamentoModel) {
        this.orcamentoModel = orcamentoModel;
    }

    @NotNull
    @Override
    public BigDecimal getDescontoOrcamento() {
        if(descontoOrcamento == null){
            this.descontoOrcamento = orcamentoModel.getDescontoOrcamento();
        }
        return descontoOrcamento;
    }

    @Override
    public void setDescontoOrcamento(BigDecimal descontoOrcamento) {
        this.descontoOrcamento = descontoOrcamento;
    }






    //private BigDecimal calculofinal = (valorOrcamento.subtract(descontoOrcamento)).multiply(qtdItens);
}

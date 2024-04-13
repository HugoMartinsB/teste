package com.finan.orcamento.service;

import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.repositories.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {
    @Autowired
    private OrcamentoRepository orcamentoRepository;

    public List<OrcamentoModel> buscarCadastro(){
        return orcamentoRepository.findAll();
    }
    public OrcamentoModel buscaId(Long id){
        Optional<OrcamentoModel>obj= orcamentoRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Orçamento não encontrado");
        }
    }
    public OrcamentoModel cadastrarOrcamento(OrcamentoModel orcamentoModel){
        //calcula ICMS
        //calculoICMS(orcamentoModel)
        orcamentoModel.calcularIcms();
        return orcamentoRepository.save(orcamentoModel);
    }

    public OrcamentoModel atualizaCadastro(OrcamentoModel orcamentoModel, Long id){
        OrcamentoModel newOrcamentoModel = buscaId(id);
        //calcula ICMS
        //calculoICMS(orcamentoModel);
       newOrcamentoModel.setValorOrcamento(orcamentoModel.getValorOrcamento());
       newOrcamentoModel.setValorICMS(orcamentoModel.getValorICMS());
        return orcamentoRepository.save(newOrcamentoModel);
    }
    public void deletaOrcamento(Long id){
        orcamentoRepository.deleteById(id);
    }

    //funções
    //Função calcula ICMS
   public void calculoICMS(OrcamentoModel orcamentoModel) {
        BigDecimal valorOrcamento = orcamentoModel.getValorOrcamento();
        String icmsEstados = orcamentoModel.getIcmsEstados().toString();
        BigDecimal icmsMG = new BigDecimal("0.18");
        BigDecimal icmsSP = new BigDecimal("0.18");
        BigDecimal icmsRJ = new BigDecimal("0.22");
        BigDecimal icmsRS = new BigDecimal("0.17");
        BigDecimal icmsPR = new BigDecimal("0.195");
        BigDecimal icmsSC = new BigDecimal("0.17");
        BigDecimal icmsBA = new BigDecimal("0.205");
        BigDecimal icmsDF = new BigDecimal("0.20");
        BigDecimal icmsGO = new BigDecimal("0.19");
        BigDecimal icmsPA = new BigDecimal("0.19");
        BigDecimal icmsMT = new BigDecimal("0.17");
        BigDecimal icmsPE = new BigDecimal("0.205");
        BigDecimal icmsCE = new BigDecimal("0.20");
        BigDecimal icmsES = new BigDecimal("0.17");
        if (icmsEstados.equals("ICMS_MG")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsMG));
        } else if (icmsEstados.equals("ICMS_SP")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsSP));
        } else if (icmsEstados.equals("ICMS_RJ")){
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsRJ));
        } else if (icmsEstados.equals("ICMS_RS")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsRS));
        } else if(icmsEstados.equals("ICMS_PR")){
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsPR));
        } else if (icmsEstados.equals("ICMS_SC")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsSC));
        } else if (icmsEstados.equals("ICMS_BA")){
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsBA));
        } else if (icmsEstados.equals("ICMS_DF")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsDF));
        } else if (icmsEstados.equals("ICMS_GO")){
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsGO));
        } else if (icmsEstados.equals("ICMS_PA")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsPA));
        } else if (icmsEstados.equals("ICMS_MT")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsMT));
        } else if (icmsEstados.equals("ICMS_PE")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsPE));
        } else if (icmsEstados.equals("ICMS_CE")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsCE));
        } else if (icmsEstados.equals("ICMS_ES")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsES));
        }
   }
}

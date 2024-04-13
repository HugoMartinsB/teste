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
        BigDecimal icmsMS = new BigDecimal("0.17");
        BigDecimal icmsAM = new BigDecimal("0.20");
        BigDecimal icmsMA = new BigDecimal("0.22");
        BigDecimal icmsRN = new BigDecimal("0.18");
        BigDecimal icmsPB = new BigDecimal("0.20");
        BigDecimal icmsAL = new BigDecimal("0.19");
        BigDecimal icmsPI = new BigDecimal("0.21");
        BigDecimal icmsRO = new BigDecimal("0.195");
        BigDecimal icmsSE = new BigDecimal("0.19");
        BigDecimal icmsTO = new BigDecimal("0.20");
        BigDecimal icmsAC = new BigDecimal("0.19");
        BigDecimal icmsAP = new BigDecimal("0.18");
        BigDecimal icmsRR = new BigDecimal("0.20");
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
        } else if (icmsEstados.equals("ICMS_MS")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsMS));
        } else if (icmsEstados.equals("ICMS_AM")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsAM));
        } else if (icmsEstados.equals("ICMS_MA")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsMA));
        } else if (icmsEstados.equals("ICMS_RN")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsRN));
        } else if (icmsEstados.equals("ICMS_PB")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsPB));
        } else if (icmsEstados.equals("ICMS_AL")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsAL));
        } else if (icmsEstados.equals("ICMS_PI")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsPI));
        } else if (icmsEstados.equals("ICMS_RO")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsRO));
        } else if (icmsEstados.equals("ICMS_SE")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsSE));
        } else if (icmsEstados.equals("ICMS_TO")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsTO));
        } else if (icmsEstados.equals("ICMS_AC")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsAC));
        } else if (icmsEstados.equals("ICMS_AP")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsAP));
        } else if (icmsEstados.equals("ICMS_RR")) {
            orcamentoModel.setValorICMS(valorOrcamento.multiply(icmsRR));
        }
   }
}

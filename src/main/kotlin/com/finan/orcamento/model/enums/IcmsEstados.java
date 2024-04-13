package com.finan.orcamento.model.enums;

import com.finan.orcamento.service.ICMSOrcamento.*;

public enum IcmsEstados {
    ICMS_MG(new IcmsMG()),
    ICMS_SP(new IcmsSP()),
    ICMS_RJ(new IcmsRJ()),
    ICMS_RS(new IcmsRS()),
    ICMS_PR(new IcmsPR()),
    ICMS_SC(new IcmsSC()),
    ICMS_BA(new IcmsBA()),
    ICMS_DF(new IcmsDF()),
    ICMS_GO(new IcmsGO()),
    ICMS_PA(new IcmsPA()),
    ICMS_MT(new IcmsMT()),
    ICMS_PE(new IcmsPE()),
    ICMS_CE(new IcmsCE()),
    ICMS_ES(new IcmsES());


    private final IcmsStrategy strategy;

    IcmsEstados(IcmsStrategy strategy) {
        this.strategy = strategy;
    }

    public IcmsStrategy getStrategy() {
        return this.strategy;
    }

}
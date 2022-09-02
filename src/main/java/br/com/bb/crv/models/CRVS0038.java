package br.com.bb.crv.models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

 public class CRVS0038 {
    
    private LocalDate dtBase;
    private LocalDate dtFinalE;
    private int diasCorridos;
    private int diasUteis;

    public int getDiasCorridos() {
        return diasCorridos;
    }
    public void setDiasCorridos(int diasCorridos) {
        this.diasCorridos = diasCorridos;
    }
    public int getDiasUteis() {
        return diasUteis;
    }
    public void setDiasUteis(int diasUteis) {
        this.diasUteis = diasUteis;
    }
    public LocalDate getDtBase() {
        return dtBase;
    }
    public void setDtBase(LocalDate dtBase) {
        this.dtBase = dtBase;
    }
    public LocalDate getDtFinalE() {
        return dtFinalE;
    }
    public void setDtFinalE(LocalDate dtFinalE) {
        this.dtFinalE = dtFinalE;
    }
    

    public CRVS0038 calculaComDiasCorridos(LocalDate dtBase, int diasCorridos){

        CRVS0038 dataInfo = new CRVS0038();

        LocalDate dtFinal = dtBase.plusDays(diasCorridos);
        dataInfo.setDtFinalE(dtFinal);
        dataInfo.setDiasCorridos(diasCorridos);
        int diasUteis = 0;
        LocalDate dataAuxiliar = dtBase;

        if(dataAuxiliar.getDayOfWeek() != DayOfWeek.SATURDAY && dataAuxiliar.getDayOfWeek() != DayOfWeek.SATURDAY)
            diasUteis++;

        for (int i = 0; i < diasCorridos; i++,  dataAuxiliar = dataAuxiliar.plusDays(1)) {
            if(dataAuxiliar.getDayOfWeek() != DayOfWeek.SATURDAY && dataAuxiliar.getDayOfWeek() != DayOfWeek.SUNDAY)
                diasUteis++;
        }

        dataInfo.setDiasUteis(diasUteis);
        dataInfo.setDiasCorridos(diasCorridos);
        dataInfo.setDtBase(dtBase);
        dataInfo.setDtFinalE(dtBase.plusDays(diasCorridos));
        
        return dataInfo;
    }
    public CRVS0038 calculaComDiasUteis(LocalDate dtBase, int diasUteis){

        CRVS0038 dataInfo = new CRVS0038();
        LocalDate dataAuxiliar = dtBase;
        int contagemDias = diasUteis;

        if(dataAuxiliar.getDayOfWeek() != DayOfWeek.SATURDAY && dataAuxiliar.getDayOfWeek() != DayOfWeek.SUNDAY){
                contagemDias--;
                dataAuxiliar = dataAuxiliar.plusDays(1);
            }

        int i = 0;
        for (i = 0; contagemDias > 0; i++,  dataAuxiliar = dataAuxiliar.plusDays(1)){
            if(dataAuxiliar.getDayOfWeek() != DayOfWeek.SATURDAY && dataAuxiliar.getDayOfWeek() != DayOfWeek.SUNDAY){
                contagemDias--;
            }
        }

        dataInfo.setDiasCorridos(i);
        dataInfo.setDiasUteis(contagemDias);
        dataInfo.setDtBase(dtBase);
        dataInfo.setDtFinalE(dtBase.plusDays(i));

        return dataInfo;
    }
    public CRVS0038 calculaComDatas(LocalDate dtBase, LocalDate dtFinal){

        CRVS0038 dataInfo = new CRVS0038();
        long periodo = ChronoUnit.DAYS.between(dtBase, dtFinal);
       

        LocalDate dataAuxiliar = dtBase;
        int diasUteis = 0;

        if(dataAuxiliar.getDayOfWeek() != DayOfWeek.SATURDAY && dataAuxiliar.getDayOfWeek() != DayOfWeek.SUNDAY)
                diasUteis++;

        int i = 0;

        for (i = 0; i < periodo; i++, dataAuxiliar = dataAuxiliar.plusDays(1)) {

            if(dataAuxiliar.getDayOfWeek() != DayOfWeek.SATURDAY && dataAuxiliar.getDayOfWeek() != DayOfWeek.SUNDAY)
                diasUteis++;
        }

        dataInfo.setDiasCorridos(i);
        dataInfo.setDiasUteis(diasUteis);
        dataInfo.setDtBase(dtBase);
        dataInfo.setDtFinalE(dtFinal);

        return dataInfo;
    }

}

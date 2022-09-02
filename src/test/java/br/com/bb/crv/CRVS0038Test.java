package br.com.bb.crv;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.bb.crv.models.CRVS0038;


public class CRVS0038Test {

    @Test 
    public void VerificaComDatas() {

        CRVS0038 testing = new CRVS0038();
        LocalDate hoje = LocalDate.of(2022, 8, 30);;
        int diasCorridos = 1000;
        LocalDate futuro = LocalDate.of(2025, 5, 26);
        
        testing  = testing.calculaComDatas(hoje, futuro);


        assertEquals( diasCorridos, testing.getDiasCorridos()); 

        //resposta 690 + 30 feriados = 720
        assertEquals( 715, testing.getDiasUteis()); 
    }

    @Test 
    public void VerificaComDiasCorridos() {

        CRVS0038 testing = new CRVS0038();
        LocalDate hoje = LocalDate.of(2022, 8, 30);;
        int diasCorridos = 1000;
        LocalDate amanha = hoje.plusDays(diasCorridos); 
        testing  = testing.calculaComDiasCorridos(hoje, diasCorridos);
        

        assertEquals( 715, testing.getDiasUteis()); 
        assertEquals(amanha.toString(), testing.getDtFinalE().toString());
    }

    @Test 
    public void VerificaComDiasUteis() {

        CRVS0038 testing = new CRVS0038();
        LocalDate hoje = LocalDate.of(2022, 8, 30);
        int diasUteis = 715;
        int diasCorridos = 1000;
        LocalDate amanha = hoje.plusDays(diasCorridos); 
        testing  = testing.calculaComDiasUteis(hoje, diasUteis);
        

        assertEquals( diasCorridos, testing.getDiasCorridos()); 
        assertEquals(amanha.toString(), testing.getDtFinalE().toString());
    }
    
}

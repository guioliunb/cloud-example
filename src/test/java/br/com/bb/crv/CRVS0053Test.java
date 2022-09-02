package br.com.bb.crv;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.bb.crv.dao.CRVS0053Dao;
import br.com.bb.crv.models.CRVS0053;
import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.json.JsonObject;


@QuarkusTest
public class CRVS0053Test {

    @Inject
    CRVS0053Dao dao;

    
    @Test
    public void TestingAtualizarVertice() throws Exception {
        boolean resultado = false;
        resultado = dao.processamentoCRVS0053();
        assertEquals(true, resultado);
    }

    @Test
    public void testProcesssa() {
        given().when().header("Content-Type", "application/json")
        .body("").put("/crvs0053/processa").then().statusCode(200);
    }

    //Testing CRUD
    
    @Test
    public void testGet() {
        given().when().header("Content-Type", "application/json")
        .body("").get("/crvs0053").then().statusCode(200);
    }
    
    @Test
    public void testPost() {
        JsonObject json = new JsonObject();
        LocalDate data = LocalDate.now();
        json.put("cd_crv_opt", "1");
        json.put("nr_vrs_crv_opt", "1");
        json.put("dt_cric_vtce_crv", data.toString());
        json.put("nr_vtce_crv_opt", "1");
        json.put("cd_mtdl_cnv_ftr", "1");
        json.put("cd_est_vtce_crv", "1");
        json.put("cd_rgr_cric_vtce", "1");
        json.put("ic_lqdz_clcd_vtce", "1");
        json.put("ic_lqdz_ref_vtce", "1");
        json.put("nr_agpt_crv_opt", "1");
        json.put("nr_pz_dd_crrd_util", "1");
        json.put("nr_pz_dd_crrd_vtce", "1");
        json.put("nr_pz_vtce_crv_op", "1");
        json.put("in_vtce_fxo", "S");
        json.put("cd_dado_mc_ic_lqdz", "String");
        json.put("nm_vtce_ordn_crid", "String");



        given().when().header("Content-Type", "application/json")
        .body(json.toString()).post("/crvs0053").then().statusCode(200);
    }
    @Test
    public void testPut() {

        //Caso exista 1 registro pelo menos

        JsonObject json = new JsonObject();
        LocalDate data = LocalDate.now();
        //Busca o primeiro registro inserido para atualização
        json.put("cd_instancia", "1");

        json.put("cd_crv_opt", "1");
        json.put("nr_vrs_crv_opt", "1");
        json.put("dt_cric_vtce_crv", data.toString());
        json.put("nr_vtce_crv_opt", "1");
        json.put("cd_mtdl_cnv_ftr", "1");
        json.put("cd_est_vtce_crv", "1");
        json.put("cd_rgr_cric_vtce", "1");
        json.put("ic_lqdz_clcd_vtce", "1");
        json.put("ic_lqdz_ref_vtce", "1");
        json.put("nr_agpt_crv_opt", "1");
        json.put("nr_pz_dd_crrd_util", "1");
        json.put("nr_pz_dd_crrd_vtce", "1");
        json.put("nr_pz_vtce_crv_op", "1");
        json.put("in_vtce_fxo", "S");
        json.put("cd_dado_mc_ic_lqdz", "String");
        json.put("nm_vtce_ordn_crid", "String");
        
        given().when().header("Content-Type", "application/json")
        .body(json.toString()).put("/crvs0053/atualiza").then().statusCode(200);
    }

    @Test
    public void testDeletar(){
        given().when().header("Content-Type", "application/json")
        .body("").delete("/crvs0053/deletar/1").then().statusCode(200);
    }
    
    
    @Test
    public void testSQLAtualizacao() {

        //Caso exista 1 registro pelo menos

        JsonObject json = new JsonObject();
        LocalDate data = LocalDate.now();
        //Busca o primeiro registro inserido para atualização
        json.put("cd_instancia", "1");

        json.put("cd_crv_opt", "1");
        json.put("nr_vrs_crv_opt", "1");
        json.put("dt_cric_vtce_crv", data.toString());
        json.put("nr_vtce_crv_opt", "1");
        json.put("cd_mtdl_cnv_ftr", "1");
        json.put("cd_est_vtce_crv", "1");
        json.put("cd_rgr_cric_vtce", "1");
        json.put("ic_lqdz_clcd_vtce", "1");
        json.put("ic_lqdz_ref_vtce", "1");
        json.put("nr_agpt_crv_opt", "1");
        json.put("nr_pz_dd_crrd_util", "1");
        json.put("nr_pz_dd_crrd_vtce", "1");
        json.put("nr_pz_vtce_crv_op", "1");
        json.put("in_vtce_fxo", "S");
        json.put("cd_dado_mc_ic_lqdz", "String");
        json.put("nm_vtce_ordn_crid", "String");

        given().when().header("Content-Type", "application/json")
        .body(json.toString()).put("/crvs0053/atualizaWhere").then().statusCode(200);
    }



    @Test
    public void testValidaFalseCd_crv_opt(){
        CRVS0053 bookFalse = new CRVS0053();
        
        bookFalse.setCd_crv_opt(0);
        int resultado = dao.validaEntrada(bookFalse);
        assertEquals(resultado, 602);
    }
    @Test
    public void testValidaFalseNr_vrs_crv_opt(){
        CRVS0053 bookFalse = new CRVS0053();

        bookFalse.setCd_crv_opt(1);
        int resultado = dao.validaEntrada(bookFalse);
        assertEquals(resultado, 604);
    }

    @Test
    public void testValidaFalseDt_cric_vtce_crv(){
        CRVS0053 bookFalse = new CRVS0053();
        
        bookFalse.setCd_crv_opt(1);
        bookFalse.setNr_vrs_crv_opt(1);
        int resultado = dao.validaEntrada(bookFalse);
        assertEquals(resultado, 605);
    }

    @Test
    public void testValidaFalseNr_vtce_crv_opt(){
        CRVS0053 bookFalse = new CRVS0053();
        
        bookFalse.setCd_crv_opt(1);
        bookFalse.setNr_vrs_crv_opt(1);
        bookFalse.setDt_cric_vtce_crv(LocalDate.now());
        int resultado = dao.validaEntrada(bookFalse);
        assertEquals(resultado, 610);
    }

    @Test
    public void testValidaFalseIn_vtce_fxo(){
        CRVS0053 bookFalse = new CRVS0053();
        
        bookFalse.setCd_crv_opt(1);
        bookFalse.setNr_vrs_crv_opt(1);
        bookFalse.setDt_cric_vtce_crv(LocalDate.now());
        bookFalse.setNr_vtce_crv_opt(1);
        int resultado = dao.validaEntrada(bookFalse);
        assertEquals(resultado, 614);
    }
    @Test
    public void testValidaFalse2In_vtce_fxo(){
        CRVS0053 bookFalse = new CRVS0053();
        
        bookFalse.setCd_crv_opt(1);
        bookFalse.setNr_vrs_crv_opt(1);
        bookFalse.setDt_cric_vtce_crv(LocalDate.now());
        bookFalse.setNr_vtce_crv_opt(1);
        bookFalse.setIn_vtce_fxo("X");
        int resultado = dao.validaEntrada(bookFalse);
        assertEquals(resultado, 615);
    }
    @Test
    public void testValidaFalseCd_mtdl_cnv_ftr(){
        CRVS0053 bookFalse = new CRVS0053();
        
        bookFalse.setCd_crv_opt(1);
        bookFalse.setNr_vrs_crv_opt(1);
        bookFalse.setDt_cric_vtce_crv(LocalDate.now());
        bookFalse.setNr_vtce_crv_opt(1);
        bookFalse.setIn_vtce_fxo("S");
        int resultado = dao.validaEntrada(bookFalse);
        assertEquals(resultado, 619);
    }
    @Test
    public void testValidaFalseCd_est_vtce_crv(){
        CRVS0053 bookFalse = new CRVS0053();
        
        bookFalse.setCd_crv_opt(1);
        bookFalse.setNr_vrs_crv_opt(1);
        bookFalse.setDt_cric_vtce_crv(LocalDate.now());
        bookFalse.setNr_vtce_crv_opt(1);
        bookFalse.setIn_vtce_fxo("S");
        bookFalse.setCd_mtdl_cnv_ftr(1);
        int resultado = dao.validaEntrada(bookFalse);
        assertEquals(resultado, 621);
    }

    @Test
    public void testValidaFalse2Cd_est_vtce_crv(){
        CRVS0053 bookFalse = new CRVS0053();
        
        bookFalse.setCd_crv_opt(1);
        bookFalse.setNr_vrs_crv_opt(1);
        bookFalse.setDt_cric_vtce_crv(LocalDate.now());
        bookFalse.setNr_vtce_crv_opt(1);
        bookFalse.setIn_vtce_fxo("S");
        bookFalse.setCd_mtdl_cnv_ftr(8);
        int resultado = dao.validaEntrada(bookFalse);
        assertEquals(resultado, 621);
    }

    @Test
    public void testValidaFalseCd_rgr_cric_vtce(){
        CRVS0053 bookFalse = new CRVS0053();
        
        bookFalse.setCd_crv_opt(1);
        bookFalse.setNr_vrs_crv_opt(1);
        bookFalse.setDt_cric_vtce_crv(LocalDate.now());
        bookFalse.setNr_vtce_crv_opt(1);
        bookFalse.setIn_vtce_fxo("S");
        bookFalse.setCd_mtdl_cnv_ftr(1);
        bookFalse.setCd_est_vtce_crv(1);
        int resultado = dao.validaEntrada(bookFalse);
        assertEquals(resultado, 623);
    }

    @Test
    public void testValidaEntrada(){
        CRVS0053 bookTrue = new CRVS0053();
        
        bookTrue.setCd_crv_opt(1);
        bookTrue.setNr_vrs_crv_opt(1);
        bookTrue.setDt_cric_vtce_crv(LocalDate.now());
        bookTrue.setNr_vtce_crv_opt(1);
        bookTrue.setIn_vtce_fxo("S");
        bookTrue.setCd_mtdl_cnv_ftr(1);
        bookTrue.setCd_est_vtce_crv(1);
        bookTrue.setCd_rgr_cric_vtce(1);
        int resultado = dao.validaEntrada(bookTrue);
        assertEquals(resultado, 0);
    }

    @Test
    public void testValidaUpdateRegistro(){
        CRVS0053 bookTrue = new CRVS0053();
        
        bookTrue.setCd_crv_opt(1);
        bookTrue.setNr_vrs_crv_opt(1);
        bookTrue.setDt_cric_vtce_crv(LocalDate.now());
        bookTrue.setNr_vtce_crv_opt(1);
        bookTrue.setIn_vtce_fxo("S");
        bookTrue.setCd_mtdl_cnv_ftr(1);
        bookTrue.setCd_est_vtce_crv(1);
        bookTrue.setCd_rgr_cric_vtce(1);

        boolean resultado = false;
        
        try {
            resultado = dao.mergeVerticeWhere(bookTrue);
        } catch (Exception e) {
           Assertions.fail("Processamento falho");
        }

        Assertions.assertEquals(resultado, true);


    }

    
}

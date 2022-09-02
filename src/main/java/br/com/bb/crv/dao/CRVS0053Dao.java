package br.com.bb.crv.dao;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.ApplicationPath;

import org.eclipse.microprofile.opentracing.Traced;

import br.com.bb.crv.models.CRVS0053;

@Traced
@ApplicationScoped
public class CRVS0053Dao {

    @PersistenceContext
    EntityManager em;

    // CRUD + MODULO CRVS0053

    public List<CRVS0053> buscarCRVS0053() throws Exception {
        String nameQuery = "CONSULTAR_TABELA";

        try {
            TypedQuery<CRVS0053> query = em.createNamedQuery(nameQuery, CRVS0053.class);
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        } catch (PersistenceException e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public CRVS0053 inserirCRVS0053(CRVS0053 book) throws Exception {

        // POST

        CRVS0053 persist = new CRVS0053();


        persist.setDt_cric_vtce_crv(book.getDt_cric_vtce_crv());
        persist.setCd_crv_opt(book.getCd_crv_opt());
        persist.setNr_vrs_crv_opt(book.getNr_vrs_crv_opt() );
        persist.setNr_agpt_crv_opt(book.getNr_agpt_crv_opt());
        persist.setNr_pz_vtce_crv_opt(book.getNr_pz_vtce_crv_opt());
        persist.setNr_pz_dd_crrd_vtce(book.getNr_pz_dd_crrd_vtce());
        persist.setNr_pz_dd_crrd_util(book.getNr_pz_dd_crrd_util());
        persist.setIn_vtce_fxo(book.getIn_vtce_fxo());
        persist.setIc_lqdz_clcd_vtce(book.getIc_lqdz_clcd_vtce());
        persist.setIc_lqdz_ref_vtce(book.getIc_lqdz_ref_vtce());
        persist.setCd_dado_mc_ic_lqdz(book.getCd_dado_mc_ic_lqdz());
        persist.setCd_mtdl_cnv_ftr(book.getCd_mtdl_cnv_ftr());
        persist.setCd_est_vtce_crv(book.getCd_est_vtce_crv());
        persist.setNm_vtce_ordn_crid(book.getNm_vtce_ordn_crid());
        persist.setCd_rgr_cric_vtce(book.getCd_rgr_cric_vtce());

        try {
            em.persist(persist);
        } catch (PersistenceException p) {
            throw new Exception(p);
        }

        return persist;
    }

    @Transactional
    public boolean processamentoCRVS0053() throws Exception {

        List<CRVS0053> lista = buscarCRVS0053();

        // Executor Service
        System.out.println(System.currentTimeMillis());
        lista.stream().forEach(
                k -> {
                    int entrada;

                    try {
                        entrada = validaEntrada(k);
                        if (entrada == 0)
                            mergeVerticeWhere(k);
                        else
                            System.err.println("Entrada invalida. Código de retorno cobol: " + entrada);
                    } catch (Exception e) {

                        System.err.println(e);
                    }

                });

        System.out.println("Processamento concluído");

        return true;
    }

    @Transactional
    public boolean mergeRegistro(CRVS0053 book) throws Exception {

        // após definição de identificador
        CRVS0053 persist = em.find(CRVS0053.class, book.getCd_instancia());

        persist.setDt_cric_vtce_crv(book.getDt_cric_vtce_crv());
        persist.setCd_crv_opt(book.getCd_crv_opt());
        persist.setNr_vrs_crv_opt(book.getNr_vrs_crv_opt() );
        persist.setNr_agpt_crv_opt(book.getNr_agpt_crv_opt());
        persist.setNr_pz_vtce_crv_opt(book.getNr_pz_vtce_crv_opt());
        persist.setNr_pz_dd_crrd_vtce(book.getNr_pz_dd_crrd_vtce());
        persist.setNr_pz_dd_crrd_util(book.getNr_pz_dd_crrd_util());
        persist.setIn_vtce_fxo(book.getIn_vtce_fxo());
        persist.setIc_lqdz_clcd_vtce(book.getIc_lqdz_clcd_vtce());
        persist.setIc_lqdz_ref_vtce(book.getIc_lqdz_ref_vtce());
        persist.setCd_dado_mc_ic_lqdz(book.getCd_dado_mc_ic_lqdz());
        persist.setCd_mtdl_cnv_ftr(book.getCd_mtdl_cnv_ftr());
        persist.setCd_est_vtce_crv(book.getCd_est_vtce_crv());
        persist.setNm_vtce_ordn_crid(book.getNm_vtce_ordn_crid());
        persist.setCd_rgr_cric_vtce(book.getCd_rgr_cric_vtce());

        try {
            em.merge(persist);
        } catch (Exception e) {
            return false;
        }
       
        return true;
    }

    @Transactional
    public boolean mergeVerticeWhere(CRVS0053 book) throws Exception {

        try {
            em.createNamedQuery("Atualizar Vertices").setParameter(1, book.getNr_pz_vtce_crv_opt())
                    .setParameter(2, book.getIn_vtce_fxo())
                    .setParameter(3, book.getIc_lqdz_ref_vtce()).setParameter(4, book.getIc_lqdz_clcd_vtce())
                    .setParameter(5, book.getCd_dado_mc_ic_lqdz())
                    .setParameter(6, book.getCd_mtdl_cnv_ftr()).setParameter(7, book.getCd_est_vtce_crv())
                    .setParameter(8, book.getNm_vtce_ordn_crid())
                    .setParameter(9, book.getCd_rgr_cric_vtce()).setParameter(10, book.getCd_crv_opt())
                    .setParameter(11, book.getNr_vrs_crv_opt()).setParameter(12, book.getDt_cric_vtce_crv())
                    .setParameter(13, book.getNr_agpt_crv_opt()).setParameter(14, book.getNr_vtce_crv_opt())
                    .executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Transactional
    public CRVS0053 deletarRegistro(int id) {

        CRVS0053 persist = em.find(CRVS0053.class, 1);

        em.remove(persist);

        return persist;
    }

    // books
    // falta validações de tipo que devem ser feitas antes de atribuir os valores
    // para a classe (not numeric)
    public int validaEntrada(CRVS0053 bookOperacao) {

        // remoção da primeira verificação do outro book
        // verificação direta dos pontos de vertice

        int resultado = 0;

        if(bookOperacao.getCd_crv_opt() == 0){
            resultado = 602;
            System.err.println("Código da curva não pode ser igual a zero.");
            return resultado;
        }
        if(bookOperacao.getNr_vrs_crv_opt() == 0){
            resultado = 604;
            System.err.println("Numero de versão da curva não pode ser igual a zero");
            return resultado;
        }
        if(bookOperacao.getDt_cric_vtce_crv() == null || bookOperacao.getDt_cric_vtce_crv().toString().isBlank()){
            resultado = 605;
            System.err.println("Data da geração dos vértices não informada.");
            return resultado;
        }
        //TODO: KS053-QT-VTCE GREATER 250 QUANTIDADE DE VERTICES DEVE SER VERIFICADA - ERROR 607 E 608  
        if (bookOperacao.getNr_vtce_crv_opt() == 0) {
            resultado = 610;
            System.err.println("Numero do vértice não pode ser igual a zero.");
            return resultado;
        }
        if (bookOperacao.getIn_vtce_fxo() == null || bookOperacao.getIn_vtce_fxo().isBlank()) {
            resultado = 614;
            System.err.println("Indicador de vértice fixo não informado.");
            return resultado;
        }
        if (bookOperacao.getIn_vtce_fxo().compareTo("S") != 0 && bookOperacao.getIn_vtce_fxo().compareTo("N") != 0) {
            resultado = 615;
            System.err.println("Indicador de vértice fixo deve ser igual a S ou N.");
            return resultado;
        }
        if (bookOperacao.getCd_mtdl_cnv_ftr() == 0) {
            resultado = 619;
            System.err.println("Código da metodologia de conversão entre fator e taxa não pode ser igual a zero");
            return resultado;
        }
        if (bookOperacao.getCd_est_vtce_crv() < 1 || bookOperacao.getCd_est_vtce_crv() > 7) {
            resultado = 621;
            System.err.println("Código do estado do vértice deve ser informado entre 1 e 7.");
            return resultado;
        }
        if (bookOperacao.getCd_rgr_cric_vtce() == 0) {
            resultado = 623;
            System.err.println("Código da regra de criação do vértice não pode ser igual a zero.");
            return resultado;
        }
        //TODO: Código de usuario não informado - Error 624

        return resultado;

    }

}

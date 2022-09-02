package br.com.bb.crv.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="CRVS0053", schema="DB2CRV")
@NamedNativeQueries({
    @NamedNativeQuery(name="CONSULTAR_TABELA", 
        query = "SELECT * from DB2CRV.CRVS0053", resultClass = CRVS0053.class),
    @NamedNativeQuery(
        name  = "Atualizar Vertices",
        query = "UPDATE DB2CRV.CRVS0053 SET nr_pz_vtce_crv_opt = ?, in_vtce_fxo = ?, ic_lqdz_ref_vtce = ?, ic_lqdz_clcd_vtce = ?,cd_dado_mc_ic_lqdz = ? , cd_mtdl_cnv_ftr = ?, cd_est_vtce_crv = ?, nm_vtce_ordn_crid = ?, cd_rgr_cric_vtce = ? WHERE cd_crv_opt = ? AND nr_vrs_crv_opt = ? AND dt_cric_vtce_crv = ? AND nr_agpt_crv_opt = ? AND nr_vtce_crv_opt = ?" , resultClass = CRVS0053.class
    ),
    @NamedNativeQuery(
        name  = "TESTE Atualizar Vertices",
        query = "UPDATE DB2CRV.CRVS0053 SET NR_PZ_VTCE_CRV_OPT = ? WHERE CD_CRV_OPT = ?" , resultClass = CRVS0053.class
    )
}) 
public class CRVS0053 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cd_instancia; 
    private int nr_vtce_crv_opt; 

    private LocalDate dt_cric_vtce_crv; 

    private int cd_crv_opt; 

    private int nr_vrs_crv_opt; 

    private int nr_agpt_crv_opt; 

    private int nr_pz_vtce_crv_opt; 

    private int nr_pz_dd_crrd_vtce; 

    private int nr_pz_dd_crrd_util; 

    private String in_vtce_fxo; 

    private BigDecimal ic_lqdz_ref_vtce; 

    private BigDecimal ic_lqdz_clcd_vtce; 

    private String cd_dado_mc_ic_lqdz; 

    private int cd_mtdl_cnv_ftr; 

    private int cd_est_vtce_crv; 

    private String nm_vtce_ordn_crid; 

    private int cd_rgr_cric_vtce;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "CRVS0053 [cd_crv_opt=" + cd_crv_opt + ", cd_dado_mc_ic_lqdz=" + cd_dado_mc_ic_lqdz
                + ", cd_est_vtce_crv=" + cd_est_vtce_crv + ", cd_instancia=" + cd_instancia + ", cd_mtdl_cnv_ftr="
                + cd_mtdl_cnv_ftr + ", cd_rgr_cric_vtce=" + cd_rgr_cric_vtce + ", dt_cric_vtce_crv=" + dt_cric_vtce_crv
                + ", ic_lqdz_clcd_vtce=" + ic_lqdz_clcd_vtce + ", ic_lqdz_ref_vtce=" + ic_lqdz_ref_vtce
                + ", in_vtce_fxo=" + in_vtce_fxo + ", nm_vtce_ordn_crid=" + nm_vtce_ordn_crid + ", nr_agpt_crv_opt="
                + nr_agpt_crv_opt + ", nr_pz_dd_crrd_util=" + nr_pz_dd_crrd_util + ", nr_pz_dd_crrd_vtce="
                + nr_pz_dd_crrd_vtce + ", nr_pz_vtce_crv_opt=" + nr_pz_vtce_crv_opt + ", nr_vrs_crv_opt="
                + nr_vrs_crv_opt + ", nr_vtce_crv_opt=" + nr_vtce_crv_opt + "]";
    }

 

   
    
    public CRVS0053() {
    }

    public CRVS0053(int nr_vtce_crv_opt, LocalDate dt_cric_vtce_crv, int cd_crv_opt, int nr_vrs_crv_opt,
            int nr_agpt_crv_opt, int nr_pz_vtce_crv_opt, int nr_pz_dd_crrd_vtce, int nr_pz_dd_crrd_util,
            String in_vtce_fxo, BigDecimal ic_lqdz_ref_vtce, BigDecimal ic_lqdz_clcd_vtce, String cd_dado_mc_ic_lqdz,
            int cd_mtdl_cnv_ftr, int cd_est_vtce_crv, String nm_vtce_ordn_crid, int cd_rgr_cric_vtce) {
        this.nr_vtce_crv_opt = nr_vtce_crv_opt;
        this.dt_cric_vtce_crv = dt_cric_vtce_crv;
        this.cd_crv_opt = cd_crv_opt;
        this.nr_vrs_crv_opt = nr_vrs_crv_opt;
        this.nr_agpt_crv_opt = nr_agpt_crv_opt;
        this.nr_pz_vtce_crv_opt = nr_pz_vtce_crv_opt;
        this.nr_pz_dd_crrd_vtce = nr_pz_dd_crrd_vtce;
        this.nr_pz_dd_crrd_util = nr_pz_dd_crrd_util;
        this.in_vtce_fxo = in_vtce_fxo;
        this.ic_lqdz_ref_vtce = ic_lqdz_ref_vtce;
        this.ic_lqdz_clcd_vtce = ic_lqdz_clcd_vtce;
        this.cd_dado_mc_ic_lqdz = cd_dado_mc_ic_lqdz;
        this.cd_mtdl_cnv_ftr = cd_mtdl_cnv_ftr;
        this.cd_est_vtce_crv = cd_est_vtce_crv;
        this.nm_vtce_ordn_crid = nm_vtce_ordn_crid;
        this.cd_rgr_cric_vtce = cd_rgr_cric_vtce;
    }
    public CRVS0053(CRVS0053 book) {
        this.nr_vtce_crv_opt = book.getNr_vtce_crv_opt(); 
        this.dt_cric_vtce_crv = book.getDt_cric_vtce_crv();
        this.cd_crv_opt = book.getCd_crv_opt();
        this.nr_vrs_crv_opt = book.getNr_vrs_crv_opt();
        this.nr_agpt_crv_opt = book.getNr_agpt_crv_opt();
        this.nr_pz_vtce_crv_opt = book.getNr_pz_vtce_crv_opt();
        this.nr_pz_dd_crrd_vtce = book.getNr_pz_dd_crrd_vtce();
        this.nr_pz_dd_crrd_util = book.getNr_pz_dd_crrd_util();
        this.in_vtce_fxo = book.getIn_vtce_fxo();
        this.ic_lqdz_ref_vtce = book.getIc_lqdz_ref_vtce();
        this.ic_lqdz_clcd_vtce = book.getIc_lqdz_clcd_vtce();
        this.cd_dado_mc_ic_lqdz = book.getCd_dado_mc_ic_lqdz();
        this.cd_mtdl_cnv_ftr = book.getCd_mtdl_cnv_ftr();
        this.cd_est_vtce_crv = book.getCd_est_vtce_crv();
        this.nm_vtce_ordn_crid = book.getNm_vtce_ordn_crid();
        this.cd_rgr_cric_vtce = book.getCd_rgr_cric_vtce();
}



    /**
     * @return int return the cd_instancia
     */
    public int getCd_instancia() {
        return cd_instancia;
    }

    /**
     * @param cd_instancia the cd_instancia to set
     */
    public void setCd_instancia(int cd_instancia) {
        this.cd_instancia = cd_instancia;
    }

    /**
     * @return int return the nr_vtce_crv_opt
     */
    public int getNr_vtce_crv_opt() {
        return nr_vtce_crv_opt;
    }

    /**
     * @param nr_vtce_crv_opt the nr_vtce_crv_opt to set
     */
    public void setNr_vtce_crv_opt(int nr_vtce_crv_opt) {
        this.nr_vtce_crv_opt = nr_vtce_crv_opt;
    }

    /**
     * @return LocalDate return the dt_cric_vtce_crv
     */
    public LocalDate getDt_cric_vtce_crv() {
        return dt_cric_vtce_crv;
    }

    /**
     * @param dt_cric_vtce_crv the dt_cric_vtce_crv to set
     */
    public void setDt_cric_vtce_crv(LocalDate dt_cric_vtce_crv) {
        this.dt_cric_vtce_crv = dt_cric_vtce_crv;
    }

    /**
     * @return int return the cd_crv_opt
     */
    public int getCd_crv_opt() {
        return cd_crv_opt;
    }

    /**
     * @param cd_crv_opt the cd_crv_opt to set
     */
    public void setCd_crv_opt(int cd_crv_opt) {
        this.cd_crv_opt = cd_crv_opt;
    }

    /**
     * @return int return the nr_vrs_crv_opt
     */
    public int getNr_vrs_crv_opt() {
        return nr_vrs_crv_opt;
    }

    /**
     * @param nr_vrs_crv_opt the nr_vrs_crv_opt to set
     */
    public void setNr_vrs_crv_opt(int nr_vrs_crv_opt) {
        this.nr_vrs_crv_opt = nr_vrs_crv_opt;
    }

    /**
     * @return int return the nr_agpt_crv_opt
     */
    public int getNr_agpt_crv_opt() {
        return nr_agpt_crv_opt;
    }

    /**
     * @param nr_agpt_crv_opt the nr_agpt_crv_opt to set
     */
    public void setNr_agpt_crv_opt(int nr_agpt_crv_opt) {
        this.nr_agpt_crv_opt = nr_agpt_crv_opt;
    }

    /**
     * @return int return the nr_pz_vtce_crv_opt
     */
    public int getNr_pz_vtce_crv_opt() {
        return nr_pz_vtce_crv_opt;
    }

    /**
     * @param nr_pz_vtce_crv_opt the nr_pz_vtce_crv_opt to set
     */
    public void setNr_pz_vtce_crv_opt(int nr_pz_vtce_crv_opt) {
        this.nr_pz_vtce_crv_opt = nr_pz_vtce_crv_opt;
    }

    /**
     * @return int return the nr_pz_dd_crrd_vtce
     */
    public int getNr_pz_dd_crrd_vtce() {
        return nr_pz_dd_crrd_vtce;
    }

    /**
     * @param nr_pz_dd_crrd_vtce the nr_pz_dd_crrd_vtce to set
     */
    public void setNr_pz_dd_crrd_vtce(int nr_pz_dd_crrd_vtce) {
        this.nr_pz_dd_crrd_vtce = nr_pz_dd_crrd_vtce;
    }

    /**
     * @return int return the nr_pz_dd_crrd_util
     */
    public int getNr_pz_dd_crrd_util() {
        return nr_pz_dd_crrd_util;
    }

    /**
     * @param nr_pz_dd_crrd_util the nr_pz_dd_crrd_util to set
     */
    public void setNr_pz_dd_crrd_util(int nr_pz_dd_crrd_util) {
        this.nr_pz_dd_crrd_util = nr_pz_dd_crrd_util;
    }

    /**
     * @return String return the in_vtce_fxo
     */
    public String getIn_vtce_fxo() {
        return in_vtce_fxo;
    }

    /**
     * @param in_vtce_fxo the in_vtce_fxo to set
     */
    public void setIn_vtce_fxo(String in_vtce_fxo) {
        this.in_vtce_fxo = in_vtce_fxo;
    }

    /**
     * @return BigDecimal return the ic_lqdz_ref_vtce
     */
    public BigDecimal getIc_lqdz_ref_vtce() {
        return ic_lqdz_ref_vtce;
    }

    /**
     * @param ic_lqdz_ref_vtce the ic_lqdz_ref_vtce to set
     */
    public void setIc_lqdz_ref_vtce(BigDecimal ic_lqdz_ref_vtce) {
        this.ic_lqdz_ref_vtce = ic_lqdz_ref_vtce;
    }

    /**
     * @return BigDecimal return the ic_lqdz_clcd_vtce
     */
    public BigDecimal getIc_lqdz_clcd_vtce() {
        return ic_lqdz_clcd_vtce;
    }

    /**
     * @param ic_lqdz_clcd_vtce the ic_lqdz_clcd_vtce to set
     */
    public void setIc_lqdz_clcd_vtce(BigDecimal ic_lqdz_clcd_vtce) {
        this.ic_lqdz_clcd_vtce = ic_lqdz_clcd_vtce;
    }

    /**
     * @return String return the cd_dado_mc_ic_lqdz
     */
    public String getCd_dado_mc_ic_lqdz() {
        return cd_dado_mc_ic_lqdz;
    }

    /**
     * @param cd_dado_mc_ic_lqdz the cd_dado_mc_ic_lqdz to set
     */
    public void setCd_dado_mc_ic_lqdz(String cd_dado_mc_ic_lqdz) {
        this.cd_dado_mc_ic_lqdz = cd_dado_mc_ic_lqdz;
    }

    /**
     * @return int return the cd_mtdl_cnv_ftr
     */
    public int getCd_mtdl_cnv_ftr() {
        return cd_mtdl_cnv_ftr;
    }

    /**
     * @param cd_mtdl_cnv_ftr the cd_mtdl_cnv_ftr to set
     */
    public void setCd_mtdl_cnv_ftr(int cd_mtdl_cnv_ftr) {
        this.cd_mtdl_cnv_ftr = cd_mtdl_cnv_ftr;
    }

    /**
     * @return int return the cd_est_vtce_crv
     */
    public int getCd_est_vtce_crv() {
        return cd_est_vtce_crv;
    }

    /**
     * @param cd_est_vtce_crv the cd_est_vtce_crv to set
     */
    public void setCd_est_vtce_crv(int cd_est_vtce_crv) {
        this.cd_est_vtce_crv = cd_est_vtce_crv;
    }

    /**
     * @return String return the nm_vtce_ordn_crid
     */
    public String getNm_vtce_ordn_crid() {
        return nm_vtce_ordn_crid;
    }

    /**
     * @param nm_vtce_ordn_crid the nm_vtce_ordn_crid to set
     */
    public void setNm_vtce_ordn_crid(String nm_vtce_ordn_crid) {
        this.nm_vtce_ordn_crid = nm_vtce_ordn_crid;
    }

    /**
     * @return int return the cd_rgr_cric_vtce
     */
    public int getCd_rgr_cric_vtce() {
        return cd_rgr_cric_vtce;
    }

    /**
     * @param cd_rgr_cric_vtce the cd_rgr_cric_vtce to set
     */
    public void setCd_rgr_cric_vtce(int cd_rgr_cric_vtce) {
        this.cd_rgr_cric_vtce = cd_rgr_cric_vtce;
    }

}

--CREATE SCHEMA IF NOT EXISTS DB2CRV AUTHORIZATION sa;
CREATE SCHEMA IF NOT EXISTS DB2CRV AUTHORIZATION sa;

--CREATE TABLE IF NOT EXISTS DB2CRV.USUARIOS (
--   id INT NOT NULL,
--   nome VARCHAR(100) NOT NULL,
--   nascimento DATE,
--   PRIMARY KEY (id)
--);
CREATE TABLE IF NOT EXISTS DB2CRV.PRM_CTL_PRCT (
	CD_PRM_CTL_PRCT SMALLINT NOT NULL,
	TX_PRM_CTL_PRCT CHAR(100) NOT NULL,
	NM_PRM_CTL_PRCT CHAR(8) NOT NULL,
	DT_PRM_CTL_PRCT DATE,
	VL_PRM_CTL_PRCT DECIMAL(17,2),
	HR_PRM_CTL_PRCT TIME,
	NR_PRM_CTL_PRCT INTEGER,
	CD_USU CHAR(8),
	CD_PGM CHAR(8),
	CONSTRAINT PRM_CTL_PRCT_PK PRIMARY KEY (CD_PRM_CTL_PRCT)
);
CREATE UNIQUE INDEX IF NOT EXISTS DB2CRV.ICRV035A ON DB2CRV.PRM_CTL_PRCT (CD_PRM_CTL_PRCT);


CREATE TABLE IF NOT EXISTS DB2CRV.CRVS0053(
   cd_instancia        INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   nr_vtce_crv_opt                INTEGER NOT NULL,
   dt_cric_vtce_crv               DATE NOT NULL,
   cd_crv_opt                     INTEGER NOT NULL,
   nr_vrs_crv_opt                 INTEGER NOT NULL,
   nr_agpt_crv_opt                INTEGER NOT NULL,
   nr_pz_vtce_crv_opt             INTEGER NOT NULL,
   nr_pz_dd_crrd_vtce             INTEGER NOT NULL,
   nr_pz_dd_crrd_util             INTEGER NOT NULL,
   in_vtce_fxo                    VARCHAR(1) NOT NULL,
   ic_lqdz_ref_vtce               DECIMAL(12,8) NOT NULL ,
   ic_lqdz_clcd_vtce              DECIMAL(12,8) NOT NULL ,
   cd_dado_mc_ic_lqdz             VARCHAR(20) NOT NULL,
   cd_mtdl_cnv_ftr                INTEGER NOT NULL,
   cd_est_vtce_crv                INTEGER NOT NULL,
   nm_vtce_ordn_crid              VARCHAR(100) NOT NULL,
   cd_rgr_cric_vtce               INTEGER NOT NULL,
   PRIMARY KEY (cd_instancia)
);

--DELETE DB2CRV.usuarios;
DELETE FROM DB2CRV.PRM_CTL_PRCT;

--INSERT INTO DB2CRV.USUARIOS (ID, NOME, NASCIMENTO) VALUES (1, 'Huguinho' , CURRENT_DATE());
--INSERT INTO DB2CRV.USUARIOS (ID, NOME, NASCIMENTO) VALUES (2, 'Zezinho' , CURRENT_DATE());
--INSERT INTO DB2CRV.USUARIOS (ID, NOME, NASCIMENTO) VALUES (3, 'Luizinho', CURRENT_DATE());
INSERT INTO DB2CRV.PRM_CTL_PRCT
(CD_PRM_CTL_PRCT, TX_PRM_CTL_PRCT, NM_PRM_CTL_PRCT, DT_PRM_CTL_PRCT, VL_PRM_CTL_PRCT, HR_PRM_CTL_PRCT, NR_PRM_CTL_PRCT, CD_USU, CD_PGM)
VALUES(1, 'STARTUP ABERTURA PREVIA 1', 'SA', '2022-08-15', 2, '06:31:30', 1, 'SISTEMA', 'STARTUP');


INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(01, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(02, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(03, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(04, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(05, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(06, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(07, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(08, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(09, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(10, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
INSERT INTO DB2CRV.CRVS0053 (nr_vtce_crv_opt, dt_cric_vtce_crv,cd_crv_opt,nr_vrs_crv_opt,nr_agpt_crv_opt,nr_pz_vtce_crv_opt,nr_pz_dd_crrd_vtce,nr_pz_dd_crrd_util,in_vtce_fxo,ic_lqdz_ref_vtce,ic_lqdz_clcd_vtce,cd_dado_mc_ic_lqdz,cd_mtdl_cnv_ftr,cd_est_vtce_crv,nm_vtce_ordn_crid, cd_rgr_cric_vtce)VALUES(11, '2022-05-25', 53, 1,1, 1,1,1, 'S', 10.0000000000, 10.0000000000, 'CD_DADO_MC', 1,1, 'NM_VTCE_ORDN_CRID', 5);
 

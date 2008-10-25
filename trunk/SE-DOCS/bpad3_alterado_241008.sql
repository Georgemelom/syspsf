DROP TABLE IF EXISTS `bpad`.`pacientes`;
CREATE TABLE  `bpad`.`pacientes` (
  `pcCns` int(11) NOT NULL,
  `pcNome` varchar(50) NOT NULL,
  `pcDataNascimento` date NOT NULL,
  `pcSexo` varchar(1) NOT NULL,
  `pcEndereco` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pcCns`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `bpad`.`profissionalsaude`;
CREATE TABLE  `bpad`.`profissionalsaude` (
  `psCns` int(11) NOT NULL,
  `cbo_Cbo` varchar(6) NOT NULL,
  `conselhos_Conselho` varchar(10) NOT NULL,
  `unidadeSaude_usCnes` varchar(6) NOT NULL,
  `psNome` varchar(50) NOT NULL,
  `psCpf` varchar(12) NOT NULL,
  `psTelefone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`psCns`),
  KEY `ProfissionaisSaude_FKIndex1` (`unidadeSaude_usCnes`),
  KEY `ProfissionaisSaude_FKIndex2` (`conselhos_Conselho`),
  KEY `ProfissionaisSaude_FKIndex3` (`cbo_Cbo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `bpad`.`unidadesaude`;
CREATE TABLE  `bpad`.`unidadesaude` (
  `usCNES` varchar(6) NOT NULL,
  `Cidade_ciSigla` varchar(6) NOT NULL,
  `usNome` varchar(100) NOT NULL,
  `usSigla` varchar(20) DEFAULT NULL,
  `usRazaoSocial` varchar(100) DEFAULT NULL,
  `usCNPJ` varchar(14) DEFAULT NULL,
  `usEndereco` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`usCNES`),
  KEY `UnidadeSaude_FKIndex1` (`Cidade_ciSigla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


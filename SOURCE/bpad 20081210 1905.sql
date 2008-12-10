-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.28-rc-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bpad
--

CREATE DATABASE IF NOT EXISTS bpad;
USE bpad;

--
-- Definition of table `cbo`
--

DROP TABLE IF EXISTS `cbo`;
CREATE TABLE `cbo` (
  `CBO` varchar(6) NOT NULL,
  `Descricao` varchar(100) NOT NULL,
  PRIMARY KEY (`CBO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cbo`
--

/*!40000 ALTER TABLE `cbo` DISABLE KEYS */;
/*!40000 ALTER TABLE `cbo` ENABLE KEYS */;


--
-- Definition of table `cid`
--

DROP TABLE IF EXISTS `cid`;
CREATE TABLE `cid` (
  `CID` varchar(5) NOT NULL,
  `Descricao` varchar(50) NOT NULL,
  `OPS` varchar(1) DEFAULT NULL,
  `Categoria` varchar(1) DEFAULT NULL,
  `SubCategoria` varchar(1) DEFAULT NULL,
  `RestricaoSexo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cid`
--

/*!40000 ALTER TABLE `cid` DISABLE KEYS */;
/*!40000 ALTER TABLE `cid` ENABLE KEYS */;


--
-- Definition of table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
CREATE TABLE `cidade` (
  `ciSigla` varchar(6) NOT NULL,
  `Estado_esSigla` varchar(2) NOT NULL,
  `ciNome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ciSigla`),
  KEY `Municipios_FKIndex1` (`Estado_esSigla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cidade`
--

/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;


--
-- Definition of table `conselhos`
--

DROP TABLE IF EXISTS `conselhos`;
CREATE TABLE `conselhos` (
  `Conselho` varchar(10) NOT NULL,
  `Descricao` varchar(70) NOT NULL,
  PRIMARY KEY (`Conselho`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `conselhos`
--

/*!40000 ALTER TABLE `conselhos` DISABLE KEYS */;
/*!40000 ALTER TABLE `conselhos` ENABLE KEYS */;


--
-- Definition of table `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE `estado` (
  `esSigla` varchar(2) NOT NULL,
  `esNome` varchar(60) NOT NULL,
  PRIMARY KEY (`esSigla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estado`
--

/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;


--
-- Definition of table `fichadiaria`
--

DROP TABLE IF EXISTS `fichadiaria`;
CREATE TABLE `fichadiaria` (
  `fdID` varchar(5) NOT NULL DEFAULT '',
  `procedimentos_proCodigo` varchar(5) NOT NULL,
  `pacientes_pcCns` varchar(6) NOT NULL,
  `profissionalSaude_psCns` varchar(6) NOT NULL,
  `fdDtProducao` date NOT NULL,
  PRIMARY KEY (`fdID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fichadiaria`
--

/*!40000 ALTER TABLE `fichadiaria` DISABLE KEYS */;
INSERT INTO `fichadiaria` (`fdID`,`procedimentos_proCodigo`,`pacientes_pcCns`,`profissionalSaude_psCns`,`fdDtProducao`) VALUES 
 ('1','0023 ','001234','001 ','2008-02-02'),
 ('10','002 ','001 ','001 ','2008-12-05'),
 ('2','001  ','001   ','00122 ','2008-02-02'),
 ('3','001','001','001','2008-12-04'),
 ('4','0035','001   ','004   ','2008-12-06');
/*!40000 ALTER TABLE `fichadiaria` ENABLE KEYS */;


--
-- Definition of table `folha`
--

DROP TABLE IF EXISTS `folha`;
CREATE TABLE `folha` (
  `foID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `foData` date NOT NULL,
  PRIMARY KEY (`foID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `folha`
--

/*!40000 ALTER TABLE `folha` DISABLE KEYS */;
/*!40000 ALTER TABLE `folha` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `idLogin` varchar(15) NOT NULL DEFAULT '',
  `ProfissionaisSaude_psCns` varchar(5) NOT NULL,
  `senha` varchar(15) NOT NULL,
  PRIMARY KEY (`idLogin`),
  KEY `Login_FKIndex1` (`ProfissionaisSaude_psCns`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`idLogin`,`ProfissionaisSaude_psCns`,`senha`) VALUES 
 ('001','adm','123');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Definition of table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE `pacientes` (
  `pcCns` varchar(6) NOT NULL DEFAULT '',
  `pcNome` varchar(50) NOT NULL,
  `pcDataNascimento` date NOT NULL,
  `pcSexo` varchar(1) NOT NULL,
  `pcEndereco` varchar(100) NOT NULL,
  PRIMARY KEY (`pcCns`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pacientes`
--

/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` (`pcCns`,`pcNome`,`pcDataNascimento`,`pcSexo`,`pcEndereco`) VALUES 
 ('1','klkjlkjlk','2008-01-01','2','dasdasd  '),
 ('117652','ghfhgsdkajhg','2002-01-01','1','kskjdhfkjshdkjh '),
 ('11768','ghfhgsdkajhg','2002-01-01','1','aaaaaaaaaaaaa'),
 ('11769','TESTE','2008-01-01','1',' rua teste'),
 ('123','teste','2008-01-01','1',' rua teste '),
 ('2','sfdsfd','2008-01-01','1','sdsads'),
 ('3','gfhgf','2000-02-02','1',' sdfsdfsdfsd  ');
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;


--
-- Definition of table `procedimentoscbo`
--

DROP TABLE IF EXISTS `procedimentoscbo`;
CREATE TABLE `procedimentoscbo` (
  `Procedimentos_proCodigo` varchar(9) NOT NULL,
  `CBO_CBO` varchar(6) NOT NULL,
  KEY `ProcedimentosCBO_FKIndex1` (`CBO_CBO`),
  KEY `ProcedimentosCBO_FKIndex2` (`Procedimentos_proCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `procedimentoscbo`
--

/*!40000 ALTER TABLE `procedimentoscbo` DISABLE KEYS */;
/*!40000 ALTER TABLE `procedimentoscbo` ENABLE KEYS */;


--
-- Definition of table `profissionalsaude`
--

DROP TABLE IF EXISTS `profissionalsaude`;
CREATE TABLE `profissionalsaude` (
  `psCns` varchar(6) NOT NULL DEFAULT '',
  `cbo_Cbo` varchar(6) NOT NULL,
  `conselhos_Conselho` varchar(10) NOT NULL,
  `unidadeSaude_usCnes` varchar(6) NOT NULL,
  `psNome` varchar(50) NOT NULL,
  `psCpf` varchar(12) DEFAULT NULL,
  `psTelefone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`psCns`),
  KEY `ProfissionaisSaude_FKIndex1` (`unidadeSaude_usCnes`),
  KEY `ProfissionaisSaude_FKIndex2` (`conselhos_Conselho`),
  KEY `ProfissionaisSaude_FKIndex3` (`cbo_Cbo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profissionalsaude`
--

/*!40000 ALTER TABLE `profissionalsaude` DISABLE KEYS */;
INSERT INTO `profissionalsaude` (`psCns`,`cbo_Cbo`,`conselhos_Conselho`,`unidadeSaude_usCnes`,`psNome`,`psCpf`,`psTelefone`) VALUES 
 ('1','ads','adsa','dsa','dsa',NULL,'dsa'),
 ('123','sad','adsads','adsa','dsfd',NULL,'sfds'),
 ('2','dfs','fdsfd','sfdsf','sfds','fds','fds');
/*!40000 ALTER TABLE `profissionalsaude` ENABLE KEYS */;


--
-- Definition of table `unidadesaude`
--

DROP TABLE IF EXISTS `unidadesaude`;
CREATE TABLE `unidadesaude` (
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

--
-- Dumping data for table `unidadesaude`
--

/*!40000 ALTER TABLE `unidadesaude` DISABLE KEYS */;
INSERT INTO `unidadesaude` (`usCNES`,`Cidade_ciSigla`,`usNome`,`usSigla`,`usRazaoSocial`,`usCNPJ`,`usEndereco`) VALUES 
 ('1','ds','FDG ','FDGF ','DGFD ','GFDGF ','GFD SJHGJHAGJHG'),
 ('123','PSF','PSF    ',' teste ','alterdo ','123 ',' alterado   '),
 ('1231','ST','TEST','TEST',NULL,'TEST','TES'),
 ('12312','hjhij','hkjhkj','hgjhg',NULL,'jhgjhg','jbjhb'),
 ('1232','teste','test','test',NULL,'test','tes'),
 ('1233','test','test','test',NULL,'test','tes'),
 ('1234','JPA','UNIDADE DE SAUDE DO VALENTINA','PSFVF',NULL,'123456','RUA TAL'),
 ('12345','str','unidade santa rita','psfsr',NULL,'123','ressdd'),
 ('123451','jhkjhk','khkjh','khkjh',NULL,'kjhkjh','kjhkj'),
 ('123456','TESTE','TEST','TEST',NULL,'TEST','TEST'),
 ('154','JPA','teste de cadastro','hgjhdgj','hgjhsgdjfhsrjukjshkdjhk','5416524635','HSGDJHGSJHDFGJSHD'),
 ('2','JPA','Pedro ','pj ',NULL,'9090909 ','av. '),
 ('3','dsfd','fdsfd ','sfds ','dfds ','fdsf ','fdsggfdgfdgfdgfdgfd'),
 ('4','fdg','fdgf','dgf','dg','dgf','fd'),
 ('5','sfd','sfd  ','sf  ','dsf  ','dsf  ','dssjdfkjskf fsdf'),
 ('6','jhgjh','hgjhg','jhgjhg','jhgjhg','435436546','jhgjhgjhg'),
 ('7687','JPA',' tefstfhgevs',' fhgsjhg','shfggjh','768768716','gugsdjfgjs'),
 ('999','tste','teste','test',NULL,'ttstes','trtfdcgfcg');
/*!40000 ALTER TABLE `unidadesaude` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

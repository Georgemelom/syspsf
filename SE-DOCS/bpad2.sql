CREATE DATABASE bpad;

use bpad;

CREATE TABLE CBO (
  CBO VARCHAR(6) NOT NULL,
  Descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY(CBO)
);

CREATE TABLE CID (
  CID VARCHAR(5) NOT NULL,
  Descricao VARCHAR(50) NOT NULL,
  OPS VARCHAR(1) NULL,
  Categoria VARCHAR(1) NULL,
  SubCategoria VARCHAR(1) NULL,
  RestricaoSexo VARCHAR(1) NULL,
  PRIMARY KEY(CID)
);

CREATE TABLE Cidade (
  ciSigla VARCHAR(6) NOT NULL,
  Estado_esSigla VARCHAR(2) NOT NULL,
  ciNome VARCHAR(100) NULL,
  PRIMARY KEY(ciSigla),
  INDEX Municipios_FKIndex1(Estado_esSigla)
);

CREATE TABLE Conselhos (
  Conselho VARCHAR(10) NOT NULL,
  Descricao VARCHAR(70) NOT NULL,
  PRIMARY KEY(Conselho)
);

CREATE TABLE Estado (
  esSigla VARCHAR(2) NOT NULL,
  esNome VARCHAR(60) NOT NULL,
  PRIMARY KEY(esSigla)
);

CREATE TABLE FichaDiaria (
  fdID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Folha_foID INTEGER UNSIGNED NOT NULL,
  CID_CID VARCHAR(5) NOT NULL,
  Pacientes_pcCNS VARCHAR(15) NOT NULL,
  ProfissionaisSaude_psCodigo VARCHAR(5) NOT NULL,
  PRIMARY KEY(fdID),
  INDEX FichaDiaria_FKIndex1(ProfissionaisSaude_psCodigo),
  INDEX FichaDiaria_FKIndex2(Pacientes_pcCNS),
  INDEX FichaDiaria_FKIndex3(CID_CID),
  INDEX FichaDiaria_FKIndex4(Folha_foID)
);

CREATE TABLE Folha (
  foID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  foData DATE NOT NULL,
  PRIMARY KEY(foID)
);

CREATE TABLE Login (
  idLogin VARCHAR(15) NOT NULL,
  ProfissionaisSaude_psCodigo VARCHAR(5) NOT NULL,
  senha VARCHAR(15) NOT NULL,
  PRIMARY KEY(idLogin),
  INDEX Login_FKIndex1(ProfissionaisSaude_psCodigo)
);

CREATE TABLE Pacientes (
  pcCNS VARCHAR(15) NOT NULL,
  pcNome VARCHAR(50) NOT NULL,
  pcDataNascimento DATE NOT NULL,
  pcSexo VARCHAR(1) NOT NULL,
  pcEndereco VARCHAR(100) NULL,
  PRIMARY KEY(pcCNS)
);

CREATE TABLE Procedimentos (
  proCodigo VARCHAR(9) NOT NULL,
  proDigito VARCHAR(1) NOT NULL,
  proDescricao VARCHAR(60) NOT NULL,
  proSexo VARCHAR(1) NOT NULL,
  PRIMARY KEY(proCodigo)
);

CREATE TABLE ProcedimentosCBO (
  Procedimentos_proCodigo VARCHAR(9) NOT NULL,
  CBO_CBO VARCHAR(6) NOT NULL,
  INDEX ProcedimentosCBO_FKIndex1(CBO_CBO),
  INDEX ProcedimentosCBO_FKIndex2(Procedimentos_proCodigo)
);

CREATE TABLE ProfissionaisSaude (
  psCodigo VARCHAR(5) NOT NULL,
  CBO_CBO VARCHAR(6) NOT NULL,
  Conselhos_Conselho VARCHAR(10) NOT NULL,
  UnidadeSaude_usCNES VARCHAR(6) NOT NULL,
  psNome VARCHAR(50) NOT NULL,
  psCPF VARCHAR(12) NOT NULL,
  psTelefone VARCHAR(15) NULL,
  PRIMARY KEY(psCodigo),
  INDEX ProfissionaisSaude_FKIndex1(UnidadeSaude_usCNES),
  INDEX ProfissionaisSaude_FKIndex2(Conselhos_Conselho),
  INDEX ProfissionaisSaude_FKIndex3(CBO_CBO)
);

CREATE TABLE UnidadeSaude (
  usCNES VARCHAR(6) NOT NULL,
  Cidade_ciSigla VARCHAR(6) NOT NULL,
  usNome VARCHAR(100) NOT NULL,
  usSigla VARCHAR(20) NULL,
  usRazaoSocial VARCHAR(100) NULL,
  usCNPJ VARCHAR(14) NULL,
  usEndereco VARCHAR(100) NULL,
  PRIMARY KEY(usCNES),
  INDEX UnidadeSaude_FKIndex1(Cidade_ciSigla)
);



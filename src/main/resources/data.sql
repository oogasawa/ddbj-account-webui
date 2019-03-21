

CREATE TABLE IF NOT EXISTS accounts (
    accountName     VARCHAR(255) PRIMARY KEY,
    password        VARCHAR(255),
    enabled         BOOLEAN,
);


create table if not exists authorities (
   accountName VARCHAR(255),
   authority   VARCHAR(255),
   foreign key (accountName) references accounts(accountName)
);


create table if not exists account_attributes (
  accountName     VARCHAR(255) PRIMARY KEY,
  kanjiFamilyName VARCHAR(255),
  kanjiFirstName  VARCHAR(255),
  romanFamilyName VARCHAR(255),
  romanFirstName  VARCHAR(255),
  email           VARCHAR(255),
  purposeOfUse    VARCHAR(2048),
  userNationality VARCHAR(255),
  userAffiliation VARCHAR(1024),
  userLabName     VARCHAR(1024),
  userPostalCode  VARCHAR(16),
  userAddress     VARCHAR(1024),
  userTitle       VARCHAR(255),
  userPhoneNumber VARCHAR(16),
  userExtension   VARCHAR(16),
  respAccountName VARCHAR(255),
  repsGroupName   VARCHAR(255)
);
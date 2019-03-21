package jp.ac.nig.ddbj.account.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.StringJoiner;

@Service
public class H2Dao {
    private static final Logger log = LoggerFactory.getLogger(H2Dao.class);

    JdbcTemplate jdbcTemplate;

    final int BCRYPT_STRENGTH = 4;


    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(BCRYPT_STRENGTH);


    @Autowired
    public H2Dao( JdbcTemplate jdbcTemplate ) {
        //jdbcTemplate.execute(createAccountsTableSql());
        //jdbcTemplate.execute(createAuthoritiesTableSql());
        //jdbcTemplate.execute(createAccountAttributesTableSql());


        // create an admin user.
        jdbcTemplate.update("MERGE INTO accounts KEY(accountName) VALUES ('admin', ?, TRUE);", passwordEncoder.encode("testddbj"));
        jdbcTemplate.execute("MERGE INTO authorities KEY(accountName) VALUES ('admin', 'ROLE_ADMIN') ");

        // create an example user.
        jdbcTemplate.update("MERGE INTO accounts KEY(accountName) VALUES ('ddbj', ?, TRUE);", passwordEncoder.encode("testddbj"));
        jdbcTemplate.execute("MERGE INTO authorities KEY(accountName) VALUES ('ddbj', 'ROLE_USER') ");

    }



/*
    public String createAccountsTableSql() {
        StringJoiner j = new StringJoiner(" ");
        j.add("create table if not exists");
        j.add("accounts(");
        j.add("accountName     VARCHAR(255) PRIMARY KEY,");
        j.add("password        VARCHAR(255),");
        j.add("enabled         BOOLEAN");
        j.add(");");


        //System.err.println(j.toString());
        return j.toString();
    }


    public String createAuthoritiesTableSql() {
        StringJoiner j = new StringJoiner(" ");
        j.add("create table if not exists");
        j.add("authorities(");
        j.add("accountName VARCHAR(255),");
        j.add("authority   VARCHAR(255),");
        j.add("foreign key (accountName)");
        j.add("references accounts(accountName)");
        j.add(");");

        //System.err.println(j.toString());
        return j.toString();
    }

    public String createAccountAttributesTableSql() {
        StringJoiner j = new StringJoiner(" ");
        j.add("create table if not exists");
        j.add("account_attributes(");
        j.add("accountName     VARCHAR(255) PRIMARY KEY,");
        j.add("kanjiFamilyName VARCHAR(255),");
        j.add("kanjiFirstName  VARCHAR(255),");
        j.add("romanFamilyName VARCHAR(255),");
        j.add("romanFirstName  VARCHAR(255),");
        j.add("email           VARCHAR(255),");
        j.add("purposeOfUse    VARCHAR(2048),");
        j.add("userNationality VARCHAR(255),");
        j.add("userAffiliation VARCHAR(1024),");
        j.add("userLabName     VARCHAR(1024),");
        j.add("userPostalCode  VARCHAR(16),");
        j.add("userAddress     VARCHAR(1024),");
        j.add("userTitle       VARCHAR(255),");
        j.add("userPhoneNumber VARCHAR(16),");
        j.add("userExtension   VARCHAR(16),");
        j.add("respAccountName VARCHAR(255),");
        j.add("repsGroupName   VARCHAR(255)");
        j.add(");");

        //System.err.println(j.toString());
        return j.toString();
    }
*/




    public String insertAccounts(Map<String, String> model) {
        StringJoiner j = new StringJoiner(" ");
        j.add("insert into accounts ");
        j.add("(accountName, enabled)");
        j.add("VALUES");
        j.add("('" + model.get("accountName") + "', FALSE)");
        j.add(";");


        log.debug(j.toString());

        return j.toString();

    }


    public String insertAuthorities(Map<String, String> model) {
        StringJoiner j = new StringJoiner(" ");
        j.add("insert into authorities ");
        j.add("(accountName, authority)");
        j.add("VALUES");
        j.add("(");
        j.add("'" + model.get("accountName") + "',");
        j.add("'ROLE_USER'");
        j.add(");");

        log.debug(j.toString());


        return j.toString();
    }


    public String insertAccountAttributes(Map<String, String> model) {
        StringJoiner j = new StringJoiner(" ");
        j.add("insert into account_attributes ");
        j.add("(");
        j.add("accountName,");
        j.add("kanjiFamilyName,");
        j.add("kanjiFirstName,");
        j.add("romanFamilyName,");
        j.add("romanFirstName,");
        j.add("email,");
        j.add("purposeOfUse,");
        j.add("userNationality,");
        j.add("userAffiliation,");
        j.add("userLabName,");
        j.add("userPostalCode,");
        j.add("userAddress,");
        j.add("userTitle,");
        j.add("userPhoneNumber,");
        j.add("userExtension,");
        j.add("respAccountName,");
        j.add("repsGroupName");
        j.add(")");
        j.add("VALUES");
        j.add("(");
        j.add("'" + model.get("accountName") + "',");
        j.add("'" + model.get("kanjiFamilyName") + "',");
        j.add("'" + model.get("kanjiFirstName") + "',");
        j.add("'" + model.get("romanFamilyName") + "',");
        j.add("'" + model.get("romanFirstName") + "',");
        j.add("'" + model.get("email") + "',");
        j.add("'" + model.get("purposeOfUse") + "',");
        j.add("'" + model.get("userNationality") + "',");
        j.add("'" + model.get("userAffiliation") + "',");
        j.add("'" + model.get("userLabName") + "',");
        j.add("'" + model.get("userPostalCode") + "',");
        j.add("'" + model.get("userAddress") + "',");
        j.add("'" + model.get("userTitle") + "',");
        j.add("'" + model.get("userPhoneNumber") + "',");
        j.add("'" + model.get("userExtension") + "',");
        j.add("'" + model.get("respAccountName") + "',");
        j.add("'" + model.get("respGroupName") + "'");
        j.add(");");

        log.debug(j.toString());


        System.err.println(j.toString());

        return j.toString();
    }








}
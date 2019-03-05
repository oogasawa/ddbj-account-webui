package jp.ac.nig.ddbj.account.controller;

import jp.ac.nig.ddbj.account.dao.H2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class RegistorationController {


    @Autowired
    H2Dao h2Dao;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping("/register")
    public ModelAndView accessRegisterWithGetMethod() {

        Map<String, String> model = new HashMap<String, String>();

        return new ModelAndView("register", model);
    }


    @PostMapping("/register")
    public ModelAndView accessRegisterWithPostMethod(
            @RequestParam("accountName")     String accountName,
            @RequestParam("kanjiFamilyName") String kanjiFamilyName,
            @RequestParam("kanjiFirstName")  String kanjiFirstName,
            @RequestParam("romanFamilyName") String romanFamilyName,
            @RequestParam("romanFirstName")  String romanFirstName,
            @RequestParam("email")           String email,
            @RequestParam("emailRepeat")     String emailRepeat,
            @RequestParam("purposeOfUse")    String purposeOfUse,
            @RequestParam("userNationality") String userNationality,
            @RequestParam("userAffiliation") String userAffiliation,
            @RequestParam("userLabName")     String userLabName,
            @RequestParam("userPostalCode")  String userPostalCode,
            @RequestParam("userAddress")     String userAddress,
            @RequestParam("userPhoneNumber")     String userPhoneNumber,
            @RequestParam("userExtension")       String userExtension,
            @RequestParam("userTitle")       String userTitle,
            @RequestParam("respAccountName") String respAccountName,
            @RequestParam("respGroupName")   String respGroupName,
            @RequestParam("respKanjiFamilyName") String respKanjiFamilyName,
            @RequestParam("respKanjiFirstName")  String respKanjiFirstName,
            @RequestParam("respRomanFamilyName") String respRomanFamilyName,
            @RequestParam("respRomanFirstName")  String respRomanFirstName,
            @RequestParam("respEmail")           String respEmail,
            @RequestParam("respPhoneNumber")     String respPhoneNumber,
            @RequestParam("respExtension")       String respExtension,
            @RequestParam("respNationality") String respNationality,
            @RequestParam("respAffiliation") String respAffiliation,
            @RequestParam("respLabName")     String respLabName,
            @RequestParam("respPostalCode")  String respPostalCode,
            @RequestParam("respAddress")     String respAddress,
            @RequestParam("respTitle")       String respTitle,
            @RequestParam("jgaAccounts")     String jgaAccounts,
            @RequestParam("agdAccounts")     String agdAccounts
            )  {

        Map<String, String> model = new HashMap<String, String>();

        //System.out.println("accountName");

        model.put("accountName", accountName);
        model.put("kanjiFamilyName", kanjiFamilyName);
        model.put("kanjiFirstName", kanjiFirstName);
        model.put("romanFamilyName", romanFamilyName);
        model.put("romanFirstName", romanFirstName);
        model.put("email", email);
        model.put("emailRepeat", emailRepeat);
        model.put("purposeOfUse", purposeOfUse);
        model.put("userNationality", userNationality);
        model.put("userAffiliation", userAffiliation);
        model.put("userLabName", userLabName);
        model.put("userPostalCode", userPostalCode);
        model.put("userAddress", userAddress);
        model.put("userPhoneNumber", userPhoneNumber);
        model.put("userExtension", userExtension);
        model.put("userTitle", userTitle);
        model.put("respAccountName", respAccountName);
        model.put("respGroupName", respGroupName);
        model.put("respKanjiFamilyName", respKanjiFamilyName);
        model.put("respKanjiFirstName", respKanjiFirstName);
        model.put("respRomanFamilyName", respRomanFamilyName);
        model.put("respRomanFirstName", respRomanFirstName);
        model.put("respEmail", respEmail);
        model.put("respPhoneNumber", respPhoneNumber);
        model.put("respExtension", respExtension);
        model.put("respNationality", respNationality);
        model.put("respAffiliation", respAffiliation);
        model.put("respLabName", respLabName);
        model.put("respPostalCode", respPostalCode);
        model.put("respAddress", respAddress);
        model.put("respTitle", respTitle);
        model.put("jgaAccounts", jgaAccounts);
        model.put("agdAccounts", agdAccounts);


        // ToDo: validation processes are needed.

        jdbcTemplate.execute(h2Dao.insertAccounts(model));
        jdbcTemplate.execute(h2Dao.insertAuthorities(model));
        jdbcTemplate.execute(h2Dao.insertAccountAttributes(model));


        return new ModelAndView("conformation", model);
    }



}

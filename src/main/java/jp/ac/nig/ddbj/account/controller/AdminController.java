package jp.ac.nig.ddbj.account.controller;

import jp.ac.nig.ddbj.account.dao.Account;
import jp.ac.nig.ddbj.account.dao.H2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController  {

    //@Autowired
    //H2Dao h2Dao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/admin")
    public ModelAndView showPendingUsserList() {

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("users", findAll());

        return new ModelAndView("admin", model);
    }


    public List<Account> findAll() {
        String sql = "SELECT * FROM accounts";

        List<Account> result = new ArrayList<Account>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows ) {
            Account acc = new Account();
            acc.setAccountName((String)row.get("ACCOUNTNAME"));
            acc.setPassword((String)row.get("PASSWORD"));
            acc.setEnabled((Boolean)row.get("ENABLED"));

            result.add(acc);
        }

        return result;
    }


}

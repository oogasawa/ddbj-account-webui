package jp.ac.nig.ddbj.account.dao;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Account {

    String  accountName;
    String  password;
    Boolean enabled;
}

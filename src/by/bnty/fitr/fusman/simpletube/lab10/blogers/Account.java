package by.bnty.fitr.fusman.simpletube.lab10.blogers;

import by.bnty.fitr.fusman.simpletube.accountstatus.AccountStatus;
import by.bnty.fitr.fusman.simpletube.lab10.playlists.Playlists;

import java.util.ArrayList;

public class Account {
    private String nickname;
    private ArrayList<Playlists> collection;
    private AccountStatus status;

    private Account() {
        collection = new ArrayList<>();
    }

    public Account(String nickname) {
        this();
        this.nickname = nickname;
        status = AccountStatus.Usual;
    }

    public Account(Account account) {
        nickname = account.nickname;
        collection = account.collection;
        status = account.status;
    }

    public void deletePlaylists() {

    }

    public String toString() {
        return "Nick:" + nickname;
    }
}

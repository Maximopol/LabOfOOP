package by.bnty.fitr.fusman.labs.lab10.blogers;

import by.bnty.fitr.fusman.labs.lab10.playlists.Playlists;

import java.util.ArrayList;

public class Account {
    private String nickname;
    private ArrayList<Playlists> collection;

    private Account() {
        collection = new ArrayList<>();
    }

    public Account(String nickname) {
        this();
        this.nickname = nickname;
    }

    public Account(Account account) {
        nickname = account.nickname;
        collection = account.collection;
    }

    public void deletePlaylists() {

    }

    public String toString() {
        return "Nick:" + nickname;
    }
}

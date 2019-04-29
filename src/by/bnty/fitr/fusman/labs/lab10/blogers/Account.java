package by.bnty.fitr.fusman.labs.lab10.blogers;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist.ArrayPlaylists;
import by.bnty.fitr.fusman.simpletube.accountstatus.AccountStatus;

import java.util.Objects;

public class Account {
    private String nickname;
    private ArrayPlaylists arrayPlaylists;
    //  private ArrayList<Playlist> collection;
    private AccountStatus status;

    private Account() {
        arrayPlaylists = new ArrayPlaylists();

    }

    public Account(String nickname) {
        this();
        this.nickname = nickname;
        status = AccountStatus.Usual;
    }

    public Account(Account account) {
        nickname = account.nickname;
        arrayPlaylists = account.arrayPlaylists;
        status = account.status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(nickname, account.nickname) &&
                Objects.equals(arrayPlaylists, account.arrayPlaylists) &&
                status == account.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, arrayPlaylists, status);
    }

    public String toString() {
        return "Account{" +
                "nickname='" + nickname + '\'' +
                ", status=" + status +
                //  ", collection=" + collection +
                '}';
    }
}

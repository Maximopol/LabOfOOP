package by.bnty.fitr.fusman.labs.lab10.blogers;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist.ArrayPlaylists;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;
import by.bnty.fitr.fusman.simpletube.common.accountstatus.AccountStatus;

import java.util.Objects;

public class Account {
    private String email;
    private String nickname;
    private Playlists playlists;
    private AccountStatus status;

    private Account() {
        playlists = new ArrayPlaylists();
    }

    public Account(String nickname, String email) {
        this();
        this.nickname = nickname;
        status = AccountStatus.Usual;
        this.email = email;
    }

    public Account(Account account) {
        nickname = account.nickname;
        playlists = account.playlists;
        status = account.status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(email, account.email) &&
                Objects.equals(nickname, account.nickname) &&
                Objects.equals(playlists, account.playlists) &&
                status == account.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, nickname, playlists, status);
    }

    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", playlists=" + playlists +
                ", status=" + status +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public Playlists getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlists playlists) {
        this.playlists = playlists;
    }

    public AccountStatus getStatus() {
        return status;
    }
}

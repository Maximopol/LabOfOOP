package by.bnty.fitr.fusman.labs.lab10.blogers;

import by.bnty.fitr.fusman.simpletube.accountstatus.AccountStatus;

public class Account {
    private String nickname;
    //  private ArrayList<Playlist> collection;
    private AccountStatus status;

    private Account() {
        //collection = new ArrayList<>();
    }

    public Account(String nickname) {
        this();
        this.nickname = nickname;
        status = AccountStatus.Usual;
    }

    public Account(Account account) {
        nickname = account.nickname;
        // collection = account.collection;
        status = account.status;
    }

    public String toString() {
        return "Account{" +
                "nickname='" + nickname + '\'' +
                ", status=" + status +
                //  ", collection=" + collection +
                '}';
    }
}

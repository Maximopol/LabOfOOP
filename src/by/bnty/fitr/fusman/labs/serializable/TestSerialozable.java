package by.bnty.fitr.fusman.labs.serializable;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist.ArrayPlaylists;
import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.ArrayVideo;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;
import by.bnty.fitr.fusman.labs.lab10.blogers.Account;
import by.bnty.fitr.fusman.labs.lab10.video.Video;

import java.io.*;

import static Printer.Printer.println;

public class TestSerialozable {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("F:\\4\\OOP\\oop\\src\\by\\bnty\\fitr\\fusman\\labs\\serializable\\temp.bin");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Playlist st = new ArrayVideo("pupsik");
            st.add(new Video());
            st.add(new Video("POPKA"));
            Playlists playlists = new ArrayPlaylists();
            playlists.add(st);
            Account account = new Account();
            account.setPlaylists(playlists);

            oos.writeObject(account);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("F:\\4\\OOP\\oop\\src\\by\\bnty\\fitr\\fusman\\labs\\serializable\\temp.bin");
            ObjectInputStream oin = new ObjectInputStream(fis);
            Account ts = (Account) oin.readObject();
            println(ts);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

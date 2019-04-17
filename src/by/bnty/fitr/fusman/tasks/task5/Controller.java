package by.bnty.fitr.fusman.tasks.task5;

//Опишите полную UML-диаграмму классов взаимодействия классов и объекта следующей программной системы:Звукозапись
//Записать на диск сборку музыки различных жанорв
//Подсчитать продолжительность всего диска и найти самую кототкую песню

public class Controller {
    public static int countAllDuration(Disk disk) {
        int count = 0;
        for (int i = 0; i < disk.getCount(); i++) {
            count += disk.getMusic(i).getDuration();
        }
        return count;
    }

    public static String searchShortSongInDisk(Disk disk) {
        int minIndex = 0;
        for (int i = 0; i < disk.getCount(); i++) {
            if (disk.getMusic(minIndex).getDuration() > disk.getMusic(i).getDuration()) {
                minIndex = i;
            }
        }


        return disk.getMusic(minIndex) == null ? null : disk.getMusic(minIndex).toString();
    }

    public static String searchName(Disk disk, String name) {
        for (int i = 0; i < disk.getCount(); i++) {
            if (name.equals(disk.getMusic(i).getName())) {
                return disk.getMusic(i).toString();
            }
        }
        return null;
    }
}

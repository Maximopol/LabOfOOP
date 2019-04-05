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
        // return "This song has min duration\nHis position in the disk is" + minIndex + "\n" + disk.getMusic(minIndex);

        return disk.getMusic(minIndex) == null ? null : disk.getMusic(minIndex).toString();
    }
}

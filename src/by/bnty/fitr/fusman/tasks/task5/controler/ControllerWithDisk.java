package by.bnty.fitr.fusman.tasks.task5.controler;

//Опишите полную UML-диаграмму классов взаимодействия классов и объекта следующей программной системы:Звукозапись
//Записать на диск сборку музыки различных жанорв
//Подсчитать продолжительность всего диска и найти самую кототкую песню

import by.bnty.fitr.fusman.labs.lab10.iterator.IIterator;
import by.bnty.fitr.fusman.tasks.task5.Disk;
import by.bnty.fitr.fusman.tasks.task5.Folder;

public class ControllerWithDisk {
    public static int countAllDuration(Disk disk) {
        int count = 0;
        IIterator<Folder> iterator = disk.createIterator();
        while (iterator.hasNext()) {
            count += ControletWithFolder.countAllDuration(iterator.next());

        }
        return count;
    }

}

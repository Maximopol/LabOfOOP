package by.bnty.fitr.fusman;

import by.bnty.fitr.fusman.Printer.Printer;
import by.bnty.fitr.fusman.lab10.video.Video;
import by.bnty.fitr.fusman.lab11.ArrayInitializer;
import by.bnty.fitr.fusman.lab11.WorkerWithArrays;

import java.util.Arrays;


//11
//Необходимо в основное задание предыдущей лабораторной работы придумать и добавить в предметную область класс-сущность,
//который бы состоял из соответствующих бизнес объектов программной системы.
//Данный класс должен содержать соответствующую функциональность, которая обычно присуще любым контейнерным классам:
// разнообразие конструкторов (конструктор по умолчанию, конструкторы с параметрами в том числе конструктор-копирования);
//методы по добавлению элементов, удалению, изменению; методы для перебора бизнес объектов данного контейнерного класса;
// переопределённый метод toString() и т.д.
// Также реализовать для объектов данного контейнерного класса соответствующую бизнес-логику, которая бы осуществляла,
// к примеру, поиск целевых данных и(или) экстремальных значений и т.д.
//12
//Необходимо проанализировать предметную область из предыдущей лабораторной работы и внедрить в неё функционал,
//который бы для своих вычислений использовал бы многомерные массивы.
public class Menu {
    public static void main(String[] args) {

        int[] mas = new int[10];
        ArrayInitializer.rndInit(mas, 10, 100);
        System.out.println(Arrays.toString(mas));

        //lab 11 task 2
        //В векторе, состоящем из n вещественных элементов, вычислить: количество
        //элементов вектора, равных 0 и сумму элементов вектора, расположенных после минимального элемента.
        int[] mas1 = new int[100];
        ArrayInitializer.rndInit(mas1, -100, 100);
        Printer.println(Arrays.toString(mas1));
        Printer.println(WorkerWithArrays.countZeros(mas1));

        Printer.println(WorkerWithArrays.sumElementsAfterMin(mas1, WorkerWithArrays.searchIndexOfMinElement(mas1)));


        Printer.println(new Video().toString());
        //lab 12 task 1

        //lab 12 task 2

//        double[] mas = new double[10];
//        CreaterArrays.init(mas);
//
//
//        System.out.println(Arrays.toString(mas));
//        System.out.println(WorkerWithArrays.searchIndexOfMinElement(mas));

    }
}

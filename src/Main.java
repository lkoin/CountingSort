import java.util.Scanner;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean petla = true;
        while (petla == true) {
            System.out.println("Wybierz opcje: ");
            System.out.println("1. Podanie liczb ręcznie po kolei do tablicy o podanym rozmiarze");
            System.out.println("0. Wyjscie z programu");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("Podaj ilosc liczb zawartych w tablicy: ");
                    int size = scanner.nextInt();
                    System.out.println("Podaj liczbe maksymalna: ");
                    int max = scanner.nextInt();
                    int tablica[] = new int[size];
                    for (int i =0; i<size;i++) {
                        System.out.println("Podaj kolejna liczbe");
                        tablica[i]= readNumber(max);
                    }
                    CountingSort(tablica,max);
                    for (int i=0;i < tablica.length;i++) {

                        System.out.print(tablica[i] + ", ");
                }
                    System.out.println("");
                    break;

                case 0:
                    System.out.println("Wyjscie z programu");
                    petla = false;
                    break;
            }

        }
    }




    public static void  CountingSort(int[] tab,int max) {
        int size = tab.length;
        int[] temp = new int[max+1];
        for (int i=0; i < max+1 ;i++) {
            temp[i]=0;
        }
        for (int i=0;i<size;i++) {
            temp[tab[i]]++;
        }
        int k=0;
        for (int i = 0;i <tab.length;i++) {
            for (int j = temp[i];j>=1;j--) {
                tab[k] = i;
                k++;
            }
        }
    }

    public static int readNumber(int max) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= max) {
            return number;
        }
        else {
            System.out.println("Podana liczba nie znajduje sie w zakresie");
            return readNumber(max);

        }
        }
    }

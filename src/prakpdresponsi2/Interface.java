/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prakpdresponsi2;

import java.util.Scanner;

/**
 *
 * @author STEVEN
 */
public class Interface {

    static Scanner sc = new Scanner(System.in);
    static Scanner b = new Scanner(System.in);
    static LinkedList a = new LinkedList();
    static int pilihan, angka, age;
    static String dokter;
    static String disease;
    static char gender, name;

    public static void main(String[] args) {
        System.out.println("Selamat datang, pelanggan yang terhormat di Klinik Chung Fang ");
        menu();
    }

    static void pilihdokter() {
        int pilih;
        System.out.println("1.dr.Sung Hay Sung --> Dokter Penyakit Dalam ");
        System.out.println("2.dr.Hung Weng Hung --> Dokter Penyakit Dalam");
        System.out.println("3.dr.Hiung Hai Sang --> Dokter Penyakit Luar");
        System.out.println("4.dr.Fei Hung --> Dokter Penyakit Luar");
        System.out.println("5.dr.Tenma Gressy --> Dokter Penyakit Luar");
        System.out.print("Pilih : ");
        pilih = sc.nextInt();
        switch (pilih) {
            case 1:
                dokter = "dr.Sung Hay Sung";
                break;
            case 2:
                dokter = "dr.Hung Weng Hung";
                break;
            case 3:
                dokter = "dr.Hiung Hai Sang";
                break;
            case 4:
                dokter = "dr.Fei Hung";
                break;
            case 5:
                dokter = "dr.Tenma Gressy";
                break;
        }
    }

    static void menu() {
        int pilih;
        System.out.println("-------------MENU--------------");
        System.out.println("1. Ambil Nomor Antrian");
        System.out.println("2. Panggilan");
        System.out.println("3. Menampilkan Nomor Antrian");
        System.out.println("4. Exit");
        System.out.println("-------------------------------");
        System.out.print("Pilih : ");
        pilih = sc.nextInt();
        switch (pilih) {
            case 1:
                input();
            case 2:
                identity();
                pop();
            case 3:
                print();
            case 4:
                exit();

        }
    }

    static void input() {

        do {
            System.out.print("Daftar nomor antrian : ");
            angka = sc.nextInt();
            if (a.find_node_by_data(angka) != null) {
                System.out.println("Angka antrian sudah diambil. Silahkan ganti nomor yang lain");
                System.out.println("Berikut nomor yang sudah diambil : ");
                a.print();
            } else {
                System.out.println("Terima kasih sudah mengambil nomor antrian. Silahkan memilih dokter terlebih dahulu");
                pilihdokter();
            }
        } while (a.find_node_by_data(angka) != null);
        a.push(new LinkedListNode(angka, dokter));
        menu();
    }

    static void pop() {
        a.qpop();
    }

    static void print() {
        a.print();
        menu();
    }

    static void identity() {
        System.out.println("Masukkan identitas anda ");
        System.out.print("Nama :");
        name = b.next().charAt(0);
        System.out.print("Umur :");
        age = b.nextInt();
        System.out.println("Jenis Kelamin(L/P) :");
        System.out.println("1. Pria");
        System.out.println("2. Wanita");
        System.out.print("Pilih :");
        gender = b.next().charAt(0);
        switch (pilihan) {
            case 1:
                gender = 'L';
                break;
            case 2:
                gender = 'P';
                break;
        }
        System.out.print("Penyakit :");
        disease = b.next();
        System.out.println("Terima kasih sudah berobat di klinik kami...Get well soon");
        System.out.println("");
        System.out.println("Antrian selanjutnya : ");
    }

    static void exit() {
        System.exit(0);
    }

}

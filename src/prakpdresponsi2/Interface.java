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
    static LinkedList a = new LinkedList();
    static int pilihan, angka;

    public static void main(String[] args) {
        System.out.println("Selamat datang, pelanggan yang terhormat di Klinik Chung Fang ");
        pilihdokter();
        System.out.println("Terima kasih, Silahkan anda mengambil nomor antrian dahulu");
        menu();
    }

    static void pilihdokter() {
        int pilih;
        System.out.println("Silahkan anda memilih dokter terlebih dahulu");
        System.out.println("1.dr.Sung Hay Sung --> Dokter Penyakit Dalam ");
        System.out.println("2.dr.Hung Weng Hung --> Dokter Penyakit Dalam");
        System.out.println("3.dr.Hiung Hai Sang --> Dokter Penyakit Luar");
        System.out.println("4.dr.Fei Hung --> Dokter Penyakit Luar");
        System.out.println("5.dr.Tenma Gressy --> Dokter Penyakit Luar");
        System.out.print("Pilih : ");
        pilih = sc.nextInt();
        switch (pilih) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                // simpan data dokter yang dipilih
                break;
        }
    }

    static void menu() {
        int pilih;
        System.out.println("--Menu--");
        System.out.println("1. Ambil Nomor Antrian");
        System.out.println("2. Panggilan");
        System.out.println("3. Menampilkan Nomor Antrian");
        System.out.println("4. Exit");
        System.out.print("Pilih : ");
        pilih = sc.nextInt();
        switch (pilih) {
            case 1:
                input();
            case 2:
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
                System.out.println("Terima kasih sudah mengambil nomor antrian. Mohon menunggu");
                pilihdokter();
            }
        } while (a.find_node_by_data(angka) != null);
        a.push(new LinkedListNode(angka));
        menu();
    }

    static void pop() {
        a.qpop();
    }

    static void print() {
        a.print();
        menu();
    }

    static void exit() {
        System.exit(0);
    }

}
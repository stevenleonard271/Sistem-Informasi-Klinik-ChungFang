/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prakpdresponsi2;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author STEVEN
 */
public class Interface {

    static Scanner sc = new Scanner(System.in);
    static Scanner b = new Scanner(System.in);
    static Scanner pas = new Scanner(System.in);
    static LinkedList a = new LinkedList();
    static int pilihan, angka, age;
    static String dokter, disease, name, sql;
    static char gender;
    static int queuelist = 0, numbering = 1, id;
    static Statement stmt;

    public static void main(String[] args) {
        System.out.println("Selamat datang, pelanggan yang terhormat di Klinik Chung Fang ");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /* Run this Sql First
                Create database klinik;
  
                create table klinik.data(
                id int NOT NULL AUTO_INCREMENT,
                nama varchar(200) NOT NULL,
                umur int NOT NULL,
                JK char NOT NULL,
                Penyakit varchar(25) NOT NULL,
                PRIMARY KEY(id)
                );*/

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/klinik", "root", "");
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("error!!");
        }
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
            default:
                System.out.println("Maaf inputan Anda salah, Mohon masukkan angka 1-5 ");
        }
    }

    static void menu() {
        int pilih;
        System.out.println("-------------MENU--------------");
        System.out.println("1. Ambil Nomor Antrian");
        System.out.println("2. Panggilan");
        System.out.println("3. Menampilkan Nomor Antrian");
        System.out.println("4. Data Pasien");
        System.out.println("5. Exit");
        System.out.println("-------------------------------");
        System.out.print("Pilih : ");
        pilih = sc.nextInt();
        switch (pilih) {
            case 1:
                if (queuelist < 5) {
                    input();
                } else {
                    System.out.println("Maaf, batasan antrian sudah penuh.");
                    menu();
                }
                break;
            case 2:
                if (queuelist == 0) {
                    System.out.println("Tidak ada antrian");
                    menu();
                } else {
                    b.nextLine();
                    identity();
                    menu();
                }
                break;
            case 3:
                print();
                break;
            case 4:
                patient();
            case 5:
                exit();
                break;
            default:
                System.out.println("Inputan salah, ulang lagi");
                menu();
        }
    }

    static void input() {
        queuelist++;
        System.out.println("Terima kasih sudah mengambil nomor antrian. Silahkan memilih dokter terlebih dahulu");
        pilihdokter();
        a.push(new LinkedListNode(numbering, dokter));
        numbering++;
        menu();
    }

    static void pop() {
        a.qpop();
        queuelist--;
    }

    static void print() {
        a.print();
        menu();
    }

    static void identity() {
        System.out.println("Masukkan identitas anda ");
        System.out.print("Nama              :");
        name = b.nextLine();
        System.out.print("Umur              :");
        age = b.nextInt();
        System.out.print("Jenis Kelamin(L/P):");
        gender = b.next().charAt(0);
        System.out.print("Penyakit          :");
        disease = b.next();
        System.out.println("Terima kasih, silahkan menuju " + dokter + "...Get well soon");
        System.out.println("");

        //query simpan
        sql = "INSERT INTO data (nama, umur, JK, Penyakit) VALUES ('" + name + "', '" + age + "','" + gender + "', '" + disease + "')";
        System.out.println(sql);
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pop();
        System.out.println("Antrian selanjutnya : ");
        print();
    }

    static void patient() {
        int option;
        int identitas;
        System.out.println("1.Menampilkan semua data pasien");
        System.out.println("2.Ralat data Pasien");
        System.out.println("3.Menghapus beberapa data pasien");
        System.out.print("Pilihan : ");
        option = pas.nextInt();
        if (option == 1) {
            sql = "SELECT * FROM data";
            //System.out.println(sql);
            try {
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" + rs.getString("nama") + "\t" + rs.getInt("umur") + "\t" + rs.getString("JK") + "\t" + rs.getString("Penyakit"));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            menu();
        } else if (option == 2) {
            System.out.println("Masukkan id yang hendak diupdate");
            id = pas.nextInt();
            System.out.println("Masukkan nama yang hendak diupdate");
            name = pas.nextLine();
            sql = "UPDATE data SET nama = '" + name + "' where id='" + id + "'";
            System.out.println(sql);
            try {
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            menu();
        } else if (option == 3) {
            System.out.println("Masukkan id yang hendak dihapus");
            id = pas.nextInt();
            sql = "DELETE FROM data where id = '" + id + "'";
            System.out.println(sql);
            try {
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            menu();
        } else {
            menu();
        }

    }

    static void exit() {
        System.exit(0);
    }

}

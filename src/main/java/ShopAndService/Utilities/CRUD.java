package ShopAndService.Utilities;

import ShopAndService.Application;
import jdk.management.resource.internal.inst.AbstractPlainDatagramSocketImplRMHooks;


import java.sql.*;
import java.util.Scanner;



public class CRUD {
    public static String url = "jdbc:mysql://localhost:3306/carshopandstore";
    public static String userDataBase = "root";
    public static String passDataBase = "root";
    static Scanner scan = new Scanner(System.in);

//-------------------------------------------------------------------------------ADAUGA->

    public static int[] adaugaPiesa() {
        int optiune[] = new int[2];
        System.out.println("Localuser: " + Application.localUser);
        optiune[0] = 3;
        System.out.println("Vrei sa adaugi o piesa ");
        if (Application.localUser == 1 || Application.localUser == 3) {
            System.out.println("Care este numele piesei pe care  vrei sa o adaugi ?");
            String numePiesa = scan.nextLine();
            System.out.println("Furnizorul piesei?");
            String furnizorPiesa = scan.nextLine();
            System.out.println("Cate piese vrei sa introduci in stoc?");
            int stocPiese = scan.nextInt();
            System.out.println("Care este costul per piesa?");
            int costPiesa = scan.nextInt();
            try {
                Connection myConn = DriverManager.getConnection(url, userDataBase, passDataBase);
                Statement st = myConn.createStatement();
                st.execute(String.format("INSERT INTO piesa (Nume, Furnizor, Stoc, Cost) VALUE ('%s', '%s', '%d', '%d')", numePiesa, furnizorPiesa, stocPiese, costPiesa));

                System.out.println("Ai introdus o piesa");

            } catch (SQLException e) {
                System.out.println("Error Adauga Piesa try");
                e.printStackTrace();
            }
        } else {
            System.out.println("Caracteristicile user-ului tau nu iti perminte sa faci aceasta actiune");
            System.out.println("Alege o alta actiune pe care Rolul tau iti permite");
            System.out.println();
        }
        return optiune;
    }

//-----------------------------------------------------------------------STERGE ->

    public static int[] stergePiesa() {

        int[] optiune = new int[2];
        optiune[0] = 3;
        if (Application.localUser == 1 || Application.localUser == 3) {
            System.out.println("Alege piesa pe care vrei sa o stergi:");

            try {
                Connection myConn = DriverManager.getConnection(url, userDataBase, passDataBase);
                Statement st = myConn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM carshopandstore.piesa;");
                System.out.println("Piesele tale:");
                while (rs.next()) {
                    int IDPiesa = rs.getInt("IDPiesa");
                    String Nume = rs.getString("Nume");
                    String furnizor = rs.getString("Furnizor");
                    int Stoc = rs.getInt("Cost");
                    int Cost = rs.getInt("Cost");
                    System.out.println(IDPiesa + " " + Nume + " Furnizor: " + furnizor + " Stoc: " + Stoc + "Cost:" + Cost);
                    System.out.println();
                }

                System.out.println("Alege piesa pe care doresti sa o stergi:");
                int idPiesaStergre = scan.nextInt();

                Statement st2 = myConn.createStatement();
                st2.execute(String.format("DELETE FROM piesa WHERE IDPiesa = '%d'", idPiesaStergre));
                System.out.println("Piesa a fost stearsa!");

                myConn.close();


            } catch (SQLException e) {
                System.out.println("Eroare la stergerea Piesei!");
                e.printStackTrace();
            }
        } else {
            System.out.println("Caracteristicile user-ului tau nu iti perminte sa faci aceasta actiune");
            System.out.println("Alege o alta actiune pe care Rolul tau iti permite");
            System.out.println();
        }
        return optiune;
    }

//---------------------------------------------------------EDITEAZA PIESA

    public static int[] editeazaPiesa() {
        int[] optiune = new int[2];
        optiune[0] = 3;
        if (Application.localUser == 1 || Application.localUser == 2) {
            System.out.println("Alege piesa pe care vrei sa o editezi");
            try {
                Connection myConn = DriverManager.getConnection(url, userDataBase, passDataBase);
                Statement st = myConn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM carshopandstore.piesa;");

                while (rs.next()) {
                    int IDPiesa = rs.getInt("IDPiesa");
                    String Nume = rs.getString("Nume");
                    String furnizor = rs.getString("Furnizor");
                    int Stoc = rs.getInt("Stoc");
                    int Cost = rs.getInt("Cost");
                    System.out.println(IDPiesa + " " + Nume + " Furnizor: " + furnizor + " Stoc: " + Stoc + "Cost:" + Cost);
                    System.out.println();
                }
                System.out.println("Alege piesa pe care doresti sa ao editezi:");
                int idPiesaEditare = scan.nextInt();
                String test = scan.nextLine();

                System.out.println("Numele noii piese:");
                String numeNou = scan.nextLine();
                System.out.println("Furnizor nou:");
                String furnizorNou = scan.nextLine();
                System.out.println("Stoc nou:");
                int stocNou = scan.nextInt();
                System.out.println("Cost nou:");
                int costNou = scan.nextInt();

                Statement st2 = myConn.createStatement();
                st2.execute(String.format("UPDATE piesa SET Nume = '%s', Furnizor = '%s', Stoc = '%d', Cost = '%d';", numeNou, furnizorNou, stocNou, costNou));
                System.out.println("Piesa a fost modificata");


            } catch (SQLException e) {
                System.out.println("Error la Modificare Piesa");
                e.printStackTrace();
            }

        } else {
            System.out.println("Caracteristicile user-ului tau nu iti perminte sa faci aceasta actiune");
            System.out.println("Alege o alta actiune pe care Rolul tau iti permite");
            System.out.println();
        }
        return optiune;
    }

    public static int[] veziPiese() {
        int[] optiune = new int[2];
        optiune[0] = 3;
        System.out.println("Acestea sunt piesele tale:");
        try {
            Connection myConn = DriverManager.getConnection(url, userDataBase, passDataBase);
            Statement st = myConn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM carshopandstore.piesa;");
            System.out.println("Piesele tale:");
            while (rs.next()) {
                int IDPiesa = rs.getInt("IDPiesa");
                String Nume = rs.getString("Nume");
                String furnizor = rs.getString("Furnizor");
                int Stoc = rs.getInt("Stoc");
                int Cost = rs.getInt("Cost");

                Piesa piesaDacia = new Piesa(IDPiesa,Nume,furnizor,Stoc,Cost);

//                System.out.println("id: "+  piesaDacia.getIdPiesa() + "|Nume:" + piesaDacia.getNumePiesa() + "|Furnizor: " +  piesaDacia.getNumeFurnizor() +"|Stoc :"+ piesaDacia.getStocPiesa() +"|Cost: "+ piesaDacia.getCostPiesa());


//                System.out.println(IDPiesa + ": " + Nume + "| Furnizor: " + furnizor + "| Stoc: " + Stoc + "| Cost: " + Cost);
//                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optiune;
    }
}


package ShopAndService.Utilities;

import ShopAndService.Application;

import java.sql.*;
import java.util.Scanner;

public class SingInLogIn {
    static Scanner scan = new Scanner(System.in);

    static String url = "jdbc:mysql://localhost:3306/CarShopAndStore";
    static String userDataBase = "root";
    static String passDataBase = "root";

    public static int[] MeniuSingIn(){
        System.out.println("CAR SHOP AND SERVICE INVENTORY");
        System.out.println("ALEGE INTRE SINGIN AND LOGIN");
        System.out.println("1: SING IN ");
        System.out.println("2: LOG IN ");

        int alegere = scan.nextInt();
        int[] optiune = new int[2];
        switch (alegere) {
            case 1:
                optiune[0] = 1;
                break;
            case 2:
                optiune[0] = 2;
                break;
        }
        return optiune;
    }

    public static int[] singIn(){
        int[] optiune = new int[2];
        String test = scan.nextLine();
        System.out.println("Enter new UserName");
        String userNameNewUser =  scan.nextLine();
        System.out.println("Enter new Password");
        String passwordNewUser = scan.nextLine();
        System.out.println("Pozitia ocupata:");
        System.out.println("1: Administrator");
        System.out.println("2: Mecanic");
        System.out.println("3: Vanzator");
        int alegere  = scan.nextInt();
        int postOcupat ;
        switch (alegere){
            case 1 :
                postOcupat = 1;
            break;
            case 2:
                postOcupat = 2;
            break;
            case 3:
                postOcupat = 3;
            break;
            default:
                postOcupat = 0;
                throw new IllegalStateException("Unexpected value: " + alegere);
        }
        try{
            Connection myConn = DriverManager.getConnection(url,userDataBase,passDataBase);
            Statement st = myConn.createStatement();
            st.execute(String.format("INSERT INTO user (UserName, Pass, Rol) VALUES ('%s','%s','%d')", userNameNewUser, passwordNewUser,postOcupat ));

            myConn.close();
            optiune[1] = postOcupat;
            optiune[0] = 3;



        } catch (SQLException e) {
            System.out.println("Eror SINGIN");
            e.printStackTrace();
        }
        return optiune;
    }

    public static int[] logIn(){
        String test = scan.nextLine();
        System.out.println("Enter UserName");
        String userNameLog = scan.nextLine();
        System.out.println("Enter Password");
        String passwordLog = scan.nextLine();
        int[] optiune = new int[2];
        optiune[0] = 2;

        try{
            Connection myConn = DriverManager.getConnection(url,userDataBase,passDataBase);
            Statement st = myConn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM user WHERE UserName = '%s'", userNameLog));
            int id;
            while (rs.next()){
                id = rs.getInt("Rol");
                String passVerify = rs.getString("Pass");
                if(passwordLog.matches(passVerify)){
                    System.out.println("UserName si Parola sunt inregistrate in baza noastra de data si sunt CORECTE!");
                    optiune[1] = id;
                    optiune[0] = 3;
                }else{
                    System.out.println("UserName si parola nu se potrivesc!");
                    optiune[0] = 2;
                }
            }
            myConn.close();
        } catch (SQLException e) {
            System.out.println("Eror LOGIN");
            e.printStackTrace();
        }
        return optiune;
    }
}

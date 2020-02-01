package ShopAndService;

import ShopAndService.Utilities.*;

import java.util.Scanner;

public class Application {
    public static int localUser;

//--------------------------------------------------------functie pt a transforma doua numere intr-un arr


    public static int[] options(int a, int b){
        int[] arr = {a,b};
        return arr;
    }

//---------------------------------------------------------

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("BUN VENIT LA CARSERVICEINVERNTORY");
        int[] rezultat   = SingInLogIn.MeniuSingIn();
        boolean aplicatieActiva = true;
        while (aplicatieActiva){
            switch (rezultat[0]){
                case 1 :
                    rezultat = SingInLogIn.singIn();
                    localUser = rezultat[1];
                    break;
                case 2 :
                    rezultat = SingInLogIn.logIn();
                    localUser = rezultat[1];
                    break;
                case 3:
                    rezultat = meniuPrincipal();
                    break;
                case 4:
                    rezultat = CRUD.adaugaPiesa();
                    break;
                case 5:
                    rezultat = CRUD.stergePiesa();
                    break;
                case 6:
                    rezultat = CRUD.editeazaPiesa();
                    break;
                case 7:
                    rezultat = CRUD.veziPiese();
                    break;
                case 8:
                    aplicatieActiva = false;
                    break;



            }
        }
    }

//----------------------------------------------------------------FUNCTIE MENIU PRINCIPAL

    public static int[] meniuPrincipal(){
        System.out.println("USER ROL : " + localUser);
        System.out.println();
        System.out.println("                   MENIU PRINCIPAL                   ");
        System.out.println("  __________________________________________________ ");
        System.out.println(" |**************************************************|");
        System.out.println(" |* 1: ADAUGA PIESA        |     * 2: STERGE PIESA  |");
        System.out.println(" | ------------------------|------------------------|");
        System.out.println(" |* 3: MODIFICA PIESA      |     * 4: VEZI PIESE    |");
        System.out.println(" |_________________________|________________________|");
        System.out.println("<-- 5: EXIT_________________________________________|");


        int alegere = scan.nextInt();
        int[] optiune = new int[2];

        switch (alegere){
            case 1:
                optiune[0] = 4;
                break;
            case 2:
                optiune[0] = 5;
                break;
            case 3:
                optiune[0] = 6;
                break;
            case 4:
                optiune[0] = 7;
                break;
            case 5:
                optiune[0] = 8;
                break;
        }
        return optiune;
    }
}

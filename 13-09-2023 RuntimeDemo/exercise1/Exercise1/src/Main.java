import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Runtime objrun =Runtime.getRuntime();
        System.out.println("Escolle unha das opcions:");
        Scanner sc = new Scanner(System.in);
        try {
            switch (sc.nextInt()) {
                case 1 -> System.out.println(objrun.availableProcessors());
                break;
                case 2 -> objrun.exec("C:\\Program Files\\Google\\Chrome\\Application\\Chrome.exe");
                break;
                case 3 -> System.out.println("nada");
                break;
                case 4 -> System.out.println("nada");
                break;


            }

        } catch(Exception e)
            {
                e.printStackTrace();
            }

        }
    }



}
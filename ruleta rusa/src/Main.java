import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Pon entre 1 y 5 balas: cuantas más balas, más dinero, si sobrevives:");
        int N = sc.nextInt();
        while (N < 1 || N > 5) {
            if (N == 6) {
                System.out.println("No seas tan suicida, pon entre 1 y 5 balas");
            } else if (N == 0) {
                System.out.println("Cobarde, pon entre 1 y 5 balas");
            } else {
                System.out.println("Sabes leer? Pon entre 1 y 5 balas");
            }
            N = sc.nextInt();
        }
        int dinero = 0;
        boolean vivo = true;
        boolean seguir = true;
        while (vivo && seguir) {
            System.out.println("El cañón del revólver toca su sien, tus manos sudan frío.");
            TimeUnit.SECONDS.sleep(2);
            int num = random.nextInt(6) + 1;
            if (num <= N) {
                vivo=false;
                System.out.println("Has muerto, más suerte en la próxima vida");
            } else {
                dinero += 1000;
                System.out.println("Click... sobrevives. Dinero acumulado: " + dinero + "€");
                System.out.println("¿Quieres seguir? (s/n)");
                String respuesta = sc.next();
                seguir = respuesta.equalsIgnoreCase("s");
            }
            System.out.println("Escapas con tu vida y " + dinero + "€, nada mal.");
        }
    }
}
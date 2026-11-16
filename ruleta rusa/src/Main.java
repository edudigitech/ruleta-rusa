import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static String[] frases = {
            "El cañón del revólver toca su sien, tus manos sudan frío.",
            "Escuchas tu corazón latir en los oídos mientras el dedo roza el gatillo.",
            "Una gota de sudor te resbala por la frente. No hay vuelta atrás.",
            "El tambor gira lentamente.",
            "Cierras los ojos y respiras hondo. Solo queda apretar."
    };

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
        int ronda = 0;
        boolean vivo = true;
        boolean seguir = true;

        while (vivo && seguir && ronda < N) {
            ronda++;
            System.out.println(frases[random.nextInt(frases.length)]);
            TimeUnit.SECONDS.sleep(2);

            int num = random.nextInt(6) + 1;
            if (num == 1) {
                vivo = false;
                dinero = 0;
                System.out.println("Has muerto, más suerte en la próxima vida");
            } else {
                dinero = 1000 * (int) Math.pow(2, ronda - 1);
                System.out.println("Click... sobrevives. Tienes " + dinero + "€");
                if (ronda < N) {
                    System.out.println("¿Quieres seguir? (s/n)");
                    String respuesta = sc.next();
                    seguir = respuesta.equalsIgnoreCase("s");
                }
            }
        }
        if (vivo) {
            System.out.println("Escapas con tu vida y " + dinero + "€, nada mal.");
        }
    }
}
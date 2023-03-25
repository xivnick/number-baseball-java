import java.util.Scanner;
import java.util.Random;

public class Main {

    public static int randomNum(int n) {
        // 1부터 n 중에 랜덤하게 하나 뽑는 함수
        Random rand = new Random();
        return rand.nextInt(n) + 1;
    }

    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        while (a == b || b == c || c == a) {
            a = randomNum(9);
            b = randomNum(9);
            c = randomNum(9);
        }

        int score = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            score++;

            // 사용자 입력 받기
            System.out.print("숫자를 입력하세요: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();

            // 채점하기
            int strike = 0;
            int ball = 0;

            if (x == a) strike++;
            if (x == b || x == c) ball++;

            if (y == b) strike++;
            if (y == a || y == c) ball++;

            if (z == c) strike++;
            if (z == a || z == b) ball++;

            if (strike == 3) {
                break;
            }

            if (strike == 0 && ball == 0) {
                System.out.println("out");
            } else {
                System.out.printf("%ds %db\n", strike, ball);
            }
        }

        System.out.println("Congraturation!");
        System.out.printf("당신의 점수는: %d", score);
    }
}

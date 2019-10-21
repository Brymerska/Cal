import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

    /**
     * Mapa -> będzie przechowywać lambdy i symbole kalkulacji
     * Parametrami są String i interfejs
     */
    private static final Map<String, CalInterface> calculationMap = new HashMap<>();

    public static void main(String[] args) {
        fillMap();
        Scanner in = new Scanner(System.in);

        double a, b;

        System.out.println("Podaj pierwszą liczbę");
        a = in.nextDouble();
        System.out.println("Podaj druga liczbę");
        b = in.nextDouble();

        System.out.println("Wybierz operację do wykonania:" +
                "\n1.Dodawanie\n2.Odejmowanie\n3.Mnożenie" +
                "\n4.Dzielenie\n5.Potęgowanie");
        double choice = in.nextDouble();

        if (choice == 1) {
            result("+", a, b);
        } else if (choice == 2) {
            result("-", a, b);
        } else if (choice == 3) {
            result("*", a, b);
        } else if (choice == 4) {
            result("/", a, b);
        } else if (choice == 5) {
            result("^", a, b);
        }
    }

    /**
     * Wypełniamy mapę symbolami kalkulacji i lambdami
     */
    private static void fillMap() {
        calculationMap.put("+", (a, b) -> a + b);
        calculationMap.put("-", (a, b) -> a - b);
        calculationMap.put("/", (a, b) -> a / b);
        calculationMap.put("*", (a, b) -> a * b);
        calculationMap.put("^", (a, b) -> Math.pow(a, b));
    }

    /**
     * Zwraca gotowy wynik po wybraniu operatorem odpowiedniej lambdy i wykonaniu metody calculate
     */
    private static void result(String operator, double a, double b) {
        double result = calculationMap.get(operator).calculate(a, b);
        System.out.println(result);
    }
}
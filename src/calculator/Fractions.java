package calculator;

public class Fractions {
    public int numerator;
    public int denominator;

    public Fractions(int numerator, int denominator) { // конструктор с передачей двух параметров
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fractions() { // конструктор "по умолчанию"
        this.numerator = 1;
        this.denominator = 1;
    }

    // алгоритм Евклида для нахождения НОД
    private static int gcd(int numerator, int denominator) {
        while (denominator != 0) {
            int tmp = numerator % denominator; //tmp = 0
            numerator = denominator; //num = 2
            denominator = tmp; // den = 0
        }
        return numerator;
    }

    // алгоритм нахождения НОК
    private static int lcm(int den1, int den2){
        return den1 / gcd(den1, den2) * den2;
    }

    // функция для показания сокращенной до простого вида дроби
    private static void showReduction(String a, Fractions obj) {
        while (gcd(obj.numerator, obj.denominator) != 1) {
            int x = gcd(obj.numerator, obj.denominator);
            obj.numerator /= x;
            obj.denominator /= x;
        }
        to_normal(obj);

        System.out.printf("The result of %s: %d/%d\n", a, obj.numerator, Math.abs(obj.denominator));
    }

    // Функция show задана для того, чтобы перенаправлять в функцию showReduction через новый класс
    // Потому что если указывать без нового класса значения полей меняются и в последующем следуют неправильные вычисления
    private static void show(Fractions obj) {
        String a = "entering fraction values";
        showReduction(a,new Fractions(obj.numerator, obj.denominator));
    }

    // вывести минус перед числителем
    private static void to_normal(Fractions obj) {
        obj.numerator = obj.denominator < 0 ? -obj.numerator : obj.numerator;
        obj.denominator = obj.numerator < 0 ? -obj.denominator : obj.denominator;
    }

    // функция сложения
    public static void addition(Fractions num1, Fractions num2) {
        int nok = lcm(num1.denominator, num2.denominator);
        int first = nok / num1.denominator * num1.numerator;
        int second = nok / num2.denominator * num2.numerator;
        int final_numerator = first + second;
        String a = "addition";
        showReduction(a,new Fractions(final_numerator, nok));
    }

    // функция вычитания
    public static void subtraction(Fractions obj1, Fractions obj2) {
        int nok = lcm(obj1.denominator, obj2.denominator);
        int first = nok / obj1.denominator * obj1.numerator;
        int second = nok / obj2.denominator * obj2.numerator;
        int final_numerator = first - second;
        String a = "subtraction";
        showReduction(a,new Fractions(final_numerator, nok));
    }

    // функция умножения
    public static void multiple(Fractions num1, Fractions num2) {
        int final_numerator = num1.numerator * num2.numerator;
        int final_denominator = num1.denominator * num2.denominator;
        String a = "multiple";
        showReduction(a,new Fractions(final_numerator, final_denominator));
    }

    // функция деления
    public static void division(Fractions num1, Fractions num2) throws Exception {
        if (num2.numerator == 0) {
            System.out.println("You can't divide by zero");
            throw new Exception();
        }
        int final_numerator = num1.numerator * num2.denominator;
        int final_denominator = num1.denominator * num2.numerator;
        String a = "division";
        showReduction(a, new Fractions(final_numerator, final_denominator));
    }

    // второй вариант функций сложения, вычитания, умножения и деления
    public void addition(Fractions num2) {
        int nok = lcm(this.denominator, num2.denominator);
        int first = nok / this.denominator * this.numerator;
        int second = nok / num2.denominator * num2.numerator;
        int final_numerator = first + second;
        String a = "addition";
        showReduction(a,new Fractions(final_numerator, nok));
    }

    public void subtraction(Fractions obj2) {
        int nok = lcm(this.denominator, obj2.denominator);
        int first = nok / this.denominator * this.numerator;
        int second = nok / obj2.denominator * obj2.numerator;
        int final_numerator = first - second;
        String a = "subtraction";
        showReduction(a,new Fractions(final_numerator, nok));
    }

    public void multiple(Fractions num2) {
        int final_numerator = this.numerator * num2.numerator;
        int final_denominator = this.denominator * num2.denominator;
        String a = "multiple";
        showReduction(a,new Fractions(final_numerator, final_denominator));
    }

    public void division(Fractions num2) throws Exception {
        if (num2.numerator == 0) {
            System.out.println("You can't divide by zero");
            throw new Exception();
        }
        int final_numerator = this.numerator * num2.denominator;
        int final_denominator = this.denominator * num2.numerator;
        String a = "division";
        showReduction(a, new Fractions(final_numerator, final_denominator));
    }
}

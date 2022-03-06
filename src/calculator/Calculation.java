package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.Fractions.*;

public class Calculation {
    public String expression;

    public Calculation (String expression) {
        this.expression = expression;
    }

    public boolean check() {
        String regex = "(-*\\d+)/(\\d+)\\s*([+*:-])\\s*(-*\\d+)/(\\d+)";
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(this.expression);

        return m.find();
    }

    public void calculation() throws Exception {
        String regex = "(-*\\d+)/(\\d+)\\s*([+*:-])\\s*(-*\\d+)/(\\d+)";
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(this.expression);

        if (m.find()) {
            int numE1 = Integer.parseInt(m.group(1));
            int denE1 = Integer.parseInt(m.group(2));
            Fractions objE1 = new Fractions(numE1, denE1);
            String sign = m.group(3);
            int numE2 = Integer.parseInt(m.group(4));
            int denE2 = Integer.parseInt(m.group(5));
            Fractions objE2 = new Fractions(numE2, denE2);
            if (Objects.equals(sign, "+")) {
                addition(objE1, objE2);
            }
            else if (Objects.equals(sign, "-")) {
                subtraction(objE1, objE2);
            }
            else if (Objects.equals(sign, "*")) {
                multiple(objE1, objE2);
            }
            else if (Objects.equals(sign, ":")) {
                division(objE1, objE2);
            }
        }
    }


}

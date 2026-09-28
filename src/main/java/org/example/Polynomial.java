package org.example;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private List<Complex> c;

    public Polynomial(List<Complex> c) {
        this.c = c;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.size(); i++) {

            sb.append("(").append(c.get(i)).append(") * x^").append(i);

            if (i < c.size() - 1) {
                sb.append(" + ");
            }
        }
        return sb.toString();
    }

    public Polynomial add(Polynomial other) {
        List<Complex> resultCoeffs = new ArrayList<>();
        int maxLength = Math.max(this.c.size(), other.c.size());

        for (int i = 0; i < maxLength; i++) {
            Complex c1 = (i < this.c.size()) ? this.c.get(i) : new Complex(0.0, 0.0);
            Complex c2 = (i < other.c.size()) ? other.c.get(i) : new Complex(0.0, 0.0);
            Complex sum = c1.add(c2);
            resultCoeffs.add(sum);
        }
        return new Polynomial(resultCoeffs);
    }
}
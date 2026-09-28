package org.example;
import java.util.Objects;

public class Complex {
    private double re;
    private double im;

    public Complex(){
        this.re = 0.0;
        this.im = 0.0;
    }

    public Complex(double re){
        this.re = re;
        this.im = 0.0;
    }

    public Complex(double re,double im){
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public void setIm(double im) {
        this.im = im;
    }

    @Override
    public String toString() {
        return re + " + " + im + "i";
    }
    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (other ==  null || getClass() != other.getClass()) return false;
        Complex complex = (Complex) other;
        return Double.compare(this.re, complex.re) == 0 && Double.compare(this.im, complex.im) == 0;
    }

    public Complex add(Complex other){
        return new Complex(this.re + other.re,this.im + other.im);
    }

    public Complex multiply(Complex other) {
        double newRe = (this.re * other.re) - (this.im * other.im);
        double newIm = (this.re * other.im) + (this.im * other.re);
        return new Complex(newRe, newIm);
    }


}


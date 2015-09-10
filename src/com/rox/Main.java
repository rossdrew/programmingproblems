package com.rox;


import com.rox.prob.codingbat.Recursion1;
import com.rox.prob.codingbat.Warmup2;
import com.rox.prob.common.NumberAnalyser;
import com.rox.prob.euler.*;
import com.rox.prob.NumericalProblem;

public class Main {

    public static void main(String[] args) {
        NumericalProblem p = new Problem12();
        /*DEBUG*/System.out.println(p.solution());

        Warmup2 w = new Warmup2();
        /*DEBUG*///System.out.println(w.stringMatch("xxcaazz", "xxbaaz"));

        Recursion1 r = new Recursion1();
        /*DEBUG*///System.out.println(r.sumDigits(333));
    }
}

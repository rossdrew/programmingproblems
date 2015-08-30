package com.rox;


import com.rox.prob.codingbat.Warmup2;
import com.rox.prob.common.NumberAnalyser;
import com.rox.prob.euler.*;
import com.rox.prob.NumericalProblem;

public class Main {

    public static void main(String[] args) {
        NumericalProblem p = new Problem4();
        /*DEBUG*/System.out.println(p.solution());

        Warmup2 w = new Warmup2();
        /*DEBUG*/System.out.println(w.array123(new int[] {1,9,1,2,3,3,2,5,7,2}));
    }
}

package com.chaco.algorithms;

import java.math.BigDecimal;

public class salary {
    public static void main(String[] args) {
        System.out.println("salary.main");
        salaryRates();
    }

    public static void salaryRates() {
        BigDecimal didiS = new BigDecimal("27000");
        int didiHaltHours = 23;//11:00 ~ 21:00
        BigDecimal didiPreHaltHour = didiS.divide(new BigDecimal(didiHaltHours), 4, BigDecimal.ROUND_HALF_DOWN);
        System.out.println("didi.salaryRates:" + didiPreHaltHour);
        BigDecimal mcS = new BigDecimal("33000");
        int mcHaltHours = 13;//11:30 ~ 18:00
        BigDecimal mcPreHaltHour = mcS.divide(new BigDecimal(mcHaltHours), 4, BigDecimal.ROUND_HALF_DOWN);
        System.out.println("mc.salaryRates:" + mcPreHaltHour);

        
    }
}
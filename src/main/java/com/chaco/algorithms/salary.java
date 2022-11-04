package com.chaco.algorithms;

import java.math.BigDecimal;

public class salary {
    public static void main(String[] args) {
        System.out.println("salary.main");
        salaryRates();
    }

    public static void salaryRates() {
        BigDecimal keS = new BigDecimal("19000");
        int keHaltHours = 24;//10:30 ~ 21:00
        BigDecimal kePreHaltHour = keS.divide(new BigDecimal(keHaltHours), 4, BigDecimal.ROUND_HALF_DOWN);
        System.out.println("ke.salaryRates:" + kePreHaltHour);
        System.out.println("==============================================================");

        BigDecimal didiS = new BigDecimal("27000");
        int didiHaltHours = 23;//11:00 ~ 21:00
        BigDecimal didiPreHaltHour = didiS.divide(new BigDecimal(didiHaltHours), 4, BigDecimal.ROUND_HALF_DOWN);
        System.out.println("didi.salaryRates:" + didiPreHaltHour);
        System.out.println("==============================================================");

        BigDecimal mcS = new BigDecimal("33000");
        int mcHaltHours = 13;//11:30 ~ 18:00
        BigDecimal mcPreHaltHour = mcS.divide(new BigDecimal(mcHaltHours), 4, BigDecimal.ROUND_HALF_DOWN);
        System.out.println("mc.salaryRates:" + mcPreHaltHour);
        System.out.println("==============================================================");
    }
}
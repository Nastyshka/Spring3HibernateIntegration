package ua.kpi.schedule.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author AnastasiyaR
 */

public class Constants {
    public static final int CLASS   = 1;
    public static final int TEACHER = 2;
    public static final int LESSON  = 3;
    public static final int TIME    = 4;
    public static final int GROUP   = 0;

    @Value("${chromosomeSize}")
    public static Integer chromosomeSize;
    @Value("${populationSize}")
    public static Integer populationSize;
    @Value("${maxEvolution}")
    public   static Integer maxEvolution;
    @Value("${threshold}")
    public static Integer threshold;
}

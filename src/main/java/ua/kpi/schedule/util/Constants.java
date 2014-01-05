package ua.kpi.schedule.util;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * @author AnastasiyaR
 */
public class Constants {
    public static final int CLASS   = 1;
    public static final int TEACHER = 2;
    public static final int LESSON  = 3;
    public static final int TIME    = 4;
    public static final int GROUP   = 0;

//    @Value("${new Integer.parseInt('${chromosomeSize}')}")
    public static Integer chromosomeSize = 4;
//    @Value("${new Integer.parseInt('${populationSize}')}")
    public static Integer populationSize = 20;
//    @Value("${new Integer.parseInt('${maxEvolution}')}")
    public   static Integer maxEvolution = 1000;
//    @Value("${new Integer.parseInt('${threshold}')}")
    public static Integer threshold = 6;

    public Integer getChromosomeSize() {
        return chromosomeSize;
    }
}

package ua.kpi.schedule.ga;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.schedule.util.Constants;


public class TimetableFitnessFunction extends FitnessFunction {

    private static final double NO_FITNESS_VALUE = 9999999;
    private static final int CENTRAL_VALUE = 0;
    private Integer[] estimate = new Integer[Constants.chromosomeSize];
    private double fitness;

    @Override
    protected double evaluate(IChromosome a_subject) {
        fitness = 0;

        // Extract supergenes from chromosome
        GroupClassTeacherLessonTimeSG[] s = new GroupClassTeacherLessonTimeSG[Constants.chromosomeSize];
        for (int i = 0; i < Constants.chromosomeSize; i++) {
            s[i] = (GroupClassTeacherLessonTimeSG) a_subject.getGene(i);
        }

        //------------Checking hard constraints----------------------------
        for (int i = 0; i < Constants.chromosomeSize; i++) {
            for (int j = 0; j < Constants.chromosomeSize; j++) {

                //-----------Avoid one group be in the two classes at the same time
                if (i != j && s[i].geneAt(Constants.GROUP).equals(s[j].geneAt(Constants.GROUP))
                        //&& s[i].geneAt(CLASS).equals(s[j].geneAt(CLASS))
                        && s[i].geneAt(Constants.TIME).equals(s[j].geneAt(Constants.TIME))
                        ) {
                    return 0;
                }
                //-----------Avoid one class being occuped more than one group at the same time
                else if (i != j //&& s[i].geneAt(GROUP).equals(s[j].geneAt(GROUP))
                        && s[i].geneAt(Constants.CLASS).equals(s[j].geneAt(Constants.CLASS))
                        && s[i].geneAt(Constants.TIME).equals(s[j].geneAt(Constants.TIME))
                        ) {
                    return 0;
                }
                //-----------Avoid that a group has one class more than once
                else if (i != j && s[i].geneAt(Constants.GROUP).equals(s[j].geneAt(Constants.GROUP))
                        && s[i].geneAt(Constants.CLASS).equals(s[j].geneAt(Constants.CLASS))) {
                    return 0;
                }
                //-----------Avoid one teacher being in the two classes at the same time
                else if (i != j && s[i].geneAt(Constants.TEACHER).equals(s[j].geneAt(Constants.TEACHER))
                        && s[i].geneAt(Constants.TIME).equals(s[j].geneAt(Constants.TIME))) {
                    return 0;
                }
            }


        }

        //------------Checking soft constraints----------------------------

        for (int i = 0; i < Constants.chromosomeSize; i++) {
            s[i] =
                    (GroupClassTeacherLessonTimeSG) a_subject.getGene(i);
            estimate[i] = (Integer) s[i].geneAt(Constants.GROUP).getAllele();
            estimate[i] += (Integer) s[i].geneAt(Constants.CLASS).getAllele();
            estimate[i] += (Integer) s[i].geneAt(Constants.TIME).getAllele();
            fitness += estimate[i];
        }
        System.out.println("Fitness is: " + fitness);
        return fitness;
//        return 1 / (1 + Math.abs(CENTRAL_VALUE - fitness));

    }
}

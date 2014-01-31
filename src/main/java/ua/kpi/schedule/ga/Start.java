package ua.kpi.schedule.ga;

import org.jgap.*;
import org.jgap.InvalidConfigurationException;
import org.jgap.event.EventManager;
import org.jgap.impl.BestChromosomesSelector;
import org.jgap.impl.CrossoverOperator;
import org.jgap.impl.StockRandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.schedule.ga.genes.*;
import ua.kpi.schedule.model.Lesson;
import ua.kpi.schedule.util.Constants;
import ua.kpi.schedule.util.GeneticUtil;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class Start {
    protected static int MAX_EVOLUTIONS;
    private static final String GENOTYPE_FILENAME = "D:\\population.xml";
    private static final String BEST_CHROMOSOME_FILENAME = "D:\\best_chromosome.xml";
    private static final String XML_TEST_FILENAME = "D:\\inputTimetable.xml";
    private static long start_t = 0;
    private static long finish_t = 0;
    @Autowired
    GeneticUtil geneticUtil;

    public List<Lesson> main() throws InvalidConfigurationException {

        // Reading data from xml
//        try {
//            new InputData().readFromFile(XML_TEST_FILENAME);
//        } catch (SAXException e) {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        } catch (ParserConfigurationException e) {
//            System.out.println(e.getMessage());
//        }

        geneticUtil.setUpGenes();
//        Configuration conf = new DefaultConfiguration();
        Configuration conf = new Configuration("myconf");
        conf.reset();
        TimetableFitnessFunction fitnessFunction =
            new TimetableFitnessFunction();
        InitialConstraintChecker timetableConstraintChecker =
            new InitialConstraintChecker();

        //Creating genes
        Gene[] testGenes = new Gene[Constants.chromosomeSize];
        for (int i = 0; i < Constants.chromosomeSize; i++) {
            testGenes[i] =
                    new GroupClassTeacherLessonTimeSG(conf, new Gene[] { new GroupGene(conf,1),
                                                                   new ClassGene(conf,1),
                                                                   new TeacherGene(conf,1),
                                                                   new LessonGene(conf,1),
                                                                   new TimeGene(conf,1)
                                                                         });
        }
        System.out.println("==================================");
        //Creating chromosome
        Chromosome testChromosome;
        testChromosome = new Chromosome(conf, testGenes );
        testChromosome.setConstraintChecker(timetableConstraintChecker);
        //Setup configuration
        conf.setSampleChromosome(testChromosome);
        conf.setPopulationSize(Constants.populationSize);
        conf.setFitnessFunction(fitnessFunction); // add fitness function

        BestChromosomesSelector myBestChromosomesSelector =
            new BestChromosomesSelector(conf);
        conf.addNaturalSelector(myBestChromosomesSelector, false);

        conf.setRandomGenerator(new StockRandomGenerator());
        conf.setEventManager(new EventManager());
        conf.setFitnessEvaluator(new DefaultFitnessEvaluator());

        CrossoverOperator myCrossoverOperator =
            new CrossoverOperator(conf);
        conf.addGeneticOperator(myCrossoverOperator);

        TimetableMutationOperator myMutationOperator =
            new TimetableMutationOperator(conf);
        conf.addGeneticOperator(myMutationOperator);

        conf.setKeepPopulationSizeConstant(false);

        //Creating genotype
        Population pop = new Population(conf, testChromosome);
        Genotype population = new Genotype(conf, pop);
//        Genotype population = Genotype.randomInitialGenotype(conf);

        System.out.println("Our Chromosome: \n " +
                           testChromosome.getConfiguration().toString());

        System.out.println("------------evolution-----------------------------");


        // Begin evolution
        Calendar cal = Calendar.getInstance();
        start_t = cal.getTimeInMillis();
        for (int i = 0; i < MAX_EVOLUTIONS; i++) {
            System.out.println("generation#: "+i+" population size:"+
                               (Integer)population.getPopulation().size());
            if (population.getFittestChromosome().getFitnessValue() >=
                Constants.threshold)
                break;
            population.evolve();
        }
        cal = Calendar.getInstance();
        finish_t = cal.getTimeInMillis();

        System.out.println("--------------end of evolution--------------------");
        Chromosome fittestChromosome =
            (Chromosome)population.getFittestChromosome();
        System.out.println("-------------The best chromosome---fitness=" +
                           fittestChromosome.getFitnessValue() + "---");
        System.out.println("                Group Class Time");
        for (int i = 0; i < Constants.chromosomeSize; i++) {
            GroupClassTeacherLessonTimeSG s =
                (GroupClassTeacherLessonTimeSG)fittestChromosome.getGene(i);
            System.out.println("Gene " + i + " contains: " +
                               (Integer)s.geneAt(Constants.GROUP).getAllele() + " " +
                               (Integer)s.geneAt(Constants.CLASS).getAllele() + " " +
                               (Integer)s.geneAt(Constants.TEACHER).getAllele() + " " +
                               (Integer)s.geneAt(Constants.LESSON).getAllele() + " " +
                               (Integer)s.geneAt(Constants.TIME).getAllele());
        //GroupGene gg = (GroupGene)s.geneAt(GROUP);
        //System.out.println("gg's idGroup"+gg.getAllele()+" gg.getGroupSize()"+ gg.getGroupSize() );
        }

        System.out.println( "Elapsed time:"+
                          (double)(finish_t - start_t)/1000 +"s");

        //Display the best solution
        geneticUtil.extractLessonsDataFromChromosome(fittestChromosome);
//        OutputData od = new OutputData();
//        od.printToConsole(fittestChromosome);

        OutputData od = new OutputData();
        od.printToConsole(fittestChromosome);
        return geneticUtil.extractLessonsDataFromChromosome(fittestChromosome);
    }

}


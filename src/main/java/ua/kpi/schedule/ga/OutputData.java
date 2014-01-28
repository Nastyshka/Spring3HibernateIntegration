package ua.kpi.schedule.ga;


import com.sun.org.apache.xml.internal.serialize.DOMSerializer;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.Serializer;
import com.sun.org.apache.xml.internal.serialize.SerializerFactory;
import com.sun.org.apache.xml.internal.serializer.Method;
import org.jgap.Chromosome;
import org.jgap.Genotype;
import org.jgap.xml.XMLManager;
import org.w3c.dom.Document;
import ua.kpi.schedule.ga.genes.GroupClassTeacherLessonTimeSG;
import ua.kpi.schedule.ga.genes.GroupGene;
import ua.kpi.schedule.ga.genes.TimeGene;
import ua.kpi.schedule.util.Constants;
import ua.kpi.schedule.util.GeneticUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


class OutputData {

    private Integer max_idGroup;
    private Integer max_idTime;

    GeneticUtil geneticProcessor;

    OutputData() {

    }

    void printToFile(Genotype a_currentPopulation,
                     String a_savePopulationToFilename,
                     String a_saveBestChromosomeToFilename ) throws IOException {
        //Convert Genotype to a DOM object
        Document xmlRepresentation =
            XMLManager.representGenotypeAsDocument(a_currentPopulation);
//
//        Writer genotypetWriter = new FileWriter(a_savePopulationToFilename);
//
//        OutputFormat formatting =
//            new OutputFormat(xmlRepresentation, "UTF-8", true);
//        SerializerFactory factory =
//            SerializerFactory.getSerializerFactory(Method.XML);
//        Serializer genotypeGenericSerializer =
//            factory.makeSerializer(genotypetWriter, formatting);
//        DOMSerializer genotypeDocumentSerializer = genotypeGenericSerializer.asDOMSerializer();
//
//        genotypeDocumentSerializer.serialize(xmlRepresentation);
//        genotypetWriter.close();
//
//        //Convert bestChromosome to a DOM object
//        Document bestChromosomeXMLRepresentation =
//            XMLManager.representChromosomeAsDocument(a_currentPopulation.getFittestChromosome());
//        Writer chromosomeWriter = new FileWriter( a_saveBestChromosomeToFilename );
//
//        Serializer chromosomeGenericSerializer =
//          factory.makeSerializer(chromosomeWriter, formatting);
//        DOMSerializer chromosomeDocumentSerializer = chromosomeGenericSerializer.asDOMSerializer();
//        chromosomeDocumentSerializer.serialize(bestChromosomeXMLRepresentation);
//        chromosomeWriter.close();
//    }

        Writer genotypetWriter = new FileWriter(a_savePopulationToFilename);

        OutputFormat formatting =
            new OutputFormat(xmlRepresentation, "UTF-8", true);
        SerializerFactory factory =
            SerializerFactory.getSerializerFactory(Method.XML);
        Serializer genotypeGenericSerializer =
            factory.makeSerializer(genotypetWriter, formatting);
        DOMSerializer genotypeDocumentSerializer = genotypeGenericSerializer.asDOMSerializer();

        genotypeDocumentSerializer.serialize(xmlRepresentation);
        genotypetWriter.close();

        //Convert bestChromosome to a DOM object
        Document bestChromosomeXMLRepresentation =
            XMLManager.representChromosomeAsDocument(a_currentPopulation.getFittestChromosome());
        Writer chromosomeWriter = new FileWriter( a_saveBestChromosomeToFilename );

        Serializer chromosomeGenericSerializer =
          factory.makeSerializer(chromosomeWriter, formatting);
        DOMSerializer chromosomeDocumentSerializer = chromosomeGenericSerializer.asDOMSerializer();
        chromosomeDocumentSerializer.serialize(bestChromosomeXMLRepresentation);
        chromosomeWriter.close();
    }

    void printToConsole(Chromosome a_bestChromosome) {

        // Extracting GroupClassTimeSupergene from a_bestChromosome
        GroupClassTeacherLessonTimeSG[] s =
            new GroupClassTeacherLessonTimeSG[Constants.chromosomeSize];
        s[0] = (GroupClassTeacherLessonTimeSG)a_bestChromosome.getGene(0);

        // Extracting max_idGroup from GroupGene
        GroupGene gg = (GroupGene)s[0].geneAt(Constants.GROUP);
        max_idGroup = gg.getMax_idGroup();

        // Extracting max_idTime from TimeGene
        //TimeGene tg = (TimeGene)s[0].geneAt(Start.TIME);
        max_idTime = TimeGene.getMax_idTimeSlot();


        // first - Group, second - Time
        String[][] str = new String[max_idGroup][max_idTime];
        for (int i = 0; i < max_idGroup; i++) {
            for (int j = 0; j < max_idTime; j++) {
                str[i][j] = "-/-/-";
            }
        }

        for (int i = 0; i < Constants.chromosomeSize; i++) {
            s[i] = (GroupClassTeacherLessonTimeSG)a_bestChromosome.getGene(i);

            // Here we are going through all of the id_groups and the id_times
            // and filling str[][] array
            for (int j = 0; j < max_idGroup; j++) {
                for (int k = 0; k < max_idTime; k++) {
                    if ((Integer)s[i].geneAt(Constants.GROUP).getAllele() == j &&
                        (Integer)s[i].geneAt(Constants.TIME).getAllele() == k)
                        str[j][k] =
                                s[i].geneAt(Constants.LESSON).getAllele().toString() +"/"+
                                s[i].geneAt(Constants.TEACHER).getAllele().toString()+"/"+
                                s[i].geneAt(Constants.CLASS).getAllele().toString();
                }
            }
        }

//        GeneticUtil geneticUtil = new GeneticUtil();
//        geneticUtil.extractLessonsDataFromChromosome(a_bestChromosome);
        // Printing str[][] array
        System.out.println("------------------------------");
        System.out.println("-----Lesson/Teacher/Class-----");
        System.out.print("   ");
        for (int i = 0; i < max_idGroup; i++) {
            System.out.print(i + "        ");
        }

        System.out.println("");

        for (int i = 0; i < max_idTime; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < max_idGroup; j++) {
                System.out.print(str[j][i] + "    ");
            }
            System.out.println("");
        }
    }

}

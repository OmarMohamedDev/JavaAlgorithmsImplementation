package mohamed.sort;

/**
 * @author Omar Mohamed
 */
import static java.lang.System.getProperty;
import static java.lang.System.nanoTime;
import static mohamed.sort.Sorting.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.EnumSet;

public class SortTiming {

    /**
     * Private Constructor
     */
    private SortTiming(){

    }

    static int[] naturalRandomArray(int len, int maxVal) {
        int[] a = new int[len];
        Random rand = new Random();
        for(int i=0; i<len; ++i) {
            a[i] = rand.nextInt(maxVal+1);
        }
        return a;
    }

    static enum SequenceKind {
        UNSORTED, ALMOST_SORTED, REPEATED_VALUES;
    }

    static enum Algorithm {
        SSORT,
        ISORT, ISORT_BIN,
        MSORT_BASIC, MSORT_NO_GAR, MSORT_ALT, PAR_MSORT,
        QSORT_BASIC, QSORT_HOARE, PAR_QSORT,
        HSORT,
        JAVASORT, JAVASORT_PAR;
    }

    public static void sort(Algorithm algo, int[] a) {
        switch(algo) {
            case SSORT: ssort(a); break;
            case ISORT: isort(a); break;
            case ISORT_BIN: isortBin(a); break;
            case MSORT_BASIC: msortBasic(a); break;
            case MSORT_NO_GAR: msortNoGarbage(a); break;
            case MSORT_ALT: msortAlt(a); break;
            case PAR_MSORT: parallelMergesort(a); break;
            case QSORT_BASIC: qsortBasic(a); break;
            case QSORT_HOARE: qsortHoare(a); break;
            case PAR_QSORT: parallelQuicksort(a); break;
            case HSORT: hsort(a); break;
            case JAVASORT: Arrays.sort(a); break;
            case JAVASORT_PAR: Arrays.parallelSort(a); break;
        }
    }

    static EnumSet<Algorithm> quadraticVsOptimal =
            EnumSet.range(Algorithm.SSORT, Algorithm.MSORT_BASIC);

    static EnumSet<Algorithm> optimal =
            EnumSet.range(Algorithm.MSORT_BASIC, Algorithm.JAVASORT_PAR);

    static double executionTime(Algorithm algo, int[] a) {
        long t1 = nanoTime();
        sort(algo, a);
        long t2 = nanoTime();
        if(!isSorted(a)) throw new RuntimeException("not ordered");
        return (t2 - t1)/1E6;
    }

    /**
     * Crea una riga della tabella sull'output out, per sequenze di genere kind,
     * eseguendo tutti gli algoritmi algorithms, su un array di lunghezza len
     */
    static void runAllAlgorithms(EnumSet<Algorithm> algorithms, SequenceKind kind, PrintWriter out, int len) {
        int maxValue = (kind == SequenceKind.REPEATED_VALUES) ? len/3 : 9*len/10;
        int[] array = naturalRandomArray(len, maxValue);
        if(kind == SequenceKind.ALMOST_SORTED) {
            Arrays.sort(array);
            swap(array, len/3, 2*len/3);
        }

        out.printf("%6d;", len);
        System.out.println(len);
        for(Algorithm algo: algorithms) {
            System.out.println(algo.toString());
            int[] arrayCopy = Arrays.copyOf(array, array.length);
            double time = executionTime(algo, arrayCopy);
            out.printf("%9.2f;", time);
        }
        out.println();
        System.out.println();
    }

    /**
     * Crea una tabella sull'output out, per tutti i generi di sequenze,
     * eseguendo tutti gli algoritmi su array di lunghezze via via crescenti,
     * da step fino a maxLength
     */
    static void makeTable(EnumSet<Algorithm> algorithms, int step, int maxLength, String fileName) throws IOException {;
        FileWriter outFile = new FileWriter(fileName, false);
        PrintWriter writer = new PrintWriter(outFile);
        writer.println("sep=;");
        writer.println("Test a on a int array: " + getProperty("os.name") + " Java "+ getProperty("java.version"));
        for(SequenceKind kind: SequenceKind.values()) {
            writer.println(kind.toString());
            System.out.println(kind.toString() + "\n");
            for(Algorithm algo: algorithms) writer.print(";" + algo.toString());
            writer.println();
            for(int len = step; len <= maxLength; len += step) {
                runAllAlgorithms(algorithms, kind, writer, len);
            }
            writer.println();
        }
        writer.close();
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        makeTable(quadraticVsOptimal, 50000, 150000, "quadraticTimes.csv");
        makeTable(optimal, 100000, 2000000, "optimalTimes.csv");
        System.out.println("end!");
    }
}
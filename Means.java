package averages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class generates a double list with random numbers and fixed size, 
 * and then calculates and prints three different means (arithmetic, geometric, and harmonic).
 * @author Glenn Richards
 * @version 28 March 2020
 */
public class Means {

    private static final Random RNG = new Random();
    private static final int SIZE_THRESHOLD = 12;
    
    /**
     * Creates a list of type double.
     * @param size Determines the size of the generated random list.
     * @return The double list generated.
     */
    public static List<Double> makeRandomList(int size) {
        List<Double> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            double r = RNG.nextDouble();
            result.add(r);
        } // for

        return result;
    } // makeRandomList( int )

    /**
     * Prints the list it receives as a parameter.
     * @param data A list containing doubles.
     */
    public static void printList(List<Double> data) {
        if (data.size() < SIZE_THRESHOLD) {
            for (double x : data) {
                System.out.printf(" %4.2f", x);
            } // for
            System.out.println();
        } // if
        else {
            for (double x : data) {
                System.out.printf("\t%4.2f\n", x);
            } // for
        } // else
    } // printList( List<Double> )

    /**
     * Calculates the arithmetic mean of the provided list.
     * @param data A list containing doubles.
     * @return The arithmetic mean provided as a double.
     */
    public static double arithmeticMean(List<Double> data) {
        double result = 0.0;

        if (data.size() > 0) {
            double sum = 0.0;
            for (double x : data) {
                sum += x;
            } // for

            result = sum / data.size();
        } // if

        return result;
    } // arithmeticMean( List<Double> )

    /**
     * Calculates the geometric mean of the provided list.
     * @param data A list containing doubles.
     * @return The geometric mean provided as a double.
     */
    public static double geometricMean(List<Double> data) {
        double result = 0.0;

        if (data.size() > 0) {
            double product = 1.0;
            for (double x : data) {
                product *= x;
            } // for
            result = Math.pow(product, 1.0 / data.size());
        } // if

        return result;
    } // geometricMean( List<Double> )

    /**
     * Calculates the harmonic mean of the provided list.
     * @param data A list containing doubles.
     * @return The harmonic mean provided as a double.
     */
    public static double harmonicMean(List<Double> data) {
        double result = 0.0;

        if (data.size() > 0) {
            double sum = 0.0;
            for (double x : data) {
                sum += 1.0 / x;
            } // for
            result = data.size() / sum;
        } // if
        return result;
    } // harmonicMean( List<Double> )

    /**
     * Calls 4 functions: 1 to generate a random list, and the other 3 to calculate different means.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Hallo!");
        List<Double> values = makeRandomList(12);
        printList(values);

        /*List<Double> values = new ArrayList<>();
        for( int i = 0; i < 12; i++ ) {
            values.add( 0.5 );
        } // for
        */
        
        System.out.println("arithmetic mean = "
                + arithmeticMean(values));
        System.out.println("geometric mean = "
                + geometricMean(values));
        System.out.println("harmonic mean = "
                + harmonicMean(values));

    } // main( String [] )

} // Means

package searchandsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class creates an integer list of fixed size repeatedly, then performs
 * several sorting and searching operations. A new list is generated on the
 * execution of a new sorting algorithm. The sorting and searching algorithms
 * included are sequential search, binary search, selection sort, insertion
 * sort, and merge sort. Code taken from Leon Tabak's GE0 github.
 *
 * @author Leon Tabak, Glenn Richards
 * @version 28 March 2020
 * 
 * Unrelated, but I really enjoyed this. I feel like I learned quite a bit both about
 * javadoc formatting and the relevant sorting algorithms.
 * 
 * Additionally, I cannot get my pushes to appear on github. I have to upload my file manually for now.
 *
 */
public class SearchAndSort {

    private static Random rng = new Random();
    private static final int SIZE_THRESHOLD = 16;

    /**
     * Creates a list of type integer.
     *
     * @param size Determines the size of the randomly generated integer list.
     * @return Returns the generated integer list.
     */
    public static List<Integer> makeList(int size) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int n = 10 + rng.nextInt(90);
            result.add(n);
        } // for

        return result;
    } // makeList( int )

    /**
     * Prints a provided integer list's values in one of two formats.
     *
     * @param values An integer list that will be printed in one of two
     * different formats. If there are less values than the size threshold, then
     * they will be printed vertically. Otherwise, the values will be printed
     * horizontally.
     */
    public static void printList(List<Integer> values) {
        if (values.size() < SIZE_THRESHOLD) {
            for (int n : values) {
                System.out.printf("%4d", n);
            } // for
            System.out.println();
        } // if
        else {
            for (int n : values) {
                System.out.printf("%4d\n", n);
            } // for
        } // else
    } // printList( List<Integer> )

    // TO-DO: Define a method that determines
    // the index of the first integer in a list
    // of integers that matches a given integer.
    // The method should return -1 if no match is found.
    // Use the sequential search algorithm.
    /**
     * Searches sequentially for a given value and returns its index if found.
     *
     * @param values An integer list that will be searched.
     * @param target The value that is being searched for.
     * @return Returns the index of the target value if found. Otherwise,
     * returns -1.
     */
    public static int linearSearch(List<Integer> values,
            int target) {
        int result = -1;

        int index = 0;
        while (index < values.size() && result < 0) {
            if (target == values.get(index)) {
                result = index;
            } // if
            index = index + 1;
        } // while
        return result;
    } // linearSearch( List<Integer>, int )

    // TO-DO: Define a method that determines
    // the index of the first integer in a list
    // of integers that matches a given integer.
    // The method should return -1 if no match is found.
    // Use the binary search algorithm.
    /**
     * Utilizes a binary search for a given value and returns its index if
     * found.
     *
     * @param values An integer list that will be searched.
     * @param target The value that is being searched for.
     * @return Returns the index of the target value if found. Otherwise,
     * returns -1.
     */
    public static int binarySearch(List<Integer> values,
            int target) {
        int result = -1;

        int lo = 0;
        int hi = values.size() - 1;

        while (lo < hi && result < 0) {
            int mid = (lo + hi) / 2;
            if (target == values.get(lo)) {
                result = lo;
            } // if
            else if (target == values.get(mid)) {
                result = mid;
            } // else if
            else if (target == values.get(hi)) {
                result = hi;
            } // else if
            else if (target < values.get(mid)) {
                hi = mid - 1;
            } // else if
            else {
                lo = mid + 1;
            } // else
        } // while

        return result;
    } // binarySearch( List<Integer>, int )

    // TO-DO: Define a method that sorts a list
    // of integers using the selection sort algorithm.
    /**
     * Searches sequentially for a given value and returns its index if found.
     * This method is required for the selection sort algorithm.
     *
     * @param values An integer list that will be searched.
     * @param i One of two numbers that will have their indexes swapped.
     * @param j One of two numbers that will have their indexes swapped.
     */
    public static void swap(List<Integer> values, int i, int j) {
        int temp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, temp);
    } // swap( List<Integer>, int, int )

    /**
     * Attempts to find the minimum integer value in a provided list. This
     * method is required for the selection sort algorithm.
     *
     * @param values An integer list that will be searched.
     * @param start The initial value. Will be replaced with lower values if
     * found.
     * @return The lowest value found in the provided integer list after the
     * starting point.
     */
    public static int findPosMin(List<Integer> values, int start) {
        int bestGuessSoFar = start;
        for (int i = start + 1; i < values.size(); i++) {
            if (values.get(i) < values.get(bestGuessSoFar)) {
                bestGuessSoFar = i;
            } // if
        } // for
        return bestGuessSoFar;
    } // findPosMin( List<Integer>, int )

    /**
     * Performs a selection sort on a given integer list. Selection sort
     * operates semi-sequentially. By that, I mean the provided list is analyzed
     * from the first index, and all other values are compared against it. The
     * lowest of those values (assuming it is less than whatever is in the first
     * index) is swapped with whatever is in the first index. Then the sort
     * continues with index 2, and repeats until the list is sorted.
     *
     * @param values An integer list that will be searched.
     */
    public static void selectionSort(List<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            int j = findPosMin(values, i);
            swap(values, i, j);
        } // for
    } // selectionSort( List<Integer> )

    // TO-DO: Define a method that sorts a list
    // of integers using the insertion sort algorithm.
    /**
     * Swaps two values, repeatedly if necessary. Refer to insertion sort for
     * more detailed explanation.
     *
     * @param values An integer list that will be searched.
     * @param next The index of a value in the integer list.
     */
    public static void insert(List<Integer> values, int next) {

        int i = next;
        while (i > 0 && values.get(i) < values.get(i - 1)) {
            swap(values, i, i - 1);
            i = i - 1;
        } // while

    } // insert( List<Integer>, int )

    /**
     * Searches semi-sequentially for lower values than an index, then swaps
     * them (and other indexes with lower values if they exist). To elaborate,
     * insertion sort starts at the first index. It then compares values in
     * subsequent indexes. If a lower value is found, their indexes are swapped.
     * Upon the second iteration, this process repeats, but with an extra step.
     * Comparisons will then be made with lower indexes and continue to swap if
     * lower values are found. This way, lower values can make their way to
     * lower indexes.
     *
     * @param values An integer list that will be searched.
     */
    public static void insertionSort(List<Integer> values) {
        for (int i = 1; i < values.size(); i++) {
            insert(values, i);
        } // for
    } // insertionSort( List<Integer> )

    // TO-DO: Define a method that sorts a list
    // of integers using the merge sort algorithm.
    /**
     * ADD TEXT
     *
     * @param values An integer list that will be searched.
     * @param prefixStart The beginning of the first "chunk" of the provided
     * list.
     * @param suffixStart The beginning of the second "chunk" of the provided
     * list
     * @param suffixEnd The end of the second "chunk" of the provided list.
     */
    public static void merge(List<Integer> values, int prefixStart,
            int suffixStart, int suffixEnd) {
        List<Integer> temp = new ArrayList<>();
        int i = prefixStart;
        int j = suffixStart;

        while (i < suffixStart && j < suffixEnd) {
            if (values.get(i) < values.get(j)) {
                temp.add(values.get(i));
                i++;
            } // if
            else {
                temp.add(values.get(j));
                j++;
            } // else
        } // while

        while (i < suffixStart) {
            temp.add(values.get(i));
            i++;
        } // while

        while (j < suffixEnd) {
            temp.add(values.get(j));
            j++;
        } // while

        i = prefixStart;
        for (int index = 0; index < temp.size(); index++) {
            values.set(i, temp.get(index));
            i++;
        } // for
    } // merge( List<Integer>, int, int )

    /**
     * Divides a list in half as many times as possible, then sorts the
     * resulting small chunks and starts recombining them until the list is
     * sorted. To elaborate, merge sort splits a list down until it cannot be
     * split anymore. It then compares the resulting chunks in pairs. Say a list
     * of 8 elements is provided. It will be divided into 8 pieces. Pieces 1 and
     * 2 will be compared, then 3 and 4, and so on, resulting in 4 pieces. After
     * comparing, the pieces will be sorted and put together. Then these are
     * treated as pieces and the process will repeat (pieces 1 and 2 will be
     * compared, and then 3 and 4). This process ends when all pieces are put
     * together into a completed and sorted list.
     *
     * @param values An integer list that will be sorted.
     */
    public static void mergeSort(List<Integer> values) {
        for (int stepSize = 2; stepSize < values.size(); stepSize *= 2) {
            for (int i = 0; i < values.size(); i += stepSize) {
                int prefixStart = i;
                int suffixStart = i + stepSize / 2;
                int suffixEnd = Math.min(values.size(), i + stepSize);
                merge(values, prefixStart, suffixStart, suffixEnd);
            } // for
            if (stepSize > values.size() / 2) {
                int prefixStart = 0;
                int suffixStart = stepSize;
                int suffixEnd = values.size();
                merge(values, prefixStart, suffixStart, suffixEnd);
            } // if
            //printList(values);
        } // for
    } // mergeSort( List<Integer> )

    /**
     * Responsible for calling all relevant methods (creating a list and performing sorts on it), 
     * as well as printing before and after each sort.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Searching and sorting algorithms");

        // TO-DO: Add code that tests the searching and sorting
        // methods.
        System.out.println("Selection sort.");
        List<Integer> data = makeList(12);
        printList(data);
        System.out.println(" **** ");
        selectionSort(data);
        printList(data);

        System.out.println(" **** ");

        System.out.println("Insertion sort.");
        data = makeList(12);
        printList(data);
        System.out.println(" **** ");
        insertionSort(data);
        printList(data);

        System.out.println(" **** ");

        System.out.println("Merge sort.");
        data = makeList(12);
        printList(data);
        System.out.println(" **** ");
        mergeSort(data);
        printList(data);
    } // main( String [] )
} // SearchAndSort

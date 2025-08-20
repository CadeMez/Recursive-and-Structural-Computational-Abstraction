package a2;

import java.util.ArrayList;

public class LongMult {

    /**
     * Reads the digits of an unsigned integer value from a string storing the
     * digits in a list. The returned list contains the digits of the integer
     * value in reverse order (i.e., the first digit in the list is the
     * rightmost digit of the value).
     *
     * <p>
     * If {@code value} is the empty string then the list of size 1 containing
     * the digit 0 is returned.
     *
     * @param value the string representation of an integer value
     * @return a list containing the digits of the number stored in reverse
     * order
     * @throws {@code NumberFormatException} if any character of number is not a
     * digit
     */
    public static ArrayList<Integer> fromString(String value) {
        ArrayList<Integer> digits = new ArrayList<>();

        if (value.isEmpty()) {
            digits.add(0);
            return digits;
        }

        for (int i = value.length() - 1; i >= 0; i--) {
            char c = value.charAt(i);
            if (Character.isDigit(c)) {
                int val = c - '0';
                digits.add(val);
            } else {
                throw new NumberFormatException("Character is not a digit: " + c);
            }
        }

        return digits;
    }

    /**
     * Returns a string made up of the digits stored in the specified list.
     *
     * <p>
     * The list stores the digits of the value in reverse order.
     *
     * @param digits a list of digits representing a value in reverse order
     * @return a string made up of the digits stored in the specified list in
     * reverse order
     */
    public static String toString(ArrayList<Integer> digits) {
        String value = "";
        for (Integer digit : digits) {
            value = digit + value;
        }
        return value;
    }

    /**
     * Returns the i'th digit from the right of an integer value where {@code i}
     * is a zero-based index. The digits of the value are stored in reverse
     * order in the list, so this method returns the element at index {@code i}
     * of the list if {@code i} is a valid index.
     *
     * <p>
     * Returns the value {@code 0} if {@code i >= digits.size()} is true.
     *
     * @param digits a list of digits
     * @param i an index
     * @return the i'th digit stored in the list or 0 if
     * {@code i >= digits.size()} is true
     * @throws IllegalArgumentException if {@code i < 0} is true
     */
    public static int getDigit(ArrayList<Integer> digits, int i) {
        if (i >= digits.size()) {
            return 0;
        } else if (i < 0) {
            throw new IllegalArgumentException("Index is negative:" + i);
        } else {
            return digits.get(i);
        }
    }

    /**
     * Computes the sum {@code a + b} where {@code a} and {@code b} are lists
     * storing the digits of two integer values in reverse order.
     *
     * @param a a list of digits in reverse order representing an integer value
     * @param b a list of digits in reverse order representing an integer value
     * @return a list of digits in reverse order representing the sum of a and b
     */
    public static ArrayList<Integer> sum(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> sum = new ArrayList<>();
        int n = Math.max(a.size(), b.size());
        int c = 0; // carry

        for (int i = 0; i < n; i++) {
            int v = getDigit(a, i) + getDigit(b, i) + c;
            c = v / 10;
            sum.add(v % 10);
        }

        while (c > 0) {
            sum.add(c % 10);
            c = c / 10;
        }

        return sum;
    }

    /**
     * Multiplies the integer value represented by the list {@code digits} by a
     * digit returning a list representing the resulting product.
     *
     * <p>
     * The returned list contains the digits of the product in reverse order.
     *
     * @param a the digits of an integer value stored in reverse order
     * @param d a digit (value between 0 and 9)
     * @return a list representing the resulting product (where the digits of
     * the product are stored in reverse order)
     */
    public static ArrayList<Integer> multiplyDigit(ArrayList<Integer> a, int d) {
        ArrayList<Integer> product = new ArrayList<>();
        int c = 0; // carry

        for (int i = 0; i < a.size(); i++) {
            int v = (getDigit(a, i) * d) + c;
            c = v / 10;
            product.add(v % 10);
        }

        if (c > 0) {
            product.add(c);
        }

        return product;
    }

    /**
     * Multiplies the integer value represented by the list {@code a} by the
     * integer value represented by the list {@code b} returning a list
     * representing the resulting product.
     *
     * <p>
     * The lists {@code a}, {@code b}, and the returned list contain the digits
     * of their integer values in reverse order.
     *
     * @param a the digits of an integer value stored in reverse order
     * @param b the digits of an integer value stored in reverse order
     * @return a list representing the resulting product (where the digits of
     * the product are stored in reverse order)
     */
    public static ArrayList<Integer> multiply(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();
        int j = 1;

        for (int i = 0; i < b.size(); i++) {
            ArrayList<Integer> product = multiplyDigit(a, getDigit(b, i) * j);
            result = sum(result, product);
            j = j * 10;
        }

        return result;
    }

    /**
     * Multiplies the integer values represented by the strings {@code sa} and
     * {@code sb} returning the product as a string.
     *
     * @param sa the string representation of an integer value
     * @param sb the string representation of an integer value
     * @return the string representation of the product of {@code sa * sb}
     */
    public static String multiply(String sa, String sb) {
        return toString(multiply(fromString(sa), fromString(sb)));
    }

}

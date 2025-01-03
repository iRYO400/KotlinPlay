import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>(2);
        result.add(0);
        result.add(0);

        for (int i = 0; i < a.size(); i++) {
            int check = compare(a.get(i), b.get(i));
            if (check == -1) {
                result.set(0, result.get(0) + 1);
            } else if (check == 1) {
                result.set(1, result.get(1) + 1);
            }
        }

        return result;
    }

    private static int compare(int i, int j) {
        if (i < j) {
            return -1;
        } else if (i > j) {
            return 1;
        }

        return 0;
    }
}

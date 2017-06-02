import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

/* Telephonic Round : Powerset question
| -- | -----------------------------|
| ID | Purchased items              |
| -- | -----------------------------|
| 1  | apple,banana,lemon         |
| 2  | banana,berry,lemon,orange |
| 3  | banana,berry,lemon         |
| -- | -----------------------------|
[OUTPUT] frequency counts of all possible item-sets. Note: some
outputs are omitted for brevity.
| ---------------------------- | --------- |
| Itemset                      | Frequency |
| ---------------------------- | --------- |
| apple,banana                | 1         |
| apple,lemon                 | 1         |
| banana,berry                | 2         |
| banana,lemon                | 3         |
| ...                                      |
| apple,banana,lemon         | 1         |
| banana,berry,lemon         | 2         |
| ...                                      |
| banana,berry,lemon,orange | 1         |
| ...                                      |
| ---------------------------- | --------- |

*/

public class Solution {
    public static void main(String[] args) {
        result = new TreeMap<>();
        solution(new String[] { "apple","banana","lemon" });
        solution(new String[] { "banana","berry","lemon","orange" });
        solution(new String[] { "banana","berry","lemon" });
        result.forEach((k,v) -> System.out.println(k + " : " + v));

        assert result.get("[apple,banana]") == 1;
        assert result.get("[apple,lemon]") == 1;
        assert result.get("[banana,berry]") == 2;
        assert result.get("[banana,lemon]") == 3;
        assert result.get("[apple,banana,lemon]") == 1;
        assert result.get("[banana,berry,lemon]") == 2;
        assert result.get("[banana,berry,lemon,orange]") == 1;
        

        result = new TreeMap<>();
        solution(new Integer[] { 1,2,3 });
        result.forEach((k,v) -> System.out.println(k));
    }

    public static <E> void solution(E[] inputArray) {
        int[] temp = new int[inputArray.length];
        Arrays.fill(temp,0);
        combination(inputArray,temp,0,temp.length - 1);
    }

    private static <E> void combination(E elements[],int accumulator[],int k,int N) {
        if (k == N) {
            accumulator[k] = 0;
            print(elements,accumulator,N);
            accumulator[k] = 1;
            print(elements,accumulator,N);
            return;
        }
        accumulator[k] = 0;
        combination(elements,accumulator,k + 1,N);
        accumulator[k] = 1;
        combination(elements,accumulator,k + 1,N);
    }
    private static Map<String,Long> result;

    private static <E> void print(E elements[],int A[],int N) {
        StringJoiner sj = new StringJoiner(",","[","]");
        for (int i = 0; i <= N; i++) {
            if (A[i] == 1) {
                sj.add(elements[i] + "");
            }
        }
        result.compute(sj.toString(),(k,v) -> v == null ? 1 : v + 1);
    }
}

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PowerSet {
    public static void main(String[] args) {
            int[] arr = { 1,2, 3 };
            BitSet bset = new BitSet(arr.length + 1);
            Set result = new HashSet();
            while (!bset.get(arr.length)) {
                Set subSet = new TreeSet();
                for (int i = 0; i < arr.length; i++) {
                    if (bset.get(i)) {
                        subSet.add(arr[i]);
                    }
                }
                for (int i = 0; i < bset.size(); i++) {
                    if (!bset.get(i)) {
                        bset.set(i);
                        break;
                    } else
                        bset.clear(i);
                }
                result.add(subSet);
            }            
           System.out.println(result);
        }
}

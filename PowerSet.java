import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PowerSet {
    public static void main(String[] args) {
        main();
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
    
    //another version for only int datatype
    private static void printPowerset(int n) {
        int stack[] = new int[n + 1], k;
        stack[0] = 0;
        k = 0;
        while (true) {
            System.out.println();
            if (stack[k] < n) {
                stack[k + 1] = stack[k] + 1;
                k++;
            } else {
                stack[k - 1]++;
                k--;
            }
            if (k == 0)
                break;
            for (int i = 1; i <= k; i++)
                System.out.print(stack[i] + " ");
        }
    }
    private static Set getSubsetUsingBitMap(List list) {
        Set result = new HashSet();
        int numOfSubsets = 1 << list.size();
        for (int i = 0; i < numOfSubsets; i++) {
            Set subset = new HashSet();
            int mask = 1;
            for (int k = 0; k < list.size(); k++) {
                if ((mask & i) != 0)
                    subset.add(list.get(k));
                mask = mask << 1;
            }
            result.add(subset);
        }
        return result;
    }

    private static List<String> createSubsetUsingTree(List list) {
        List result = new ArrayList();
        result.add("");
        for (int i = 0; i < list.size(); i++) {
            List tempList = new ArrayList();
            Iterator<String> iter = result.iterator();
            while (iter.hasNext()) {
                String val = iter.next();
                if (val.equals(""))
                    tempList.add(list.get(i));
                else
                    tempList.add(val + list.get(i));
            }
            result.addAll(tempList);
        }
        return result;
    }
    public static void main() {
        List list = Arrays.asList("a", "b", "c");
        System.out.println(getSubsetUsingBitMap(list));
        System.out.println(createSubsetUsingTree(list));
        printPowerset(3);
    }
}

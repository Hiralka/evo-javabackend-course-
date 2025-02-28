
package arrayscycles;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;

/**
 *
 * @author hiraru
 */
public class ArraysCycles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = (random.nextInt(15)+1);
        }
        System.out.println(Arrays.toString(array));
        //подсчет
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        for (HashMap.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.printf("Число '%d' встречается %d раза%n", entry.getKey(), entry.getValue());
            } 
        }
    }
}

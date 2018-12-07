import java.util.Arrays;
import java.util.List;

public class ArrContainsArr {
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c"};
        String[] arr2 = {"a"};

        List list1 = Arrays.asList(arr1);
        List list2 = Arrays.asList(arr2);
        System.out.println(list1.containsAll(list2));
    }
}

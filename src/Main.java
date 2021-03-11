import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Main {

    public static void main(String[] args) {
        List<Object> test =
                new ArrayList<Object>(
                        Arrays.asList(5, 2,
                                new ArrayList<Object>(Arrays.asList(7, -1)),
                                3,
                                new ArrayList<Object>(Arrays.asList(6,
                                        new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        ProductSum.productSum(test);
    }
}


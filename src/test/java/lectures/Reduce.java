package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;

public class Reduce {

  @Test
  public void reduce() throws Exception {
    Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

      Optional<Integer> sum = Arrays.stream(integers)
              .reduce((a, b) -> a + b);
      System.out.println(sum);

      Integer sum2 = Arrays.stream(integers)
              .reduce(0,Integer::sum);
      System.out.println(sum2);

  }


}


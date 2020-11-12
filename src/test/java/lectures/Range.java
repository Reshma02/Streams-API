package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Range {

  @Test
  public void range() throws Exception {


      for (int i = 0; i <=10 ; i++) {
          System.out.println(i);
      }


      System.out.println("exclusive");





      IntStream.range(0,10)
            .forEach(index -> System.out.println(index));
      System.out.println("inclusive");

    IntStream.rangeClosed(0,10)
    .forEach(System.out::println);

  }










  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    IntStream.rangeClosed(0,people.size())
            .forEach(index -> {
                Person person = people.get(index);
               System.out.println(person);
            });
  }

  @Test
  public void intStreamIterate() throws Exception {
      IntStream.iterate(0, operand -> operand + 1)
              .filter(n -> n%2 == 0)
          .limit(20)
          .forEach(System.out::println);
  }
}

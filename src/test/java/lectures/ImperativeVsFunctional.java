package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class ImperativeVsFunctional {

  @Test
  public void imperativeApproach() throws IOException {
      // 1. Find people aged less or equal 18
      // 2. Then change implementation to find first 10 people
    List<Person> people = MockData.getPeople();
    List<Person> ageLessThan18 = new ArrayList<>();
      int count = 0;
      for(Person ppl:people){
          if(ppl.getAge()<=18){
              if(count<10) {
                  ageLessThan18.add(ppl);
                  System.out.println(ppl.getAge());
              }
              count++;
          }
      }
     // System.out.println(ageLessThan18);
  }








  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();
      List<Person> collect = people.stream()
              .filter(ppl -> ppl.getAge() < 18)
              .limit(10)
              .collect(Collectors.toList());

      collect.forEach(System.out::println);

  }
}

package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Filtering {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

      Predicate<Car> carPredicate = car -> car.getPrice() < 10000;

      List<Car> filteredCars = cars.stream()
              .filter(carPredicate)
              .collect(Collectors.toList());
      filteredCars.forEach(System.out::println);
      System.out.println(filteredCars.size());

  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

//      List<PersonDTO> collect = people.stream()
//              .map(person -> {
//                  PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//                  return dto;
//              })
//              .collect(Collectors.toList());


      Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());

//      List<PersonDTO> collect = people.stream()
//              .map(personPersonDTOFunction)
//              .collect(Collectors.toList());

      List<PersonDTO> collect = people.stream()
              .map(PersonDTO::map)
              .collect(Collectors.toList());

      System.out.println(collect.size());
      collect.forEach(System.out::println);


  }

  @Test
  public void averageCarPrice() throws Exception {
      List<Car> cars = MockData.getCars();
//      double asDouble = cars.stream()
//              .mapToDouble(car -> car.getPrice())
//              .average()
//              .getAsDouble();

     // List<Car> cars = MockData.getCars();
      double asDouble = cars.stream()
              .mapToDouble(Car::getPrice)
              .average()
              .orElse(0);
      System.out.println(asDouble);

  }

  @Test
  public void test() throws Exception {

  }
}




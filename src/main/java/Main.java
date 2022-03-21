import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();
        City city = new City();

        var nodes = IntStream.rangeClosed(0, 3)
                .mapToObj(index -> new Intersection(faker.address().city()))
                .toArray(Intersection[]::new);
        List<Intersection> nodeList = new ArrayList<>(Arrays.asList(nodes));

        var streets = IntStream.rangeClosed(0,8)
                .mapToObj(index -> new Street(faker.address().streetName(), index % 3))
                .toArray(Street[]::new);
        List<Street> streetList = new LinkedList<>(Arrays.asList(streets));

        // sorted list of intersections by name
        List<Intersection> newSortedList = nodeList.stream()
                .sorted(Comparator.comparing(Intersection::getName)).toList();

        // sorted list of streets by length
        List<Street> sortedStreets = streetList.stream()
                .sorted(Comparator.comparing(Street::getLength)).toList();

        Set<Intersection> intersectionSet = new HashSet<>(Arrays.asList(nodes));

        Map<Intersection, List<Street>> cityMap = new HashMap<>();
        cityMap.put(nodes[0], Arrays.asList(streets));
        System.out.println(cityMap.get(nodes[0]).toString());

        System.out.println(isDuplicateInIntersections(intersectionSet));
        System.out.println(getStreetsLongerThan(streetList, 1).toString());

    }

    /**
     * Verify that a {@link Set} does not contain duplicates
     * @param intersections given set for check
     * @return true if given set does not contain duplicates, false otherwise
     */
    public static boolean isDuplicateInIntersections(Set<Intersection> intersections){
        return !(intersections.stream().distinct().toList().size() == intersections.size());
    }

    /**
     * Get a list of streets longer than a specified value
     * @param streets {@link List} of {@link Street} that has to be filtered
     * @param length minimum value
     * @return a list of streets longer than a given value
     */
    public static List<Street> getStreetsLongerThan (List<Street> streets, Integer length){
        return streets.stream()
                .filter(street -> street.getLength() > length)
                .collect(Collectors.toList());
    }

}

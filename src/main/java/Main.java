import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var nodes = IntStream.rangeClosed(0, 3)
                .mapToObj(index -> new Intersection("v" + index))
                .toArray(Intersection[]::new);
        List<Intersection> nodeList = new ArrayList<>(Arrays.asList(nodes));

        var streets = IntStream.rangeClosed(0,8)
                .mapToObj(index -> new Street("e" + index, index % 3))
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

    }


}

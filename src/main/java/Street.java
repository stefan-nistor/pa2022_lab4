import java.util.AbstractMap;

public class Street implements Comparable<Street>{
    private String name;
    private Integer length;

    AbstractMap.SimpleEntry<Intersection, Intersection> intersectionPair;

    public Street(String name){
        this.name = name;
    }

    public Street(String name, Integer length){
        this.name = name;
        this.length = length;
    }

    public void setIntersectionPair(AbstractMap.SimpleEntry<Intersection, Intersection> intersectionPair) {
        this.intersectionPair = intersectionPair;
    }

    public AbstractMap.SimpleEntry<Intersection, Intersection> getIntersectionPair() {
        return intersectionPair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public int compareTo(Street o) {
        return this.length.compareTo(o.length);
    }
}

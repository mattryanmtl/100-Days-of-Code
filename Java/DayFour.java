import java. util.stream.IntStream;
import java. util.stream.Collectors;
import java. util.Map;

public class  DayFour {
    private static final int BASESIZE = 2;
    public static void main(String[] args) {
        String s = "546678765434228976";
        IntStream.range(BASESIZE, s.length() - 1).boxed()
          .map (k->
            IntStream.rangeClosed(0, s.length()-k).mapToObj(j->Map.entry(j, j+k))
              .collect(Collectors.groupingBy(p->s.substring(p.getKey(), p.getValue()), Collectors.counting()))
              .entrySet().stream().filter(e->e.getValue() >= 2)
              .collect(Collectors.toList())
          )
        .takeWhile(x -> !x.isEmpty())
        .forEach(y -> y.forEach(System.out::println));
    }
}

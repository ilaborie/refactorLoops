package io.github.ilaborie.loops.samples.stream;

import io.github.ilaborie.loops.samples.Element;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class Nest {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        List<String> result = nest(elements);
        result.forEach(System.out::println);
    }

    public static List<String> nest(List<Element> elements) {
        class PairElement {
            private final Element element1;
            private final Element element2;

            PairElement(Element element1, Element element2) {
                this.element1 = element1;
                this.element2 = element2;
            }
        }

        return elements.stream()
                .flatMap(elt1 -> elements.stream()
                        .map(elt2 -> new PairElement(elt1, elt2)))
                .filter(pair -> {
                    String name1 = pair.element1.getName();
                    String name2 = pair.element2.getName();
                    return !Objects.equals(name1, name2) &&
                            (name1.length() == name2.length());
                })
                .map(pair -> {
                    String name1 = pair.element1.getName();
                    String name2 = pair.element2.getName();
                    return String.join("-", name1, name2);
                })
                .collect(Collectors.toList());
    }


    public static List<String> nestAlt(List<Element> elements) {
        class PairElement {
            private final Element element1;
            private final Element element2;

            PairElement(Element element1, Element element2) {
                this.element1 = element1;
                this.element2 = element2;
            }
        }

        Predicate<PairElement> isSame = pair ->
                Objects.equals(pair.element1.getName(), pair.element2.getName());

        Predicate<PairElement> hasSameSize = pair ->
                pair.element1.getName().length() == pair.element2.getName().length();

        Function<PairElement, String> joinName = pair -> {
            String name1 = pair.element1.getName();
            String name2 = pair.element2.getName();
            return String.join("-", name1, name2);
        };

        return elements.stream()
                .flatMap(elt1 -> elements.stream()
                        .map(elt2 -> new PairElement(elt1, elt2)))
                .filter(isSame.negate().and(hasSameSize))
                .map(joinName)
                .collect(Collectors.toList());
    }

}

package io.github.ilaborie.loops.samples.montecarlo;

import java.text.NumberFormat;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static io.github.ilaborie.loops.samples.montecarlo.Point.compute;
import static io.github.ilaborie.loops.samples.montecarlo.Point.newPoint;

public final class MonteCarlo {

    private MonteCarlo() {
        throw new AssertionError("private");
    }

    public static void main(String[] args) {
        NumberFormat format = NumberFormat.getIntegerInstance();
        IntStream.rangeClosed(2, 10)
                .map(e -> (int) Math.pow(10, e))
                .peek(count -> System.out.printf("Compute with %s ...%n", format.format(count)))
                .mapToDouble(MonteCarlo::monteCarloStream)
                .forEach(pi -> System.out.println("Result: " + pi));
    }

    // For Loop
    public static double monteCarloFor(int count) {
        int inCircle = 0;
        for (int i = 0; i < count; i++) {
            Point p = newPoint();

            if (p.inCircle()) {
                inCircle++;
            }
        }
        return compute(count, inCircle);
    }

    // Recursion
    public static double monteCarloRecursion(int count) {
        int inCircle = monteCarloRecursionAux(count, 0);
        return compute(count, inCircle);
    }

    private static int monteCarloRecursionAux(int count, int inCircle) {
        if (count == 0) {
            return inCircle;
        }
        Point p = newPoint();

        if (p.inCircle()) {
            return monteCarloRecursionAux(count - 1, inCircle + 1);
        } else {
            return monteCarloRecursionAux(count - 1, inCircle);
        }
    }

    // Stream
    public static double monteCarloStream(int count) {
        int inCircle = (int) Stream.generate(Point::newPoint)
                .limit(count)
                .filter(Point::inCircle)
                .count();

        return compute(count, inCircle);
    }


    public static double monteCarloStreamParallel(int count) {
        int inCircle = (int) Stream.generate(Point::newPoint)
                .unordered()
                .parallel()
                .limit(count)
                .filter(Point::inCircle)
                .count();

        return compute(count, inCircle);
    }


    public static double monteCarloStreamParallel2(int count) {
        int inCircle = (int) Stream.generate(Point::newPoint2)
                .unordered()
                .parallel()
                .limit(count)
                .filter(Point::inCircle)
                .count();

        return compute(count, inCircle);
    }


}

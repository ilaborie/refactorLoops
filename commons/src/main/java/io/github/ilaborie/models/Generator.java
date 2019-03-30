package io.github.ilaborie.models;

import com.github.javafaker.Faker;

import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

public final class Generator {
    private static final Faker faker = new Faker();


    private Generator() {
        throw new AssertionError("private");
    }

    private static Speaker generateSpeaker() {
        Speaker result = new Speaker();
        result.setFirstName(faker.name().firstName());
        result.setLastName(faker.name().lastName());
        int size = faker.number().numberBetween(1, 3);
        Set<ProgrammingLanguage> langs = IntStream.range(0, size)
                .mapToObj(i -> faker.options().option(ProgrammingLanguage.class))
                .collect(toSet());
        result.setPreferredLanguages(langs);
        return result;
    }

    private static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }


    public static Talk generateTalk() {
        Talk result = new Talk();
        result.setDescription(faker.lorem().paragraph());

        int speakerSize = faker.number().numberBetween(1, 2);
        Set<Speaker> speakers = IntStream.range(0, speakerSize)
                .mapToObj(i -> generateSpeaker())
                .collect(toSet());
        result.setSpeakers(speakers);

        int langSize = faker.number().numberBetween(1, 2);
        Set<ProgrammingLanguage> langs = IntStream.range(0, langSize)
                .mapToObj(i -> faker.options().option(ProgrammingLanguage.class))
                .collect(toSet());
        result.setLanguages(langs);

        String adjective = capitalize(faker.hacker().adjective());
        String noun = faker.hacker().noun();
        String verb = faker.hacker().verb();
        String lgs = langs.stream().map(Enum::name).collect(joining(" & "));
        String title = String.format("%s %s %s with %s", adjective, noun, verb, lgs);
        result.setTitle(title);

        return result;
    }
}

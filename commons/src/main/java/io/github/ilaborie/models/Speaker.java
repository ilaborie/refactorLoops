package io.github.ilaborie.models;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Speaker {

    private String firstName;
    private String lastName;
    private Set<ProgrammingLanguage> preferredLanguages;

    @Override
    public String toString() {
        return String.format("Speaker{firstName='%s', lastName='%s', preferredLanguages=%s}", firstName, lastName, preferredLanguages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speaker speaker = (Speaker) o;
        return Objects.equals(firstName, speaker.firstName) &&
                Objects.equals(lastName, speaker.lastName) &&
                Objects.equals(preferredLanguages, speaker.preferredLanguages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, preferredLanguages);
    }

    public String getFirstName() {
        return firstName;
    }

    public Speaker setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Speaker setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<ProgrammingLanguage> getPreferredLanguages() {
        return preferredLanguages;
    }

    public Speaker setPreferredLanguages(Set<ProgrammingLanguage> preferredLanguages) {
        this.preferredLanguages = preferredLanguages;
        return this;
    }

    public Speaker setPrefLanguages(ProgrammingLanguage lang1, ProgrammingLanguage... langs) {
        this.preferredLanguages = Stream.concat(
                Stream.of(lang1),
                Arrays.stream(langs)
        ).collect(Collectors.toSet());
        return this;
    }
}

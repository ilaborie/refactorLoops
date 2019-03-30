package io.github.ilaborie.models;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Talk {

    private String title;
    private String description;
    private Set<ProgrammingLanguage> languages;
    private Set<Speaker> speakers;

    public Talk() {
    }

    public Talk(String title, String description, Set<ProgrammingLanguage> languages, Set<Speaker> speakers) {
        this();
        this.title = title;
        this.description = description;
        this.languages = languages;
        this.speakers = speakers;
    }

    @Override
    public String toString() {
        return String.format("Talk{title='%s', description='%s', languages=%s, speakers=%s}", title, description, languages, speakers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Talk talk = (Talk) o;
        return Objects.equals(title, talk.title) &&
                Objects.equals(description, talk.description) &&
                Objects.equals(languages, talk.languages) &&
                Objects.equals(speakers, talk.speakers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, languages, speakers);
    }

    public String getTitle() {
        return title;
    }

    public Talk setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Talk setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<ProgrammingLanguage> getLanguages() {
        return languages;
    }

    public Talk setLanguages(Set<ProgrammingLanguage> languages) {
        this.languages = languages;
        return this;
    }

    public Talk setLanguages(ProgrammingLanguage lang1, ProgrammingLanguage... langs) {
        this.languages = Stream.concat(
                Stream.of(lang1),
                Arrays.stream(langs)
        ).collect(Collectors.toSet());
        return this;
    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public Talk setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
        return this;
    }

    public Talk setSpeakers(Speaker speaker1, Speaker... speakers) {
        this.speakers = Stream.concat(
                Stream.of(speaker1),
                Arrays.stream(speakers)
        ).collect(Collectors.toSet());
        return this;
    }
}

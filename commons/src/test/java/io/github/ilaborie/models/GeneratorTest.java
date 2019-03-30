package io.github.ilaborie.models;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class GeneratorTest {

    @Test
    public void testGenerateTalk() {
        Talk talk = Generator.generateTalk();

        assertNotNull(talk);
        assertNotNull(talk.getTitle());
        assertNotNull(talk.getDescription());
        assertNotNull(talk.getLanguages());
        assertNotEquals(0, talk.getLanguages().size());
        assertNotNull(talk.getSpeakers());
        assertNotEquals(0, talk.getSpeakers().size());

        talk.getSpeakers().forEach(speaker -> {
            assertNotNull(speaker.getFirstName());
            assertNotNull(speaker.getLastName());
            assertNotNull(speaker.getPreferredLanguages());
        });
    }
}
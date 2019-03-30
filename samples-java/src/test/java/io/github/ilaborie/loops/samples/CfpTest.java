package io.github.ilaborie.loops.samples;

import io.github.ilaborie.loops.samples.cfp.Cfp;
import io.github.ilaborie.models.Speaker;
import io.github.ilaborie.models.Talk;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

import static io.github.ilaborie.models.ProgrammingLanguage.*;
import static org.junit.Assert.assertTrue;

public class CfpTest {

    private Speaker javaGuy = new Speaker()
            .setPrefLanguages(Java);

    private Speaker rubyMan = new Speaker()
            .setPrefLanguages(Ruby);

    private Speaker alien = new Speaker()
            .setPrefLanguages(Prolog);

    private Speaker jvmGuy = new Speaker()
            .setPrefLanguages(Java, Scala, Kotlin, Groovy, Clojure);

    private Talk talk1 = new Talk()
            .setTitle("1")
            .setLanguages(Rust, Scala)
            .setSpeakers(javaGuy, rubyMan);

    private Talk talk2 = new Talk()
            .setTitle("2")
            .setLanguages(Kotlin, Scala)
            .setSpeakers(jvmGuy, alien);

    private Talk talk3 = new Talk()
            .setTitle("3")
            .setLanguages(Java)
            .setSpeakers(javaGuy, jvmGuy);

    private List<Talk> talks = Arrays.asList(talk1, talk2, talk3);

    private void testFilterTalkLangWithAtLeastASpeakerHasLang(UnaryOperator<Iterable<Talk>> func) {
        Iterable<Talk> talks = func.apply(this.talks);
        List<String> expected = Arrays.asList("2", "3");
        talks.forEach(talk -> assertTrue(expected.contains(talk.getTitle())));
    }

    private void testFilterTalkLangWithAllSpeakersHasLang(UnaryOperator<Iterable<Talk>> func) {
        Iterable<Talk> talks = func.apply(this.talks);
        List<String> expected = Collections.singletonList("3");
        talks.forEach(talk -> assertTrue(expected.contains(talk.getTitle())));
    }

    @Test
    public void for_at_least_case() {
        testFilterTalkLangWithAtLeastASpeakerHasLang(Cfp::filterTalkLangWithAtLeastASpeakerHasLangFor);
    }

    @Test
    public void stream_at_least_case() {
        testFilterTalkLangWithAtLeastASpeakerHasLang(Cfp::filterTalkLangWithAtLeastASpeakerHasLang);
    }

    @Test
    public void for_all_case() {
        testFilterTalkLangWithAllSpeakersHasLang(Cfp::filterTalkLangWithAllSpeakersHasLangFor);
    }

    @Test
    public void stream_all_case() {
        testFilterTalkLangWithAllSpeakersHasLang(Cfp::filterTalkLangWithAllSpeakersHasLang);
    }

}

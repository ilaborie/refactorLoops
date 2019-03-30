package io.github.ilaborie.loops.samples.stream

import io.github.ilaborie.loops.samples.cfp.CfpKt
import io.github.ilaborie.models.ProgrammingLanguage.*
import io.github.ilaborie.models.Speaker
import io.github.ilaborie.models.Talk
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.*

class CfpTest {

    private val javaGuy = Speaker()
        .setPrefLanguages(Java)

    private val rubyMan = Speaker()
        .setPrefLanguages(Ruby)

    private val alien = Speaker()
        .setPrefLanguages(Prolog)

    private val jvmGuy = Speaker()
        .setPrefLanguages(Java, Scala, Kotlin, Groovy, Clojure)

    private val talk1 = Talk()
        .setTitle("1")
        .setLanguages(Rust, Scala)
        .setSpeakers(javaGuy, rubyMan)

    private val talk2 = Talk()
        .setTitle("2")
        .setLanguages(Kotlin, Scala)
        .setSpeakers(jvmGuy, alien)

    private val talk3 = Talk()
        .setTitle("3")
        .setLanguages(Java)
        .setSpeakers(javaGuy, jvmGuy)

    private val talks = Arrays.asList(talk1, talk2, talk3)

    private fun testFilterTalkLangWithAtLeastASpeakerHasLang(func: (Iterable<Talk>) -> Iterable<Talk>) {
        val talks = func(this.talks)
        val expected = listOf("2", "3")
        talks.forEach { talk -> assertTrue(expected.contains(talk.title)) }
    }

    private fun testFilterTalkLangWithAllSpeakersHasLang(func: (Iterable<Talk>) -> Iterable<Talk>) {
        val talks = func(this.talks)
        val expected = listOf("3")
        talks.forEach { talk -> assertTrue(expected.contains(talk.title)) }
    }

    @Test
    fun for_at_least_case() {
        testFilterTalkLangWithAtLeastASpeakerHasLang(CfpKt::filterTalkLangWithAtLeastASpeakerHasLangFor)
    }

    @Test
    fun stream_at_least_case() {
        testFilterTalkLangWithAtLeastASpeakerHasLang(CfpKt::filterTalkLangWithAtLeastASpeakerHasLang)
    }

    @Test
    fun for_all_case() {
        testFilterTalkLangWithAllSpeakersHasLang(CfpKt::filterTalkLangWithAllSpeakersHasLangFor)
    }

    @Test
    fun stream_all_case() {
        testFilterTalkLangWithAllSpeakersHasLang(CfpKt::filterTalkLangWithAllSpeakersHasLang)
    }

}

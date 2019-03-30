package io.github.ilaborie.loops.samples

import java.lang.Iterable
import java.util

import io.github.ilaborie.loops.samples.cfp.CfpScala
import io.github.ilaborie.loops.samples.cfp.CfpScala.{SpeakerScala, TalkScala}
import io.github.ilaborie.models.ProgrammingLanguage._
import io.github.ilaborie.models.{Speaker, Talk => JTalk}
import org.junit.Assert.assertTrue
import org.junit.Test

import scala.collection.immutable.Seq
import scala.collection.JavaConverters._

class CfpScalaTest {

  private val javaGuy = new Speaker()
    .setPrefLanguages(Java)

  private val rubyMan = new Speaker()
    .setPrefLanguages(Ruby)

  private val alien = new Speaker()
    .setPrefLanguages(Prolog)

  private val jvmGuy = new Speaker()
    .setPrefLanguages(Java, Scala, Kotlin, Groovy, Clojure)

  private val talk1 = new JTalk()
    .setTitle("1")
    .setLanguages(Rust, Scala)
    .setSpeakers(javaGuy, rubyMan)

  private val talk2 = new JTalk()
    .setTitle("2")
    .setLanguages(Kotlin, Scala)
    .setSpeakers(jvmGuy, alien)

  private val talk3 = new JTalk()
    .setTitle("3")
    .setLanguages(Java)
    .setSpeakers(javaGuy, jvmGuy)

  private val talks: Iterable[JTalk] = util.Arrays.asList(talk1, talk2, talk3)

  private val talksSeq = Seq(talk1, talk2, talk3)
    .map { jTalk =>
      val speakers = jTalk.getSpeakers
        .asScala
        .map(s => SpeakerScala(s.getFirstName, s.getLastName, s.getPreferredLanguages.asScala.to[Set]))
        .to[Set]

      CfpScala.TalkScala(jTalk.getTitle, jTalk.getDescription, jTalk.getLanguages.asScala.toSet, speakers)
    }

  private def testFilterTalkLangWithAtLeastASpeakerHasLang(func: Iterable[JTalk] => Iterable[JTalk]) {
    val talks = func(this.talks)
    val expected = List("2", "3")
    talks.forEach(talk => assertTrue(expected.contains(talk.getTitle)))
  }

  private def testFilterTalkLangWithAllSpeakersHasLang(func: Iterable[JTalk] => Iterable[JTalk]) {
    val talks = func(this.talks)
    val expected = List("3")
    talks.forEach(talk => assertTrue(expected.contains(talk.getTitle)))
  }

  private def testSeqFilterTalkLangWithAtLeastASpeakerHasLang(func: Seq[TalkScala] => Seq[TalkScala]) {
    val talks = func(talksSeq)
    val expected = List("2", "3")
    talks.foreach { talk => assertTrue(expected.contains(talk.title)) }
  }

  private def testSeqFilterTalkLangWithAllSpeakersHasLang(func: Seq[TalkScala] => Seq[TalkScala]) {
    val talks = func(talksSeq)
    val expected = List("3")
    talks.foreach { talk => assertTrue(expected.contains(talk.title)) }
  }

  @Test
  def jStream_at_least_case() {
    testFilterTalkLangWithAtLeastASpeakerHasLang(CfpScala.jFilterTalkLangWithAtLeastASpeakerHasLang)
  }

  @Test
  def jStream_all_case() {
    testFilterTalkLangWithAllSpeakersHasLang(CfpScala.jFilterTalkLangWithAllSpeakersHasLang)
  }

  @Test
  def stream_at_least_case() {
    testSeqFilterTalkLangWithAtLeastASpeakerHasLang(CfpScala.filterTalkLangWithAtLeastASpeakerHasLang)
  }

  @Test
  def stream_all_case() {
    testSeqFilterTalkLangWithAllSpeakersHasLang(CfpScala.filterTalkLangWithAllSpeakersHasLang)
  }


}

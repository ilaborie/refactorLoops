package io.github.ilaborie.loops.samples.cfp

import java.lang.Iterable

import io.github.ilaborie.models.{Generator, ProgrammingLanguage, Talk}

import scala.collection.JavaConverters._
import scala.collection.immutable.{Seq, Set}
import scala.collection.mutable.{Set => MSet}

object CfpScala {

  case class TalkScala(title: String,
                       description: String,
                       languages: Set[ProgrammingLanguage],
                       speakers: Set[SpeakerScala])

  case class SpeakerScala(firstName: String,
                          lastName: String,
                          prefLanguages: Set[ProgrammingLanguage])


  private def createTalk(jTalk: Talk): TalkScala = {
    val speakers = jTalk.getSpeakers.asScala
      .map { s =>
        SpeakerScala(
          firstName = s.getFirstName,
          lastName = s.getLastName,
          prefLanguages = s.getPreferredLanguages.asScala.to[Set])
      }
      .to[Set]

    TalkScala(title = jTalk.getTitle,
      description = jTalk.getDescription,
      languages = jTalk.getLanguages.asScala.to[Set],
      speakers = speakers)
  }

  def generateTalk(): TalkScala =
    createTalk(Generator.generateTalk())

  def jFilterTalkLangWithAtLeastASpeakerHasLang(talks: Iterable[Talk]): Iterable[Talk] =
    talks
      .asScala
      .filter { talk =>
        val speakerLangs = talk.getSpeakers.asScala
          .flatMap(_.getPreferredLanguages.asScala)

        speakerLangs.nonEmpty && talk.getLanguages.containsAll(speakerLangs.asJava)
      }
      .asJava

  def jFilterTalkLangWithAllSpeakersHasLang(talks: Iterable[Talk]): Iterable[Talk] =
    talks
      .asScala
      .filter { talk =>
        val speakerLangs = talk.getSpeakers.asScala
          .map(_.getPreferredLanguages.asScala)
          .reduce[MSet[ProgrammingLanguage]] {
          case (acc, langs) => acc.intersect(langs)
        }

        speakerLangs.nonEmpty && talk.getLanguages.containsAll(speakerLangs.asJava)
      }
      .asJava

  def filterTalkLangWithAtLeastASpeakerHasLang(talks: Seq[TalkScala]): Seq[TalkScala] =
    talks
      .filter { talk =>
        val speakerLangs = talk.speakers
          .flatMap(_.prefLanguages)

        talk.languages forall speakerLangs.contains
      }

  def filterTalkLangWithAllSpeakersHasLang(talks: Seq[TalkScala]): Seq[TalkScala] =
    talks
      .filter { talk =>
        val speakerLangs: Set[ProgrammingLanguage] = talk.speakers
          .map(_.prefLanguages)
          .reduce[Set[ProgrammingLanguage]] {
          case (acc, langs) => acc.intersect(langs)
        }
        talk.languages forall speakerLangs.contains
      }

}

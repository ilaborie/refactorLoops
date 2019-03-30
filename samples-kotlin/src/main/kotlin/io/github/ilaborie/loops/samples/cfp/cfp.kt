package io.github.ilaborie.loops.samples.cfp

import io.github.ilaborie.models.Talk

object CfpKt {

    // Talk lang with at least one speakers preferred lang matching
    fun filterTalkLangWithAtLeastASpeakerHasLang(talks: Iterable<Talk>): Iterable<Talk> =
        talks
            .filter { talk ->
                val speakerLangs = talk.speakers.flatMap { it.preferredLanguages }
                speakerLangs.isNotEmpty() && talk.languages.containsAll(speakerLangs)
            }

    fun filterTalkLangWithAtLeastASpeakerHasLangFor(talks: Iterable<Talk>): Iterable<Talk> {
        val result = mutableListOf<Talk>()
        talkFor@ for (talk in talks) {
            for (language in talk.languages) {
                for (speaker in talk.speakers) {
                    if (speaker.preferredLanguages.contains(language)) {
                        result.add(talk)
                        continue@talkFor
                    }
                }
            }
        }
        return result
    }

    // Talk lang with all speakers preferred lang matching
    fun filterTalkLangWithAllSpeakersHasLang(talks: Iterable<Talk>): Iterable<Talk> =
        talks
            .filter { talk ->
                val speakerLangs = talk.speakers
                    .map { it.preferredLanguages }
                    .reduce { acc, langs -> acc.intersect(langs) }
                speakerLangs.isNotEmpty() && talk.languages.containsAll(speakerLangs)
            }


    fun filterTalkLangWithAllSpeakersHasLangFor(talks: Iterable<Talk>): Iterable<Talk> {
        val result = mutableListOf<Talk>()
        for (talk in talks) {
            var foundAllLanguage = true
            langFor@ for (language in talk.languages) {
                for (speaker in talk.speakers) {
                    if (!speaker.preferredLanguages.contains(language)) {
                        foundAllLanguage = false
                        break@langFor
                    }
                }
            }
            if (foundAllLanguage) {
                result.add(talk)
            }
        }
        return result
    }
}
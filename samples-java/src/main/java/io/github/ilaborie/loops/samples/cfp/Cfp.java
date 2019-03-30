package io.github.ilaborie.loops.samples.cfp;

import io.github.ilaborie.models.ProgrammingLanguage;
import io.github.ilaborie.models.Speaker;
import io.github.ilaborie.models.Talk;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class Cfp {

    private Cfp() {
        throw new AssertionError("private");
    }


    public static Iterable<Talk> filterTalkLangWithAtLeastASpeakerHasLang(Iterable<Talk> talks) {
        return StreamSupport.stream(talks.spliterator(), false)
                .filter(talk -> {
                    List<ProgrammingLanguage> langs = talk.getSpeakers().stream()
                            .flatMap(speaker -> speaker.getPreferredLanguages().stream())
                            .collect(Collectors.toList());
                    return !langs.isEmpty() && talk.getLanguages().containsAll(langs);
                })
                .collect(Collectors.toList());
    }

    public static Iterable<Talk> filterTalkLangWithAtLeastASpeakerHasLangFor(Iterable<Talk> talks) {
        List<Talk> result = new ArrayList<>();
        talkFor:
        for (Talk talk : talks) {
            for (ProgrammingLanguage language : talk.getLanguages()) {
                for (Speaker speaker : talk.getSpeakers()) {
                    if (speaker.getPreferredLanguages().contains(language)) {
                        result.add(talk);
                        continue talkFor;
                    }
                }
            }
        }
        return result;
    }

    public static Iterable<Talk> filterTalkLangWithAllSpeakersHasLang(Iterable<Talk> talks) {
        return StreamSupport.stream(talks.spliterator(), false)
                .filter(talk -> {
                    Set<ProgrammingLanguage> langs = talk.getSpeakers().stream()
                            .map(Speaker::getPreferredLanguages)
                            .reduce((langs1, langs2) -> {
                                Set<ProgrammingLanguage> r = new HashSet<>(langs1);
                                r.retainAll(langs2);
                                return r;
                            }).orElse(Collections.emptySet());
                    return !langs.isEmpty() && talk.getLanguages().containsAll(langs);
                })
                .collect(Collectors.toList());
    }

    public static Iterable<Talk> filterTalkLangWithAllSpeakersHasLangFor(Iterable<Talk> talks) {
        List<Talk> result = new ArrayList<>();
        for (Talk talk : talks) {

            boolean foundAllLanguage = true;
            langFor:
            for (ProgrammingLanguage language : talk.getLanguages()) {
                for (Speaker speaker : talk.getSpeakers()) {
                    if (!speaker.getPreferredLanguages().contains(language)) {
                        foundAllLanguage = false;
                        break langFor;
                    }
                }
            }
            if (foundAllLanguage) {
                result.add(talk);
            }
        }
        return result;
    }

}

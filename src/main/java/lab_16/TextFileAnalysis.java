package lab_16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The {@code TextFileAnalysis} class is intended for analysis text files. It contains static methods for
 * getting and processing information from text files.
 *
 * @author Timur Kabaev
 */
public class TextFileAnalysis {

    /**
     * It allows to get the frequency dictionary from the source file.
     *
     * @param path to the source file.
     *
     * @return  the map where words from the source file are used as keys and value is the number of occasions
     *          the words in the file.
     *
     */
    public static Map<String, Integer> getFrequencyDictionary(Path path) {

        Map<String, Integer> frequencyDictionary = new HashMap<>();
        try {
            Stream<String> stringStream = Files.lines(path);
            frequencyDictionary = stringStream
                    .map(string -> string.replaceAll("\\p{Punct}", " ")
                            .replaceAll("\\d", " ")
                            .toLowerCase().split("\\s+"))
                    .flatMap(element -> Stream.of(element))
                    .collect(Collectors.toMap(
                            Function.identity(),
                            key -> 1,
                            (existing, replacement) -> ++existing
                    ));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return frequencyDictionary;
    }

    /**
     *  It allows getting a map of adjectives from the source frequency dictionary. But this method works
     *  inappropriate way. Among the list of adjectives may be other parts of speech.
     *
     * @param frequencyDictionary is a source frequency dictionary.
     * @param minWordLength is the minimum length of an adjective.
     * @param maxWordLength is the maximum length of an adjective.
     * @param minFrequency is the minimum frequency of occurrence of a word in the source file.
     * @return  the map which contains the adjectives from the source frequency dictionary
     *          with the restrictions on the length and frequencies of this word.
     */
    public static Map<String, Integer> getAdjectives(Map<String, Integer> frequencyDictionary,
                                                     int minWordLength,
                                                     int maxWordLength,
                                                     int minFrequency) {
        Map<String, Integer> result = frequencyDictionary.entrySet().stream()
                .filter(entry -> entry.getKey().matches(
                        "[а-я]+(ая|яя|ое|ее|ие|ые|ого|его|ому|ему|ом|ем|их|ых|ими|ыми|им|ым|ую|юю)$"))
                .filter(entry -> entry.getKey().length() >= minWordLength && entry.getKey().length() <= maxWordLength)
                .filter(entry -> entry.getValue() >= minFrequency)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue()
                ));

        return result;
    }
}

package lab_16;

import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;

/*
    Подсчет частоты появления слов во входном потоке. Дать возможность указывать
    минимальную/максимальную длину слова, участвующую в подсчёте частоты, для
    фильтрации предлогов и местоимений. Использовать Java8 Stream API. Файл для
    анализа https://drive.google.com/open?id=1YnRy5H8Emx4kyA1-lLZkNuY8LDTplulu
    (*) Выяснить самые популярные прилагательные в тексте.
 */
public class RunnerLab16 {

    public static void main(String[] args) {

        Map<String, Integer> frequencyDictionary = TextFileAnalysis.getFrequencyDictionary(
                Paths.get("src\\main\\java\\lab_16\\vim1.txt"));

        // This method works inappropriate way. Among the list of adjectives may be other parts of speech.
        // The most commonly used adjectives are selected from the list manually.
        // It's "маленькая=41", "русские=30", "молодого=28"
        Map<String, Integer> adjectives = TextFileAnalysis.getAdjectives(frequencyDictionary, 6, 100, 10);

        adjectives.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .forEach(System.out::println);
    }
}

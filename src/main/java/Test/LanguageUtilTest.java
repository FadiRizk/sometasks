package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

import com.example.fadirizktest.LanguageData;
import com.example.fadirizktest.LanguageUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LanguageUtilsTest {
    private static List<LanguageData> data;

    @BeforeEach
    public void setup() {
        data = new ArrayList<LanguageData>();
        data.add(new LanguageData("US", Arrays.asList("en")));
        data.add(new LanguageData("BE", Arrays.asList("nl", "fr", "de")));
        data.add(new LanguageData("NL", Arrays.asList("nl", "fy")));
        data.add(new LanguageData("DE", Arrays.asList("de")));
        data.add(new LanguageData("ES", Arrays.asList("es")));
        LanguageUtils.data = data;
    }

    @Test
    public void testGetNumCountries() {
        assertEquals(5, LanguageUtils.getNumCountries());
    }

    @Test
    public void testGetCountryWithMostLanguages() {
        assertEquals("BE", LanguageUtils.getCountryWithMostLanguages());
    }

    @Test
    public void testGetTotalLanguages() {
        assertEquals(8, LanguageUtils.getTotalLanguages());
    }

    @Test
    public void testGetCountryWithHighestNumLanguages() {
        assertEquals("BE", LanguageUtils.getCountryWithHighestNumLanguages());
    }

    @Test
    public void testGetCommonLanguages() {
        List<String> commonLanguages = LanguageUtils.getCommonLanguages();
        assertEquals(1, commonLanguages.size());
        assertEquals("nl", commonLanguages.get(0));
    }
}
//
//    getNumCountries() : It's a simple iteration over a list with a single loop, so the time complexity is O(n),
//    where n is the number of elements in the list. The space complexity is O(1) since it only requires a constant
//    amount of memory to store a single variable.
//    getCountryWithMostLanguages() and getCountryWithHighestNumLanguages() : it requires a loop to iterate over all
//    elements of the list, so the time complexity is O(n). Inside the loop it uses a max function to keep track of
//    maximum languages and therefore the space complexity is O(1) again.
//    getTotalLanguages(): it also requires a loop to iterate over all elements of the list, so the time complexity
//    is O(n). It uses a variable to keep the count, so the space complexity is O(1)
//    getCommonLanguages(): this method uses two data structures - a HashMap to keep track of the count of each language
//    and a List to keep track of the common languages so the time complexity of the method is O(n) as it performs a
//    single pass over the list. The space complexity is O(m) where m is the number of unique languages, because the
//    HashMap stores m key-value pairs and the List stores m elements.
//    To summarize the time complexity of all the functions combined is O(n) and the space complexity is O(m+1)
//    (1 for the single variable used in getNumCountries, getCountryWithMostLanguages, getCountryWithHighestNumLanguages
//    and getTotalLanguages, and m for the commonLanguages list, and HashMap) where n is the number of elements in the
//    list and m is the number of unique languages in the list.
//    It's worth noting that these complexities assumes that the operations performed on the data structures used like
//     HashMap or List have a constant time complexity, which is usually the case in practice.


import static org.junit.Assert.*; // imports the assert comparison code which retuns a boolean comparing the left and right inputs
import org.junit.*; // imports the package needed to properly display the test outputs without fully running the file being tested
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest { //class initalizer
    @Test //marks the next method as a test and thus places it in the junit tester package
    public void addition() { //method header
        assertEquals(2, 1 + 1); //compares the two inputs and returns an .equals() boolean
    }
    @Test
    public void linkTest() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add("https://something.com");
        result.add("some-thing.html");
        assertEquals(result, links);
    }
}

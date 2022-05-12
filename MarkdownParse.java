//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        String[] linkEnders = {".com",".org",".edu",".net",".gov",".io",".k12",".mil",".uk",".ca"};
        if(!markdown.contains("[") || !markdown.contains("]") ||
            !markdown.contains("(")|| !markdown.contains(")")){ //makes sure all needed charcaters for a link are in the text file
            return toReturn;
        }   
        while(currentIndex < markdown.length()) {

                int openBracket = markdown.indexOf("[", currentIndex);
                int closeBracket = markdown.indexOf("]", openBracket);
                int openParen = markdown.indexOf("(", currentIndex);
                int closeParen = markdown.indexOf(")", openParen);
                if(closeBracket + 1 == openParen){ //makes sure the hyperlink is next to the url, making it a valid link
                    if((markdown.contains("!") && !(markdown.indexOf("!",currentIndex) == openBracket - 1))
                        ||!markdown.contains("!")){ //makes sure it is not an image
                        String link =  markdown.substring(openParen + 1, closeParen);
                        for(int i = 0; i < linkEnders.length; i++){
                            if(link.contains(linkEnders[i]) && link.indexOf(linkEnders[i]) != 0){
                                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                                    break;
                            }
                        }
                    }
                }
                currentIndex = closeParen + 1;
                if(!markdown.substring(closeParen).contains("[") || !markdown.substring(closeParen).contains("]") ||
                    !markdown.substring(closeParen).contains("(")|| !markdown.substring(closeParen).contains(")")){
                    break; //fixes the extra line bug
                }
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}



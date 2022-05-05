MarkdownParse.class: MarkdownParse.java
		javac MarkdownParse.java
		java MarkdownParse "noLink.md"
		java MarkdownParse "test-fail.md"
		java MarkdownParse "test-failure.md"
		java MarkdownParse "test-file.md"

MarkdownParseTest.class: MarkdownParseTest.java
		javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
	
run: MarkdownParseTest.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
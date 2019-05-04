default:
	javac -sourcepath src -d build src/**/*.java

run:
	java -cp .:build:**/.class QuickBuild.QuickBuilder

clean:
	rm -rf build

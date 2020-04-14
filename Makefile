all: compile

compile:
	mkdir -p bin
	javac -classpath /usr/share/java/junit4.jar:/usr/share/java/mockito-core.jar src/PriorityQueueTest.java -d bin

test:
	cd bin ; java -classpath .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore PriorityQueueTest
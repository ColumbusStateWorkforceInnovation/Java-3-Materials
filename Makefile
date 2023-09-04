# Makefile for building JsonExample.jar with multiple Java files in a subdirectory

# Define source files
SRC_DIR = src/main/java/edu/cscc/json
SRC_FILES = $(wildcard $(SRC_DIR)/*.java)

# Define lib files
LIB_DIR = lib
LIB_FILES = $(wildcard $(LIB_DIR)/*.jar)

# Output directory for compiled .class files
BUILD_DIR = build

# Define the jar file
JAR_FILE = build/JsonExample.jar
MAIN_PACKAGE = edu.cscc.json
ENTRY_POINT = $(MAIN_PACKAGE).Main

# Input JSON file. Can be overridden on the command line
JSON_FILE = src/main/java/edu/cscc/json/orders.json

# Define the test source files
TEST_SRC_DIR = src/test/java/edu/cscc/json
TEST_SRC_FILES = $(wildcard $(TEST_SRC_DIR)/*.java)

# Define the test libs
TEST_LIB_DIR = testLib
TEST_LIB_FILE = $(wildcard $(TEST_LIB_DIR/*.jar))

# Output directory for compiled test .class files
TEST_BUILD_DIR = $(BUILD_DIR)/test

# Output directory for Javadoc documentation
DOC_DIR = build/docs

build: clean
	mkdir -p $(BUILD_DIR)
	javac -cp $(LIB_DIR)/* -d $(BUILD_DIR) $(SRC_FILES)

# Clean up intermediate files
clean:
	rm -rf $(BUILD_DIR)

# Compile the Java source files into the output directory and create the JAR file
jar: build
	jar cfe $(JAR_FILE) $(ENTRY_POINT) -C $(BUILD_DIR) .

# Run the jar, making sure to include the libs on the classpath.
# Use the
run:
	java -cp $(JAR_FILE):$(LIB_FILES) $(ENTRY_POINT) $(JSON_FILE)

# Build and run the tests
test: build
	mkdir -p $(TEST_BUILD_DIR)
	javac -cp "$(TEST_LIB_DIR)/*:$(BUILD_DIR)" -d $(TEST_BUILD_DIR) $(TEST_SRC_FILES)
	java -jar $(TEST_LIB_DIR)/junit-platform-console-standalone-1.10.0.jar execute --select-package $(MAIN_PACKAGE)

# Generate Javadoc documentation
javadoc:
	mkdir -p $(DOC_DIR)
	javadoc -d $(DOC_DIR) $(SRC_DIR)/*.java -classpath "$(LIB_FILES)"


# Default target
all: build javadoc test jar


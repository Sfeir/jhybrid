.SUFFIXES: .java .m

BUILD_DIR = build
SOURCE_DIR = src
JAVA_SOURCES = sources.list

# Change to where distribution was unzipped.
J2OBJC_DISTRIBUTION = /Users/abdennebi/Dev/Tools/j2objc-0.8.8
J2OBJC = $(J2OBJC_DISTRIBUTION)/j2objc
J2OBJCC = $(J2OBJC_DISTRIBUTION)/j2objcc

OBJECTS = $(BUILD_DIR)/CalcEngine.o $(BUILD_DIR)/CalcEngineImpl.o $(BUILD_DIR)/CalcMain.o

OBJC_SOURCES = $(OBJECTS:.o=.m)

RESULT = launcher

default: translate $(OBJECTS)
	$(J2OBJCC) -o $(RESULT) $(OBJECTS)

go:
	$(J2OBJCC) main.m $(OBJECTS) -o prog1

clean:
	@rm -rf $(RESULT) $(BUILD_DIR)

$(BUILD_DIR):
	@mkdir $(BUILD_DIR)

$(BUILD_DIR)/%.m $(BUILD_DIR)/%.h: $(SOURCE_DIR)/%.java
	$(J2OBJC) -sourcepath $(SOURCE_DIR) -d $(BUILD_DIR) $?

$(BUILD_DIR)/%.o: $(BUILD_DIR)/%.m
	$(J2OBJCC) -I$(BUILD_DIR) -c $? -o $@


translate: pre_translate $(OBJC_SOURCES)
	@if [ `cat $(JAVA_SOURCES) | wc -l` -ge 1 ] ; then $(J2OBJC) -sourcepath $(SOURCE_DIR) -d $(BUILD_DIR) `cat $(JAVA_SOURCES)` ; fi

pre_translate: $(BUILD_DIR)
	@rm -f $(JAVA_SOURCES)
	@touch $(JAVA_SOURCES)

$(BUILD_DIR)/%.m $(BUILD_DIR)/%.h: $(SOURCE_DIR)/%.java
	@echo $? >> $(JAVA_SOURCES)
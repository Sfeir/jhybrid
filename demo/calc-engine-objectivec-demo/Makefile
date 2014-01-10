.SUFFIXES: .java .m

BUILD_DIR = build
SOURCE_DIR = ../../calc-engine-core/src/main/java
JAVA_SOURCES = sources.list

# Change to where distribution was unzipped.
J2OBJC_DISTRIBUTION = /Users/abdennebi/Dev/Tools/j2objc-0.8.8
J2OBJC = $(J2OBJC_DISTRIBUTION)/j2objc
J2OBJCC = $(J2OBJC_DISTRIBUTION)/j2objcc

OBJECTS = $(BUILD_DIR)/com/sfeir/calc/CalcEngine.o $(BUILD_DIR)/com/sfeir/calc/CalcEngineImpl.o $(BUILD_DIR)/com/sfeir/calc/CalcMain.o

OBJC_SOURCES = $(OBJECTS:.o=.m)

RESULT = launcher

calc: launcher
	$(J2OBJCC) src/main.m -o calc $(OBJECTS) -I$(BUILD_DIR)
	
launcher: translate $(OBJECTS)
	$(J2OBJCC) -o $(RESULT) $(OBJECTS)

clean:
	@rm -rf $(RESULT) $(BUILD_DIR)
	@rm -f sources.list

$(BUILD_DIR):
	@mkdir $(BUILD_DIR)

$(BUILD_DIR)/%.o: $(BUILD_DIR)/%.m
	$(J2OBJCC) -I$(BUILD_DIR) -c $? -o $@


translate: pre_translate $(OBJC_SOURCES)
	@if [ `cat $(JAVA_SOURCES) | wc -l` -ge 1 ] ; then $(J2OBJC) -sourcepath $(SOURCE_DIR) -d $(BUILD_DIR) `cat $(JAVA_SOURCES)` ; fi

pre_translate: $(BUILD_DIR)
	@rm -f $(JAVA_SOURCES)
	@touch $(JAVA_SOURCES)

$(BUILD_DIR)/%.m $(BUILD_DIR)/%.h: $(SOURCE_DIR)/%.java
	@echo $? >> $(JAVA_SOURCES)

mrproper: clean
	@rm -f launcher
	@rm -f calc
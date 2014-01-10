### Requirements

- Java 6 (Java 7 syntax is not yet supported)
- Maven
- XCode and the command line compiler tools for the Mac OS part.

### J2Objc installation
- Download J2Objc (https://code.google.com/p/j2objc/) and extract it.
- Create an env variable $J2OBJC_DISTRIBUTION that points to J2Objc installation.

Example :

    export J2OBJC_DISTRIBUTION=/Users/abdennebi/Dev/Tools/j2objc-0.8.8

##Testing

- Run `mvn install' at the root directory. Then follow the next steps :


### Testing GWT

- Go to `demo/calc-engine-gwt-demo` directory
- Run command `mvn jetty:run-war`
- Open your internet browser and call the following URL : `http://localhost:9999/`
- To stop jetty, run the command `mvn jetty:stop`

### Testing Javascript

- Go to `demo/calc-engine-gwt-demo` directory
- Run command `mvn jetty:run-war`
- Open your internet browser and call the following URL : `http://localhost:9999/`
- Read and follow the displayed indications
- To stop jetty, run the command `mvn jetty:stop`

### Testing Objective-C
*Don't forget to define the J2OBJC_DISTRIBUTION env variable!*

- Go to `demo/calc-engine-objectivec-demo` directory
- Run make, it will create two executables : one called `launcher` and other called `calc`
    - the `launcher` executes any Java class containig a main function. In ower case the class is CalcMain.
    The full command is `./launcher com.sfeir.calc.CalcMain expression`. Example `./launcher com.sfeir.calc.CalcMain 36+69`.
    - the `calc` executable corresponds to the native code that references the transcompiled Javacode. Please take a look to the `main.m` source file.

- to clean objects run `make clean`, to remove executables run `make mrclean`



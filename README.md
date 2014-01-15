## Starter kit for a new generation of hybrid applications

### Description

If you follow the following steps, you will build gwt, javascript and Objective-C calculators.
These calculators are built from a single java code base.

This demo illustrates what Ray Cromwell call a new generation of Hybrid applications :
- Shares logic between Server, Android, Web, and iOS via Java code. 
- Cross compiled with GWT and j2objc 
- Android and iOS UIs marry Java and Obj-C UI with shared Java.
http://www.slideshare.net/cromwellian1/gwtcreate-keynote-san-francisco

### Requirements

- Java 6 (Java 7 syntax is not yet supported)
- Maven
- Android : The Android SDK
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

- Go to `demo/calc-engine-js-demo` directory
- Run command `mvn jetty:run-war`
- Open your internet browser and call the following URL : `http://localhost:9999/`
- Read and follow the displayed indications
- To stop jetty, run the command `mvn jetty:stop`

### Testing Android

#### Setup
- Download and install the [Android SDK](http://developer.android.com/sdk/index.html)
- Set the `ANDROID_HOME` environment variable that points to the installation directory of the Android SDK.
- Add `$ANDROID_HOME/tools` and `$ANDROID_HOME/platform-tools` to your`PATH`.
- Launch an Android Virtual Device or plug your Android phone (tutorial can be found [here](http://developer.android.com/training/basics/firstapp/running-app.html#RealDevice)).

#### Testing

- Go to `demo/calc-engine-android-demo` directory
- Run command `mvn clean package android:deploy`


### Testing Objective-C
*Don't forget to define the J2OBJC_DISTRIBUTION environment variable!*

- Go to `demo/calc-engine-objectivec-demo` directory
- Run make, it will create two executables : one called `launcher` and other called `calc`
    - the `launcher` executes any Java class containig a main function. In our case the class is CalcMain.
    The full command is `./launcher com.sfeir.calc.CalcMain expression`. Example `./launcher com.sfeir.calc.CalcMain 36+69`.
    - the `calc` executable corresponds to the native code that references the transcompiled Javacode. Please take a look to the `main.m` source file.

- to clean objects run `make clean`, to remove executables run `make mrclean`

### Improving the Calculator
- Edit calc-engine-core/src/main/java/com/sfeir/calc/CalcEngineImpl.java
- Rebuild, that's it

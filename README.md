Tools, Frameworks and Techniques used
=============

- Java
- Maven
- Cucumber
- PageObjectPattern
- Cross browser capabilities - Chrome, Firefox, Phantomjs (headless mode)
- Screenshots on failure 
- read parameter from Property file


MAC version for Drivers used
=============

ChromDriver 
https://chromedriver.storage.googleapis.com/index.html?path=2.25/

FirefoxDriver
https://github.com/mozilla/geckodriver/releases

Phantomjs
http://phantomjs.org/download.html


To run
=============

    mvn clean
    mvn -DBROWSER=chrome install
    mvn -DBROWSER=firefox install
    mvn -DBROWSER=phamtomjs install


Output | Results Location 
=============

##html and screenshots
`./target`

##json
`./results`

##xml
`./results`
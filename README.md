Tools, Frameworks and Techniques Used
=============

- Java
- Maven
- Cucumber
- PageObjectPattern
- Cross browser capabilities - Chrome, Firefox, Phantomjs (headless mode)
- Screenshots on failure 
- read parameter from Property file


To run
=============

mvn clean
mvn -DBROWSER=chrome install
mvn -DBROWSER=firefox install
mvn -DBROWSER=phamtomjs install


Used MAC version for Drivers
=============

ChromDriver 
https://chromedriver.storage.googleapis.com/index.html?path=2.25/

FirefoxDriver
https://github.com/mozilla/geckodriver/releases

Phantomjs
http://phantomjs.org/download.html

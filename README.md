Tools, Frameworks and Techniques used
=============

- Java
- Maven
- Cucumber
- PageObjectPattern
- Cross browser capabilities - Chrome, Phantomjs (headless mode)
- Screenshots on failure
- Property file as datasource
- Reports in html, json and xml formats 

MAC version for Drivers used
=============

ChromeDriver 
https://chromedriver.storage.googleapis.com/index.html?path=2.31/

Phantomjs
http://phantomjs.org/download.html


To run
=============

    mvn clean
    mvn -DBROWSER=chrome install
    mvn -DBROWSER=phamtomjs install


Output | Results Location 
=============

html and failure_screenshots
`./target`

json, xml, csv, txt, screenshots
`./results`
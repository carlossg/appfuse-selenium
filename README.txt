Selenium test environment for Appfuse

Carlos Sanchez http://www.carlossanchez.eu
G2iX http://www.g2ix.com

Allows to run Selenium tests as part of the Maven build, either in an specific container
and browser or launching the tests in parallel in several browsers at the same time.

For more information check my slides and blog entries on "Enterprise Build and Test in the Cloud"
http://www.jroller.com/carlossg/entry/apachecon_slides_enterprise_build_and
http://www.jroller.com/carlossg/entry/enterprise_build_and_test_in1
http://www.jroller.com/carlossg/entry/enterprise_build_and_test_in2

By default it's configured to launch 3 browsers in parallel, Internet Explorer, Firefox 2 and 3
Check src/test/resources/testng.xml for the configuration.

In the single browser option you could do

* Testing in Jetty 6 and Firefox (doesn't work for me in FF3)

  mvn install


* Testing in Internet Explorer

  mvn install -Pjetty6x,iexplore


* Testing with any browser

  mvn install -Pjetty6x,otherbrowser -DbrowserPath=path/to/browser/executable


* Start the server (no tests running, good for recording tests)

  mvn package cargo:start

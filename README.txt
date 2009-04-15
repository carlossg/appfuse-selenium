* Testing in Jetty 6 and Firefox (doesn't work for me in FF3)

  mvn install


* Testing in Internet Explorer

  mvn install -Pjetty6x,iexplore


* Testing with any browser

  mvn install -Pjetty6x,otherbrowser -DbrowserPath=path/to/browser/executable


* Start the server (no tests running, good for recording tests)

  mvn package cargo:start

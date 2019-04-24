# DnDQuickBuild
 This is a Java program that will build a DnD Character using the basic ruleset from 5e
  
 This is still a work in progress. I'm using IntelliJ and the JRE is Java Version 11.0.1.

 It's super messy and it's probably not as effiecient as it could be but eventually I'll refactor some things and clean it up.
  
  ## It rolls stats using the rules:
    1. Roll 4d6 and takes the three highest 6 times
    2. Sum the 3 rolls for each stat
    3. If the total sum of the stats or there isn't a stat 15 or higher, roll again
  
 ### Running the program
    To compile - "make"
    To run - "make run"
    To remove build dir and class file - "make clean"
    
    
### Possible Errors
I built and run this code using

    openjdk version "10.0.2" 2018-07-17
    javac 10.0.2
    
If you run into compiling errors follow the instructions on this site [digitalocean.com](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-18-04)


When compiling if an error about "build directory not found" comes up, just make a directory called build then try to compile again

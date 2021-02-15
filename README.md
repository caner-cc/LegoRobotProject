# Lego Robot Project
 
All that needs to be done with the code is making the 3 threads work together.
Right now both scanners work and execute code conitinously because they are in a loop. Putting the movement thread in a loop causes it to loop infinitely over the other 2 threads. 

Find a way to make the movement thread work while the other 2 are working. 



Notes: 

(right now the movement will work up until some movement code is executed from the ultrasonicDistance code. After that the thread will simply stop working)
(Consider maybe moving the movement code off of the UltrasonicDistance code to seperate movement from scanning)

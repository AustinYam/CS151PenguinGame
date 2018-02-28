README TEXT

GAME: PENGUIN GAME

CREATOR: AUSTIN YAM

HOW TO RUN:

My computer was not able to locate the images until found them from a folder on my desktop.
You will not be able to see the images unless you change the contructors to look at the
corret directory.

In the classes Field, Fighter, and GoodFish 
located in the contructors you will need to change the image path to "./game/-theimage-"

for example the platform initialization on line 131 would need to be changed from 
platform = new MovingImage("C:/Users/Austin/Desktop/Pics/ICEBLOCK.png",200,550,400,10);
to 
platform = new MovingImage("./game/ICEBLOCK.png",200,550,400,10);

if that does not work you will need to show the entire path to the game directory as 
shown "C:/Users/Austin/Desktop/Pics/ICEBLOCK.png" according to your own computer.
After that the program should run perfectly when compiling and running.

THANK YOU

THE GAME FEATURES:

Press start to begin the game
The penguin will be able to move left, right, fly, and fall
The square blocks of ice will spawn at random locations whenever the game is started up
The blocks will freeze the yellow fish in the air and slow down the red fish
The fish will not start falling from the top of the frame until you hit the first fish with your penguin
After that, the fish will spawn and fall at random locations at the top of the frame
Sometimes a red fish will spawn that will move faster 
Each fish you collect will give you a point which is displayed at the top of the game. 
You have 5 lives which will go down by one everytime a fish reached the bottom of the map
After you reach 0 lives, the game will stop and show you your final score. 
A end button will appear at the top for you to click and end the game.


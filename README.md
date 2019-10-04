# CS3343
=======
Welcome to our fake casino for fun! 
All document please put in oneDrive!!!

- If you don't want eclipse then here a way for u
  - Visual Studio Code :
    https://code.visualstudio.com/blogs/2018/09/10/introducing-github-pullrequests
  - Atom : 
    
    https://flight-manual.atom.io/using-atom/sections/github-package/

# env
- gradle 4.10 ( if dont have, please download it )
- Junit5

# For your java file: 
1. ### Please use three function in interface Game.java 
   -    intro() : display table or game description
   -    gamePlay() : your game function
   -    result(): calculation and display result

2. ### Put you java/folder file to Game folder , then type this after you finish the profile 
    <terminal>
    $ gradle build
 
3. ### How to complie: you need to call your game in main and then type this in
    <terminal>
    java -cp .\build\libs\CS3343.jar CS3343.Main

# For test:

###  Step 1: Put you test java file to test folder, then type build again

### Step 2 : After you make the test cases, then 
    <terminal>
    $ gradle clean test

    
# After adding dependencies remember to
    gradle build
    
# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable) -> in `cheatsheet.md`
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 - What **new thing(s)** did you learn / figure out in completing this project?
 - Is there anything that you wish you had **implemented differently**?
 - If you had **unlimited time**, what additional features would you implement?
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

- We followed the S4 principle (Start Small, Slow, and Simple) and the MVP principle (Minimum Viable Product). We wanted to have a small game at first, and then build and build until we got to our current product. Everytime we thought of a new, big idea during the process of creating the game, we started thinking from S4.
- We learned about switch cases and JFrames in particular in this project. Switch cases allowed us to have an easy main gameplay loop menu. The JFrames allowed us to add the images (drawn by Lucy) for each enemy and the map so the user knows where they are going. 
- If we had more time, we would like to create an interactive UI/UX for the user to play the game through key commands and mouse clicks (i.e. Main Menu, Help, Options, an improved Map, character icons, etc). We also would like to create different RPG classes (e.g. Medic, Rogue, Mage, Barbarian, etc.) for the players and enemies. This also would’ve lend itself well to the scrapped idea of having a party made up of these different classes. Additionally, our map sometimes does not appear and instead a white screen appears. We are not sure why, and had issues looking it up because there is not a lot of modern documentation about JFrames. However, it does not crash the game so we decided to just leave the map as is. 
- Along with having a party, in our original plans we were going to have multiple enemies to fight per combat instance. However, this was put to the side and instead we focused on making the combat more intuitive and interesting (chance to critical hit, battle stance, slight variation in damage, + having a Jframe to show what the enemy looks like)
- Professor Jordan suggested to us to have the movement be in the initial gameplay menu, rather than going back and forth from Explore to movement. This allows the user to have quicker movement and a more enjoyable experience. 
- I would stress to keep things simple at first. I would also want them to first think about how you would want the player to execute actions and what would be most efficient and effective. 
- We had open communication, met often, accommodated each other, and had a common vision for the game. We were really creative with what we wanted our game to look like and strived to finish a game that closely resembled our ideal with the time we had. We consistently reminded ourselves to follow S4 to produce more “significant” branches before each merge. We had a lot of fun!!!!

## Design Justifications 
- We justify our decision of having input numbers to the scanner instead of strings. Our main gameplay loop has 9 different options: Go North, Go South, Go East, Go West, Check inventory, Look Around / Get Location, Move to another area, Help, and Quit. With all these different options, it would be difficult to have a string detector since every person may have a different way of inputting their choice. With the integer scanner and the case switch, it is easier and faster for the user to play the game. 
- We had a later change to have the ‘Explore’ -> ‘N,S,E,W’ (options) to be expanded into options 1,2,3,4 in the main game loop options, instead of having to type explore, then the direction every time you wanted to move. Before, when they were all on one switch case, we only had to check for tile conditions once, right after you moved. However, now we have four different checks, with one common method for specialThanks(), which prints the end screen. We may have been able to congregate more of these checks into methods, but we couldn’t find an easy way to do so, because it required information from several different classes, and since it was a later decision, we did not want to break our code when this way worked despite it taking up more lines. Maybe if we had more time we could have played around with the idea, but even just making the end credits into its own method shaved a lot of lines off our project and made the code more readable.
- We also justify our decision of having enemy and player being two different classes, instead of parent and child classes, because of their use in the Combat class. While the Enemy and PlayableChar classes have very similar methods and attributes, we decided to have them be different classes. The Combat class requires multiple values from both the classes and we decided it would be more difficult to have a parent and child classes with how much they interact. Their similarities were also made clear only later on in the project’s timeline. 

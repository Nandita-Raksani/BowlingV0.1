# Bowling
A game of bowling consists of ten frames. In each frame, the bowler will have two chances to knock down as many pins as possible with their bowling ball.
If a bowler is able to knock down all ten pins with their first ball, he is awarded a strike. If the bowler is able to knock down all 10 pins with the two balls of a frame, it is known as a spare. Bonus points are awarded for both of these, depending on what is scored in the next 2 balls (for a strike) or 1 ball (for a spare). If the bowler knocks down all 10 pins in the tenth frame, the bowler is allowed to throw 3 balls for that frame. This allows for a potential of 12 strikes in a single game, and a maximum score of 300 points, a perfect game.

# Purpose
This game is developed in Java programming language using Test Driven Development approach.

# Functional cases
1) Consider the initial score of game to be 0 and all rolls to be valid ones
2) Make a roll and if no pins are knocked in the frame the game score should be 0
3) Make a roll to check if atleast 1 pin is knocked in the frame, then the game score should be 1
4) Consider the ball knocks 2 pins per each rolls of 10 frames, then the game score should be 40
5) If all 10 pins are knocked in first roll of a frame, it is a strike then next 2 immediate rolls should also be taken as single frame.
	E.g, if a bowler rolls, 10 | 5, 4 then their score is 28 = (10 + 5 + 4) + (5 + 4).
6) If in a single frame all pins are knocked down in 2 rolls, it is a spare. The score will be sum of the number of pins knocked down plus the number of pins knocked down in the next roll.
	E.g, if a bowler rolls, 4,6 | 5,0, then their score is 20 = (4 + 6 + 5) + (5 + 0).
7) If all rolls of the frames are spare, an additional roll will be given Eg: 5,5| 5, game score  will be 150
8) If all rolls of the frames are strike, its a perfect game and the score will be 300

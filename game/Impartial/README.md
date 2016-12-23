# Nim Game - Impartial Game

### Theory


Two players (numbered  and ) are playing a game with  stones. Player  always plays first, and the two players move in alternating turns. The game's rules are as follows:

In a single move, a player can remove either , , or  stones from the game board.
If a player is unable to make a move, that player loses the game.
Given the number of stones, find and print the name of the winner (i.e.,  or ) on a new line. Each player plays optimally, meaning they will not make a move that causes them to lose the game if some better, winning move exists.


```
# By ende76 @HackerRank

It's proof by induction.

The hypothesis: 
For n % 7 in [0, 1], the first player loses, otherwise the first player wins.

The anchor:
Clearly, for 0 or 1 stones, the first player has no move, so he loses. 
For any of 2, 3, 4, 5, or 6 stones, 
the first player can make a move that leaves 0 or 1 stones for the second player, 
so the first player wins.

Induction step: 
Now, for a given starting position n we assume that our hypothesis is true for all m < n.
If n % 7 in [0, 1], 
we can only leave the second player with positions 
(n - 2) % 7 in [5, 6], 
(n - 3) % 7 in [4, 5], 
or 
(n - 5) % 7 = [2, 3], 

all of which mean – by induction – that the second player will be in a winning position. 
Thus, for n % 7 in [0, 1], the first player loses.
If n % 7 in [2, 3, 4, 5, 6], 
there's always a move to leave the second player with an m % 7 in [0, 1], 
thus – again by induction – forcing a loss on the second player, leaving the first player to win.

That concludes the proof.

The invariant is, that once a player A can force [0, 1] on player B, 
A can keep forcing that position, while B cannot force it on A.


```

```
1    Second
2    First
3    First
4    First
5    First
6    First
7    Second
...
10   First

```

### Program Challenges for Nim Game in Hackerrank

[Basic, game of Stone ](https://www.hackerrank.com/challenges/game-of-stones-1/)

[Basic, Introduction of Nim game](https://www.hackerrank.com/challenges/nim-game-1)

[Basic, Misere-Nim](https://www.hackerrank.com/challenges/misere-nim-1)

[Basic, Nimble Game](https://www.hackerrank.com/challenges/nimble-game-1)

[Basic, Poker Nim](https://www.hackerrank.com/challenges/poker-nim-1)

[Advanced, A stones game -Half](https://www.hackerrank.com/challenges/half)

[Advanced, Stone Division](https://www.hackerrank.com/contests/w25/challenges/stone-division)

[Advanced, Taste of Winning ](https://www.hackerrank.com/contests/w26/challenges/taste-of-win)

[Zero Move Nim](https://www.hackerrank.com/contests/w27/challenges/zero-move-nim)



### Reference

Below are very good documents regarding the mathematical theory behind the Nim Game

[NIM Theory @ University of MaryLand](https://www.cs.umd.edu/~gasarch/COURSES/250/S15/nimnotes.pdf)

[NIM Theory @ MIT](http://web.mit.edu/sp.268/www/nim.pdf)

[Nim UCLA](http://www.math.ucla.edu/~tom/Game_Theory/comb.pdf)

[Berkeley](http://www.stat.berkeley.edu/~peres/gtlect.pdf)


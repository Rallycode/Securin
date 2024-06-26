# SECURIN
# Problem Statement: The Doomed Dice Challenge
# PART A
## [1. How many total combinations are possible?](https://github.com/Rallycode/Securin/blob/main/src/partA/Question1.java)
## OUTPUT
![Image Description](https://github.com/Rallycode/Securin/assets/122144615/1056c1b9-7555-4774-a079-9ab7bd1e2113)
## [2. Calculate and display the distribution of all possible combinations that can be obtained when rolling both Die A and Die B together](https://github.com/Rallycode/Securin/blob/main/src/partA/Question2.java)
## OUTPUT
![image](https://github.com/Rallycode/Securin/assets/122144615/09dfff7c-0e52-4319-8eb8-a01b8b954f4d)
## [3.Calculate the Probability of all Possible Sums occurring among the number of combinations from (2).](https://github.com/Rallycode/Securin/blob/main/src/partA/Question2.java)
## OUTPUT
![image](https://github.com/Rallycode/Securin/assets/122144615/412f8d04-1817-485b-9d5d-7965a41a6b41)
# PART B
## [Loki Doomed Dice Problem](https://github.com/Rallycode/Securin/blob/main/src/partB)
## Problem Statement: The Doomed Dice Challenge

You have the tools to re-attach the "Spots" back on the Dice. However, Loki has doomed your dice with the following conditions:

- Die A cannot have more than 4 Spots on a face.
- Die A may have multiple faces with the same number of spots.
- Die B can have as many spots on a face as necessary, i.e., even more than 6.

But in order to play your game, the probability of obtaining the Sums must remain the same! So if you could only roll P(Sum = 2) = 1/X, the new dice must have the spots reattached such that those probabilities are not changed.

### Input:

- Die_A = [1, 2, 3, 4, 5, 6] & Die B = Die_A = [1, 2, 3, 4, 5, 6]

### Output:

A Transform Function `undoom_dice` that takes `(Die_A, Die_B)` as input & outputs `New_Die_A = [?, ?, ?, ?, ?, ?], New_Die_B = [?, ?, ?, ?, ?, ?]` where, No `New_Die A[x] > 4`

## [APPROACH 1](https://github.com/Rallycode/Securin/blob/main/src/partB/Question1ByDynamicProgramming.java)
In this Approach, We implemented Dynamic Programming to solve this classic doomed dice problem
![image](https://github.com/Rallycode/Securin/assets/122144615/f2c7080f-85e7-4857-8e6d-8b1149cec7db)
## OUTPUT
![image](https://github.com/Rallycode/Securin/assets/122144615/0da919ea-d244-47c5-bab2-848e511ba699)

## [APPROACH 2](https://github.com/Rallycode/Securin/blob/main/src/partB/Question1.java)
In this Approach, We get the value of Six faces of each Doomed Dice from the user, then the program verifies whether the sum of probability of the original Dice matches with sum of probability of the doomed dice. If exists, the doomed dice outcome will be printed else "No such possibilites" will be printed. 
![image](https://github.com/Rallycode/Securin/assets/122144615/ae11eefe-18db-46c3-83f5-bb127612a864)
![image](https://github.com/Rallycode/Securin/assets/122144615/a8bbe215-828e-4e1f-b47a-4191e8222014)
![image](https://github.com/Rallycode/Securin/assets/122144615/45ab4d90-a5d7-4e64-ba4e-41e3025aafb1)

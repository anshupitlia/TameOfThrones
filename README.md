# Tame of Thrones

## Problem Description

### Problem 1

There is no ruler in the universe of Southeros and pandemonium reigns. Shan, the gorilla king of the Space kingdom
wants to rule all Six Kingdoms in the universe of Southeros. He needs the support of 3 more kingdoms to be the ruler.

Each kingdom has an animal emblem and Shan needs to send a message with the animal in the message to win them over.
LAND emblem - Panda, WATER emblem - Octopus, ICE emblem - Mammoth, AIR emblem - Owl, FIRE emblem - Dragon.

This  coding challenge is to have King Shan send secret message to each kingdom and win them over.
Once he wins 3 more kingdoms, he is the ruler! The secret message needs to contain the letters of the animal in their
emblem. For example, secret message to the Land kingdom (emblem: Panda) needs to have the letter 'p','n','d' atleast once and 'a' at-least twice. If he sends "a1d22n333a4444p" to the Land kingdom, he will win them over.

Commit [72a1d7850a578e0f478b291d7fe29dfdfd9eebe8] with message starting from "Problem 1 finishes here" contains code till this problem.

The code has been further extended to solve for Problem 2

### Problem 2

The other kingdoms in the Universe also yearn to be the ruler of Southeros and war is imminent! The High Priest of Southeros
intervenes and is trying hard to avoid a war and he suggests a ballot system to decide the ruler.

This coding challenge is to help the High Priest choose the ruler of Southeros through the ballot system.

Rules of the Ballot system
 1. Any kingdom can compete to be the ruler.
 2. They should send a message to all other kingdoms asking for allegiance.
 3. This message will be put in a ballot from which the High Priest will pick 6 random messages.
 4. The High Priest then hands over the 6 messages to the respective receiving kingdoms.
 5. The kingdom that receives the highest number of allegiance is the ruler.

## Dependencies

1. Any O.S. (Developed and tested in Mac O.S. 10.14)
1. Java 1.8 or higher (Developed and tested on Java 1.8)
1. Maven

## Run Tests

```
mvn test
```
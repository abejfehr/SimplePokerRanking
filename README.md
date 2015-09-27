# [Simple Poker Ranking](https://github.com/abejfehr/SimplePokerRanking)

**Name:** Fehr, Abram

**Student Number:** 100908743

**Link to Assignment:** [https://github.com/abejfehr/SimplePokerRanking](https://github.com/abejfehr/SimplePokerRanking)

## Running the Test Suite
Simply right-click the `test` directory and select *Run As > JUnit Test*.

## Running the Application
The application can be ran in a similar way; just right-click the `src/Main.java` and select *Run As > Java Application*.

## Features and Corresponding Tests

I've created subheadings below to illustrate which features I've tested in which classes, and the name of the test.

### Card

|Feature|Description|Test Case|
|---|---|---|
|Constructor works|Tests that a card can be created from a RankSuit string. For example: "TwoHearts" or "ThreeDiamonds"|`testHasValueAndSuit`
|Constructor is case agnostic|Ensures that cards can be created with a mix of case. For example: "tWoDiaMONdS"|`testCardConstructorCaseInsensetive`|
|Cards must be ranked A,K,Q,J,10-2|Expects that cards with crap like "SeventeenClubs" can't be created. An ImpossibleCardException is thrown and expected by the test|`testImpossibleRank`|
|Cards must have a known suit|Verifies that creation of cards like "FourShovels" and anything with suits other than the normal four are not allowed|`testImpossibleSuit`|
|Test equality between cards|Checks equality by comparing two cards with the same rank and suit|`testEquality`|

### Hand

|Feature|Description|Test Case(s)|
|---|---|---|
|5 Card Hand|Verifies that the Hand constructor doesn't allow anything other than 5 cards|`testHandNotFiveCards`, `testHandCardCount`|
|Don't allow duplicate cards in one hand||`testHandDuplicateCards`|
|High Card Ranking||`testRankingHighCard`|
|One Pair Ranking||`testRankingOnePair`|
|Two Pair Ranking||`testRankingTwoPair`|
|Three of a Kind Rank||`testRankingThreeOfAKind`|
|Straight with Aces Low||`testRankingStraightAceLow`|
|Straight with Aces High||`testRankingStraightAceHigh`|
|Flush Ranking||`testRankingFlush`|
|Full House Ranking||`testRankingFullHouse`|
|Straight Flush Ranking||`testRankingStraightFlush`|
|Royal Flush Ranking||`testRankingRoyalFlush`|
|Hand Rankings comparable|Tests the compareTo function for the Hand class. Ensures that hands really are accurately comparable with each other|`testHandsComparable`|
|Hands share same card(disallow duplicates overall)|Tests the containsCardFrom method which is used to check that each card is unique throughout hands per round|`testHandsContainOtherCards`|

### Round

|Feature|Description|Test Case|
|---|---|---|
|Constructor Test||`testGameNoPlayers`|
|Allow a player to be added to the game||`testAddPlayerToGame`|
|Disallow adding player after ranking made|Test also implicitly checks to make sure that the round's state can be changed from `SETUP` to `RANKING`|`testAddPlayerAfterRanking`|
|Disallow adding players with wrong player ID||`testAddPlayersOutOfOrder`|
|Get hand rankings in a round||`testGetRankedHands`|
|Disallow duplicate cards between hands||`testDuplicateCardsBetweenHands`|
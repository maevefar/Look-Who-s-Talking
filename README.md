# etude05 - Look Who's Talking
# By Maeve and Tara
# Team Name: Fast Wifi

## Introduction
The task of our code is to take a simple phrase in English consisting of a personal pronoun and verb and tranlsate it to Te Reo Maori. It can translate verbs in the past, present, or future tense. Pronouns are less ambigious in Te Reo Maori because they account for inclusivity and the number of people which is not specified in English. The English sentence input must always contain the format with the pronoun first then the verb.  

Our code is structured to have helper functions that address the translation through breaking it down into translating the verb tense, translating the personal pronoun, and translating the verb itself. When attempting to improve our code, we added a further function to get the verb from the sentence since that is needed when translating the verb and the verb tense. 

Some challenges we faced were determining how to most efficiently translate through noticing patterns. When starting the code, we made many simplifications knowing we would run into problems later and need to come up with fixes. When assuming all past tense verbs ended in ed, it left out a few words. So, we decided the most efficent way, since the other words don't follow a common rule, was to add them to an array list and check if the word is contained in the list or ended in ed. Another problem we had was with translating the verbs. To translate a verb, we would remove the ed so we did not have to add every verb and every past tense verb to the dictionary. However, then when translating the tense, it translated the verb without the ed since we changed it to that. In order to fix this, we made sure to revert the verb back to its inital form but still took the ed off in order to keep the tranlsating efficient. Most other errors we encountered were minor mistakes in our unsterstanding of grammar that were easy to fix or similar to the case where we needed to add more enteries to a dictionary or array list but tried to limit that as much as possible to keep it efficient. 

## How to Compile and Run Code 
Note: JDK will need to be installed prior
-  Open a terminal at Etude05 Look Whos Talking/app/src/main/java/etude05
-  Type javac Etude05.java to complie the code 
-  Then type java Etude05.java to run the code 
-  From there you can enter as many sentences as you would like to convert 
Note: If copying and pasting many lines of dates into the program, have an empty line at the bottom so that the formatting of the returned dates or errors is correct

## Test Cases
Past tense: 
I went, I made, I saw, I wanted, I called, I asked, I read, I learned

Present tense:
I am going, I am making, I am seeing, I am wanting, I am calling, I am asking, I am reading, I am learning

Future tense:
I will go, I will make, I will see, I will want, I will call, I will ask, I will read, I will learn 

We tested all the above as is, then changed the pronoun to all the pronouns found in the table (me, you, he, she, him, her, we, us, you two, they, them) and added (2 incl) (2 excl) and swapped the 2 with 3 and numbers greater than 3.

Lastly, we tested some nonsense cases such as: gibberish, My name is Maeve, apple pie, I would learn.

We generated these test cases through breaking down the testing similaraly to how we broke down the helper functions. Every verb needs to be testeted, then every verb with every tense, then every verb with every tense with every personal pronoun. Essentially, we created a bunch of combos with the given verbs (8 total), tenses (3 total), and personal pronouns (11 total) to ensure that ever case works and have our special consideration that is detailed in the project design section below. 

## Project Design 

When the user inputs phrases such as I going and I wanting, the output produced is equivalent to if the user input I am going and I am wanting. The reasoning behind this is that if the translator were in use in the real world, getting an error for bad grammar is not helpful. Ideally, in a real world application, it would translate the input and show what it translated saying suggested grammar fix is add to add the am.

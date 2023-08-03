# DriveLabs_MobileApp
Android Car Identification Game

This Android application is a fun and interactive game that allows users to test their knowledge of car makes. The app contains a collection of car images (minimum 30) from various manufacturers, and the user's goal is to correctly identify the car make from the displayed images. The app adheres to the following specifications:

Home Screen:
Upon launching the app, the user is presented with a home screen that displays four buttons:
a) Identify the Car Make: Allows the user to identify the car make by selecting from a dropdown list after viewing a random car image.
b) Hints: Provides a character guessing game where the user tries to guess the car make character by character.
c) Identify the Car Image: Displays three random car images, and the user must choose the image that matches the given car make.
d) Advanced Level: Presents three unique car images, and the user needs to type the correct car manufacturer names for each image.

Identify the Car Make:
a) Clicking on the "Identify the Car Make" button presents the user with a random car image and a dropdown list containing all car makes in the app.
b) The user selects the correct car make from the dropdown and clicks the "Identify" button to submit the answer.
c) The app displays a message (CORRECT! or WRONG!) with the correct car make in yellow, based on the user's response.
d) The "Identify" button changes to "Next," allowing the user to proceed to the next random car image and play again.

Hints:
a) Clicking on the "Hints" button presents the user with a random car image, dashes representing the car make name, a textbox, and a "Submit" button.
b) The user guesses the car make character by character using the textbox and clicks "Submit" to check the answer.
c) Correct guesses replace the corresponding dashes with the actual character. Incorrect guesses are allowed up to 3 attempts.
d) After 3 incorrect attempts or correct guessing of the car make, the "Submit" button changes to "Next," allowing the user to proceed to the next random car image and play again.

Identify the Car Image:
a) Clicking on the "Identify the Car Image" button presents the user with three different random car images and the correct name of one car manufacturer.
b) The user clicks on the image corresponding to the displayed name to submit their answer.
c) The app displays a message (CORRECT! or WRONG!) with the result, and the user can click "Next" to proceed to the next set of three random car images and play again.

Advanced Level:
a) Clicking on the "Advanced Level" button presents the user with three different random car images and three textboxes.
b) The user must type the correct car manufacturer names corresponding to each image in the respective textboxes and clicks "Submit" to check the answers.
c) Correct guesses are displayed in green and become uneditable, while incorrect guesses are marked in red and remain editable.
d) The user is allowed only 3 incorrect attempts. After three incorrect attempts, the "Submit" button changes to "Next," allowing the user to proceed to the next set of three random car images and play again.

Switch Button and Countdown Timer:
a) The home screen includes a "Switch" button that, when turned on, enables a countdown timer for each game level.
b) The timer counts down from 20 to 1, with each tick occurring every second.
c) When the timer reaches 0, it acts as if the "Submit" button is clicked, stopping the current game screen and displaying the result.

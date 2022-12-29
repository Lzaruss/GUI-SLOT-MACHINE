# GUI-SLOT-MACHINE
It is a small Slot Machine Project, only with educational porpouses.
NOTE: If you like it, and see thing to improve the code let me know!

# DESCRIPTION


The SlotMachine class is the main class of the project, which extends the JFrame class. This class contains all the logic of the game, including the creation of the window, the initialization of the buttons, the initialization of the cells, and the initialization of the dialogs.

In the SlotMachine class, several global variables are declared, such as the number of columns and rows of the slot machine, the width and height of the window, a two-dimensional array of cells, and some buttons and labels.

The SlotMachine class has several methods, such as initPantalla for initializing the screen, initCeldas for initializing the cells of the slot machine, initButtons for initializing the buttons, and initDialog for initializing the dialogs.

The Cell class is a helper class that represents each cell of the slot machine. This class contains a row, a column, a value, and a label. It also has a randomImage method that is used to assign a random image to the cell.

The JDialog class is a class from the Java Swing UI library that is used to create modal dialog windows. In this project, two dialogs are used: over and premios. The over dialog is displayed when the game has ended, and the premios dialog is displayed when the prizes button is clicked.

The JButton class is a class from the Java Swing UI library that is used to create buttons. In this project, the start button is used to start the game, and the buttonPrizes button is used to display the prizes dialog.

The JLabel class is a class from the Java Swing UI library that is used to display text or images in the UI. In this project, several labels are used, such as ganancias, creditos, displayGanancias, displayCreditos, gameOver, and dadoLabel, to display information on the screen.

The ActionListener interface is a Java interface that is used to detect actions performed by the user in the UI. In this project, it is used to detect when a button is clicked.

CLASS CELL

The Cell class is a helper class that represents each cell of the slot machine. This class contains a row, a column, a value, and a label. It also has a visited variable that indicates whether the cell has been visited and a numValues variable that keeps track of how many different values there are in the cell.

The Cell class has a constructor that initializes the variables of the cell with the values passed as parameters. It also has a randomImage method that is used to assign a random image to the cell. The randomNumber method is a helper method that is used to generate a random number with a specific probability distribution for each of the images.

CLASS JUGAR

The "Jugar" class is a class that extends the Thread class and is used to perform the game logic. This class contains several variables such as a matrix of cells, an array of values, an array of number of values, an array of bets, an array of prizes, an integer that keeps the last prize obtained, several buttons and labels, and a dialog.

The Jugar class has a constructor that initializes the variables with the values passed as parameters. It also has an explosion method that is used to change the image of the winning fruits and create an explosion in each of them. The data method is used to check the type of each cell and add it to a control variable. The run method is the main method of the Thread class and is used to execute the game logic.

The Dado class is a class that extends the Thread class and is used to simulate the roll of a die. This class contains a label and several variables that are used to update the screen and control the flow of the game.

The Contador class is a class that extends the Thread class and is used to display the winnings or credits counter on the screen. This class contains a label and a variable that are used to update the screen and control the flow of the game.

CLASS EXPLOSION

The "Explosion" class is a subclass of the Thread class in Java. It has two member variables: a Cell object called "c" and two ImageIcon objects called "exp" and "expon".

The class has a constructor that takes in a Cell object and initializes the "c" member variable with it. It also has a method called "imageColor" that takes in a Cell object and determines the color of an explosion image to be displayed on it. The method uses a series of if statements to check the value of the cell and assigns a color to the "exp" object based on the value. The "expon" object is then initialized with a scaled version of the "exp" object.

The class also has an overridden "run" method that displays the explosion image on the cell for a brief period of time and then removes it. The method does this by changing the icon of the cell's JLabel object (called "neigh") and then sleeping for a set amount of time before changing it back to its original icon. If an InterruptedException is thrown, it is caught and a RuntimeException is thrown in its place.

CLASS DADO

"Dado" is a Java class that represents a die or a dice. It extends the Thread class and has a number of attributes such as an ImageIcon object called "exp", a JLabel object called "c" which represents the button of the die, two more JLabel objects called "ganancias" and "credito", and a JButton object called "start". The class also has an integer array called "premios" that stores the prizes for each possible value of the die, and an integer called "valor" to store the value of the prize. It also has a Contador object called "contador" which is used to refresh the value of the prize. The class has a method called "changeImage" that changes the image of the JLabel object "c", and a method called "run" which simulates the rolling of the die. The "run" method generates a random number between 0 and 5 which represents the value of the die, and it updates the image of the die accordingly. It also calculates the prize based on the value of the die, and updates the value of the "ganancias" and "credito" JLabel objects.

# example
https://user-images.githubusercontent.com/104428151/196655499-bd8462d3-6c8b-4e58-bf99-f3fe4e7dec95.mp4

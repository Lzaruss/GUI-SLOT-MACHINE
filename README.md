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

# example
https://user-images.githubusercontent.com/104428151/196655499-bd8462d3-6c8b-4e58-bf99-f3fe4e7dec95.mp4

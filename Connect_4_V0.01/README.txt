Connect 4 back-end v0.01

this project is my first iteration of the connect 4 back-end.

how it works:
	the game will ask the question "col?" asking which column you want
	to insert the token (0-6) the token starts with red and switches
	every turn. the game will show the connect 4 table as it goes.
	if the game detects a win it will show a message like the following:
	(row, col diag1/2, diag3/4): YELLOW/RED WINS.
	col and row are self explanatory. diag1 and diag2 refer to back-
	slash connections and 3 and 4 to forward-slash connections.

	this code does not (yet) tolerate inputs other than ints between 0
	and 6 (inclusive), and will also crash when trying to over-fill a
	column.

the code is very messy and inefficient but I will improve it as I go.
I will also implement any functions the enable it to communicate the
matrix with other classes if needed.

to start the programm run main

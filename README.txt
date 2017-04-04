CSCI205 HW3
Team: Zilin Ma, Yuxuan Huang

Intro:
This is a GUI built around the provided ANN.
The representation of the weights are the colors of the edges. A warmer tone is negative,
and a colder tone is positive. The stronger the color is, the larger the absolute value
of a edge is. If an edge is almost invisible, then the weight there is close to 0. 

The input values are aligned at the left, and the output values are aligned at the right
when classify one line is clicked.

The SSE and current epoch since last time clicking train is displayed at the bottom of the window.

Instruction for use:
Run ANNMain.java under /src/csci205_proj_hw3.
     For Training:
         1.Click on ‘File’ button on the top
	 2.Click on ‘Select Test File’ button
	 3.Select the data file for training
	 4.Exit the ‘Choose Option’ Panel
	 5.Click on ‘Config’ button on top
	 6.Enter the correct value for # input nodes, # hidden nodes, #output nodes.
	   Note the # input nodes and #output nodes should match the selected data file
	 7.Enter double for desired Learning Rate and Momentum. Or leave them empty as 
	   default.
	 8.Choose desired activation strategy from the drop-down menu. Or leave it as
	   default.
	 9.Enter desired number of epoch to be ran at the bottom.
	 10.Click ‘Train’ button.
     For Saving Configuration:
	 1.Click on ‘File’ button
	 2.Click on ‘Save Config’ button
	 3.Save at desired location
     For Classification:
   	 1.Click on ‘File’ button.
	 2.Click on ‘Select Config’ button
	 3.Select desired config file
	 4.Click on ‘Select Test File’ button
	 5.Select desired test file
 	 6.Click on ‘Classify 1 line’ button to classify line by line. User can see the 
	   inputs and outputs on right and left side.
	   OR
	   Click on ‘Classify’ button to classify the entire test file. An final SSE would
	   be displayed at the bottom after ‘Error:’


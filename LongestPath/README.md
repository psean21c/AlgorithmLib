# Longest Path Finder

	 * Method will recursively call this method itself until it finds end.
	 * There are two conditions which this method will end.
	 * (1) No route any more
	 * (2) Found out the final destination
	 * 
	 * [Simple Diagram] (N) means weight for the edge
	 * ===========
	 *   (2)  (1)
	 * A----B----X
	 * |
	 * |(2) 
	 * E    
	 * ===========


	 * Requirement: 
	 *   Find out "the longest route" starting from 'A' to the destination 'X'
	 *   The weight for the route; 2 for A - B, A - E and 1 for B - X 

---
#### Simple Diagram
![path1](https://cloud.githubusercontent.com/assets/5623445/19821397/1b984adc-9d2c-11e6-8dbf-a1d67c4667f2.png)

#### More complcated Diagram
![path2](https://cloud.githubusercontent.com/assets/5623445/19821399/1b9b2554-9d2c-11e6-9676-5f0f437545d4.png)


#### Diagram Note
![path3](https://cloud.githubusercontent.com/assets/5623445/19821398/1b99544a-9d2c-11e6-80b1-c03f3d870a2f.png)

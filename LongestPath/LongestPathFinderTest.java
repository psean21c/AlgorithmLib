import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

/***
Author: Simon Park
***/

public class LongestPathFinderTest {

	// 1) Sample data 1 (Small Diagram)
	private Set<String> setPilot1 = new HashSet<String>();
	private Set<String> setPilot2 = new HashSet<String>();
	private Set<String> setPilot3 = new HashSet<String>();
	private Set<String> setPilot4 = new HashSet<String>();
	private Set<String> setPilot5 = new HashSet<String>();
	private Set<String> setPilot6 = new HashSet<String>();
	private Set<String> setPilot7 = new HashSet<String>();
	private Set<String> setPilot8 = new HashSet<String>();
	private Set<String> setPilot9 = new HashSet<String>();
	private Set<String> setPilot10 = new HashSet<String>();
	private HashMap<Set<String>,Integer> graphPilot = new HashMap<Set<String>,Integer>();

	
	// 2) Sample data 2 (Big Diagram)
	private Set<String> set1 = new HashSet<String>();
	private Set<String> set2 = new HashSet<String>();
	private Set<String> set3 = new HashSet<String>();
	private Set<String> set4 = new HashSet<String>();
	private Set<String> set5 = new HashSet<String>();
	private Set<String> set6 = new HashSet<String>();
	private Set<String> set7 = new HashSet<String>();
	private Set<String> set8 = new HashSet<String>();
	private Set<String> set9 = new HashSet<String>();
	private Set<String> set10 = new HashSet<String>();

	private Set<String> set11 = new HashSet<String>();
	private Set<String> set12 = new HashSet<String>();
	private Set<String> set13 = new HashSet<String>();
	private Set<String> set14 = new HashSet<String>();
	private Set<String> set15 = new HashSet<String>();
	private Set<String> set16 = new HashSet<String>();
	private Set<String> set17 = new HashSet<String>();
	private Set<String> set18 = new HashSet<String>();
	private Set<String> set19 = new HashSet<String>();
	private Set<String> set20 = new HashSet<String>();

	private Set<String> set21 = new HashSet<String>();
	private Set<String> set22 = new HashSet<String>();
	private Set<String> set23 = new HashSet<String>();
	private Set<String> set24 = new HashSet<String>();
	private Set<String> set25 = new HashSet<String>();
	private Set<String> set26 = new HashSet<String>();
	private Set<String> set27 = new HashSet<String>();
	private Set<String> set28 = new HashSet<String>();
	private Set<String> set29 = new HashSet<String>();
	private Set<String> set30 = new HashSet<String>();

	private Set<String> set31 = new HashSet<String>();
	private Set<String> set32 = new HashSet<String>();
	private Set<String> set33 = new HashSet<String>();
	private Set<String> set34 = new HashSet<String>();
	private Set<String> set35 = new HashSet<String>();
	private Set<String> set36 = new HashSet<String>();
	private Set<String> set37 = new HashSet<String>();
	private Set<String> set38 = new HashSet<String>();
	private Set<String> set39 = new HashSet<String>();
	private Set<String> set40 = new HashSet<String>();

	private Set<String> set41 = new HashSet<String>();
	private Set<String> set42 = new HashSet<String>();
	private Set<String> set43 = new HashSet<String>();
	private Set<String> set44 = new HashSet<String>();
	private Set<String> set45 = new HashSet<String>();
	private Set<String> set46 = new HashSet<String>();
	private Set<String> set47 = new HashSet<String>();
	private Set<String> set48 = new HashSet<String>();
	private Set<String> set49 = new HashSet<String>();
	private Set<String> set50 = new HashSet<String>();

	private HashMap<Set<String>,Integer> graph = new HashMap<Set<String>,Integer>();
	LongestPathFinder longPath = null;

	
	@Before
	public void setUp() throws Exception {
		longPath = new LongestPathFinder();
		initializeSmallGraph();
		initializeBigGraph();
	}
	
	@Test
	public void testRunGraph(){
		runBigGraph();
		runSmallGraph();
	}

	@Test
	public void testFindNextEdge() {
		String start = "A";
		HashMap<Set<String>,Integer> nextEdge = longPath.findNextEdge(start,graphPilot);
		longPath.showMap(nextEdge);

		String startBig = "A1";
		HashMap<Set<String>,Integer> nextEdgeBig = longPath.findNextEdge(startBig,graph);
		longPath.showMap(nextEdgeBig);
		
	}

	@Test
	public void testShowList(){
		showList();
	}
	
	public HashMap<List<String>,Integer> showList(){
		HashMap<List<String>,Integer> routeList = new HashMap<List<String>,Integer>();
		
		Integer iValue = 1;
		List<String> lst = new ArrayList();
		lst.add("A");
		lst.add("B");
		lst.add("C");
		routeList.put(lst, iValue);

		longPath.showList(routeList);

		
		iValue = 2;
		routeList.put(lst, iValue);

		longPath.showList(routeList);
		
		return routeList;
	}
	
	/**
	 * 
	 */
	public void runBigGraph(){
		String start = "A1";
		String end = "X";
    	HashMap<List<String>,Integer> routeMemory = startRoute(start);
    	
    	longPath.findPath(start, end, graph, routeMemory);
		
	}

	/**
	 * 
	 */
	public void runSmallGraph(){
		String start = "A";
		String end = "X";
    	HashMap<List<String>,Integer> routeMemory = startRoute(start);
    	
    	longPath.findPath(start, end, graphPilot, routeMemory);
		
	}

	
	/**
	 * 
	 */
	private HashMap<List<String>,Integer> startRoute(String start){
		HashMap<List<String>,Integer> routeMemory = new HashMap<List<String>,Integer>();
    	List<String> lst = new ArrayList();
    	lst.add(start);
    	routeMemory.put(lst, 0);
		
		return routeMemory;
	}
	
	
	/**
	 * 
	 */
	private void initializeBigGraph() {
    	set1.add("A1");
    	set1.add("A2");  // 3

    	set2.add("A1");
    	set2.add("A11"); // 6
    	
   	  	set3.add("A2");
    	set3.add("A3"); // 6

    	set4.add("A2");
    	set4.add("A6"); // 3

    	set5.add("A3");
    	set5.add("A4"); // 6

    	set6.add("A3");
    	set6.add("A8"); // 3

    	set7.add("A4");
    	set7.add("A5"); // 3

    	set8.add("A4");
    	set8.add("A10"); // 3

    	set9.add("A5");
    	set9.add("A14"); // 6

    	set10.add("A6");
    	set10.add("A7"); // 3
    	
     	set11.add("A6");
    	set11.add("A12");  // 3

    	set12.add("A7");
    	set12.add("A8"); // 3

   	  	set13.add("A7");
    	set13.add("A16"); //6
         
    	set14.add("A8");
    	set14.add("A9"); //3
         
    	set15.add("A8");
    	set15.add("A17"); //6
         
    	set16.add("A9");
    	set16.add("A10"); //3
         
    	set17.add("A9");
    	set17.add("A18"); //6
         
    	set18.add("A10");
    	set18.add("A13"); //3
         
    	set19.add("A11");
    	set19.add("A12"); //3
         
    	set20.add("A11");
    	set20.add("A20"); //6
    	    	
     	set21.add("A12");
    	set21.add("A15");  // 3
         
    	set22.add("A13");
    	set22.add("A14"); // 3
         
   	  	set23.add("A13");
    	set23.add("A19"); //3
         
    	set24.add("A14");
    	set24.add("A23"); // 6
         
    	set25.add("A15");
    	set25.add("A16"); //3
         
    	set26.add("A15");
    	set26.add("A21"); //3
         
    	set27.add("A16");
    	set27.add("A17"); //3
         
    	set28.add("A16");
    	set28.add("A25"); // 6
         
    	set29.add("A17");
    	set29.add("A18"); //3
         
    	set30.add("A17");
    	set30.add("A26"); // 6

     	set31.add("A18");
    	set31.add("A19");   //3

    	set32.add("A18");
    	set32.add("A27");  // 6

    	set33.add("A19");
    	set33.add("A22");  // 3

    	set34.add("A20");
    	set34.add("A21");  //3

    	set35.add("A20");
    	set35.add("A29");  // 6

    	set36.add("A21");
    	set36.add("A24");  // 3

    	set37.add("A22");
    	set37.add("A23");  // 3

    	set38.add("A22");
    	set38.add("A28");  // 3

    	set39.add("A23");
    	set39.add("X");  // 6

    	set40.add("A24");
    	set40.add("A25");  // 3

    	set41.add("A24");
    	set41.add("A30");  // 3

    	set42.add("A25");
    	set42.add("A26");  // 3

    	set43.add("A26");
    	set43.add("A27");  // 3

    	set44.add("A26");
    	set44.add("A31");  // 3

    	set45.add("A27");
    	set45.add("A28");  // 3

    	set46.add("A28");
    	set46.add("A32");  // 3

    	set47.add("A29");
    	set47.add("A30");  // 3

    	set48.add("A30");
    	set48.add("A31");  // 6

    	set49.add("A31");
    	set49.add("A32");  // 6

    	set50.add("A32");
    	set50.add("X");  // 3
    	
    	graph.put(set1,  3);
    	graph.put(set2,  6);
    	graph.put(set3,  6);
    	graph.put(set4,  3);
    	graph.put(set5,  6);
    	graph.put(set6,  3);
    	graph.put(set7,  3);
    	graph.put(set8,  3);
    	graph.put(set9,  6);
    	graph.put(set10, 3);
    	graph.put(set11, 3);
    	graph.put(set12, 3);
    	graph.put(set13, 6);
    	graph.put(set14, 3);
    	graph.put(set15, 6);
    	graph.put(set16, 3);
    	graph.put(set17, 6);
    	graph.put(set18, 3);
    	graph.put(set19, 3);
    	graph.put(set20, 6);
    	graph.put(set21, 3);
    	graph.put(set22, 3);
    	graph.put(set23, 3);
    	graph.put(set24, 6);
    	graph.put(set25, 3);
    	graph.put(set26, 3);
    	graph.put(set27, 3);
    	graph.put(set28, 6);
    	graph.put(set29, 3);
    	graph.put(set30, 6);
    	graph.put(set31, 3);
    	graph.put(set32, 6);
    	graph.put(set33, 3);
    	graph.put(set34, 3);
    	graph.put(set35, 6);
    	graph.put(set36, 3);
    	graph.put(set37, 3);
    	graph.put(set38, 3);
    	graph.put(set39, 6);
    	graph.put(set40, 3);
    	graph.put(set41, 3);
    	graph.put(set42, 3);
    	graph.put(set43, 3);
    	graph.put(set44, 3);
    	graph.put(set45, 3);
    	graph.put(set46, 3);
    	graph.put(set47, 3);
    	graph.put(set48, 6);
    	graph.put(set49, 6);
    	graph.put(set50, 3);

	}
	
	private void initializeSmallGraph() {
    	
    	setPilot1.add("A");
    	setPilot1.add("B");

    	setPilot2.add("A");
    	setPilot2.add("F");

    	setPilot3.add("B");
    	setPilot3.add("C");

    	setPilot4.add("B");
    	setPilot4.add("D");

    	setPilot5.add("C");
    	setPilot5.add("E");

    	setPilot6.add("D");
    	setPilot6.add("E");

    	setPilot7.add("D");
    	setPilot7.add("G");

    	setPilot8.add("E");
    	setPilot8.add("X");

    	setPilot9.add("F");
    	setPilot9.add("G");

    	setPilot10.add("G");
    	setPilot10.add("X");
    	
    	graphPilot.put(setPilot1, 1);
    	graphPilot.put(setPilot2, 2);
    	graphPilot.put(setPilot3, 2);
    	graphPilot.put(setPilot4, 1);
    	graphPilot.put(setPilot5, 1);
    	graphPilot.put(setPilot6, 2);
    	graphPilot.put(setPilot7, 1);
    	graphPilot.put(setPilot8, 1);
    	graphPilot.put(setPilot9, 1);
    	graphPilot.put(setPilot10, 2);
        
    }
	
}

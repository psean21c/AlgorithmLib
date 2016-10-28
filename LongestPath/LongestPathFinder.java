
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class LongestPathFinder {
	
	public static int cntFound = 0;
	public static int maxValue = 0;

	LongestPathFinder() {}

	/**
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
	 * Basic Step
	 * (0) Make the table with data structure(key=<Set>,value=weight) describing the graph, <A,B>=2, <A,E>=2, <B,X>=1
	 * (1) Read two Route <A,B>, <A,E> because the route starts with 'A'
	 * (2) Start <A,B> first, 
	 *     It will continue with <A,E> ONLY after the method will finish all depending recursive calls for <A,B>.
	 *  (2-1) Remove <A,B> from the table and call the findPath() method recursively
	 *     Now the remaining data in the table are; <A,E>=2, <B,X>=1
	 *  (2-2) Find out other route having the node 'B'
	 *     <B,X>=1 is the only remaining route
	 *  (2-3) validate X is the destination, End this recursion
	 * (3) Start <A,E> second,
	 *  (3-1) Remove <A,E> and remaining routes are; <A,B>=2, <B,X>=1
	 *  (3-2) Try to find out other route starting with 'E' -> No return 
	 *  (3-3) No result means the route is lost, so it has to be ended.
	 *  
	 */
	public int findPath(String start, String end, 
			HashMap<Set<String>,Integer> graphMap, HashMap<List<String>,Integer> routeMemory) {
        //System.out.println("+++++++++++++++++++++++++++++++++++++ findPath +++++++++++++++++++++++++++++++++++++");
        HashMap<Set<String>,Integer> nextMap = new HashMap<Set<String>,Integer>();
       
        try {
 	        nextMap = findNextEdge(start,graphMap);
	        
	        if(nextMap.size() == 0 ) {
	        	//System.out.println(" ++++ Blocked because of no other way around!! +++++" );
	        } else {
				for(Entry<Set<String>,Integer> edges: nextMap.entrySet()) {
			        HashMap<Set<String>,Integer> newNextMap = new HashMap<Set<String>,Integer>();
			        HashMap<List<String>,Integer> routeMap = new HashMap<List<String>,Integer>();
			        int accumulateValue = 0;
					boolean isFound = false;
					String newStart = null;
					//System.out.println("edges:" + edges + ",key=" + edges.getKey() + ",value=" + edges.getValue());
					int weight = edges.getValue();
					
					List<String> lst = new ArrayList();
					
					for(Entry<List<String>,Integer> entries:routeMemory.entrySet()) {
						//System.out.println("key" + entries.getKey() +  ",value=" + entries.getValue());
						for(String entry: entries.getKey()) {
							//System.out.println("entry:" + entry);
							lst.add(entry);
						}
						accumulateValue = entries.getValue();
					}
					accumulateValue = accumulateValue + weight;
					
					for(String edge: edges.getKey()) {
						//System.out.println("edge:" + edge);
						if(!edge.equalsIgnoreCase(start)) {
							newStart = edge;
							lst.add(edge);
						} 
						if(edge.equalsIgnoreCase(end)) {
							isFound = true;
						}
					}
					//System.out.println(idxCall + ",route:" + start + "->" + newStart);
					routeMap.put(lst, accumulateValue);
					if(!isFound) {
						newNextMap = removeCurrentEdge(edges.getKey(),graphMap);
						findPath(newStart,end,newNextMap,routeMap);
					} else {
						int currentValue = 0;
						for(Entry<List<String>,Integer> entries: routeMap.entrySet()) {
							currentValue = entries.getValue();
						}
						if(currentValue >= maxValue) {
							// If bigger value found, reset the counter = 0
							if(currentValue > maxValue) cntFound = 0;
							cntFound++;
							System.out.print(cntFound + "th FOUND! ");
							showList(routeMap);
							maxValue = currentValue;
						}
					}
		
				}	
	        }
        } catch (Exception e) {
        	
        }
        
        
        return 0;
	}


	
	/**
	 * 
	 */
	public HashMap<Set<String>,Integer> removeCurrentEdge(Set<String> current, HashMap<Set<String>,Integer> graphMap){  
        HashMap<Set<String>,Integer> nextMap = new HashMap<Set<String>,Integer>();
        
        try {
			for(Entry<Set<String>,Integer> edges: graphMap.entrySet()) {
	
				//System.out.println("edges:" + edges + ",key=" + edges.getKey() + ",value=" + edges.getValue());
				if(edges.getKey().equals(current)) {
					//System.out.println("" + edges + ",key=" + edges.getKey() + ",value=" + edges.getValue());
				} else {
					nextMap.put(edges.getKey(),edges.getValue());
				}
			} 
	    } catch (ConcurrentModificationException e) {
        	System.out.println("ConcurrentModificationException=" + e);
	    } catch (Exception e) {
        	System.out.println("e=" + e);
        }
		
		return nextMap;
    }
	
	
	/**
	 * 
	 */
	public HashMap<Set<String>,Integer> findNextEdge(String start, HashMap<Set<String>,Integer> graphMap){  
        //System.out.println("++++++ finder ++++++++++++++++++++++");
        HashMap<Set<String>,Integer> nextMap = new HashMap<Set<String>,Integer>();
		for(Entry<Set<String>,Integer> edges: graphMap.entrySet()) {
			boolean isFound = false;
			
			for(String edge: edges.getKey()) {
				//System.out.println("edge:" + edge);
				if(edge.equalsIgnoreCase(start)) isFound = true;
			}
			//System.out.println("edges:" + edges + ",key=" + edges.getKey() + ",value=" + edges.getValue() + ",Found=" + isFound);
			
			if(isFound) {
				nextMap.put(edges.getKey(),edges.getValue());
			}
		}
		
		return nextMap;
    }

	
	/**
	 * 
	 */
	public void showList(HashMap<List<String>,Integer> routeMap){
		
		for(Entry<List<String>,Integer> entries: routeMap.entrySet()) {
			System.out.println("Route=" + entries.getKey() +  ",weight=" + entries.getValue());
			//for(String entry: entries.getKey()) System.out.println("entry:" + entry);
		}
	}

	/**
	 * 
	 */
	public void showMap(HashMap<Set<String>,Integer> graphMap){
		
		System.out.println("++++++++++++++ showMap ++++++++++++++++++++");
		
		for(Entry<Set<String>,Integer> edges: graphMap.entrySet()) {
			System.out.println("edges:" + edges);
			//System.out.println("key=" + edges.getKey() + ",value=" + edges.getValue());
			//for(String edge: edges.getKey()) System.out.println("edge:" + edge);
		}
		
	}
	
}

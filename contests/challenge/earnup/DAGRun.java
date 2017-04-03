import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DAGRun {
	
	/*** 1) Read the file and build up the DAG graph
		 2) Cycle Test, Print 
	***/
	static void buildGraph(File file) {
		FileInputStream fstream;
		DirectedGraph dag = new DirectedGraph();

		try {
			
			// Read the file and build the DAG graph
			Scanner scan = new Scanner(file);

			int vertex = scan.nextInt();
			int edge = scan.nextInt();

			for (int i = 0; i < edge; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				dag.insertNode(x, y);
			}
			
			// Cycle Test
			System.out.println("Test if 4->1 will create a cycle: ");
			boolean cycle = dag.isCycled(4, 1);
			
			// Print DAG at level
			dag.printNode(0);

			scan.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
            System.out.println("no arguments were given.");
		}
		
		File file = new File(args[0]);		
		buildGraph(file);
	}

}

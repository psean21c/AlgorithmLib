import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/***
Author: Simon Park
***/
class Checker implements Comparator<Player> {

	public int compare2(Player p1, Player p2) {
		if (p1.score > p2.score) return -1;
		else if (p1.score < p2.score) return 1;
		else return 0;
	}

	@Override
	public int compare(Player p1, Player p2) {
		if (p1.score == p2.score) return p1.name.compareTo(p2.name);
		else return p2.score - p1.score;
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class PlayerSort {

	public static void main(String[] args) {
		run();
	}
	static void run(){
		
		Checker checker = new Checker();
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		Player[] player = new Player[Q];
		for(int i=0;i<Q;i++){
			String name = in.next();
			int score = in.nextInt();
			player[i] = new Player(name, score);
			
		}
		System.out.println("==================Before sorting==================");
		printPlayers(player);
		System.out.println("==================After sorting==================");
		Arrays.sort(player, checker);
		printPlayers(player);

	}
	
	static void printPlayers(Player[] player){
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
	
}

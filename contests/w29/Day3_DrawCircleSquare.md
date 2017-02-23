
```
50 40
5 20 3
2 6 12 4

50 40
3 4 1
12 16 18 14


50 40
9 6 7
18 15 10 15

50 40
9 26 5
2 6 8 4

20 16
9 6 5
16 14 8 14
```

```java

import java.util.Scanner;



public class C {

	static double len = 0;
    public static void main(String[] args) {
    	run();

    }	
    
    static void run(){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int cx = in.nextInt();
        int cy = in.nextInt();
        int r = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();
        // your code goes here
        int x0 =(x1 + x3) / 2;
        int y0 =(y1 + y3) / 2;
        int x2 = x0 + y0 - y3;
        int y2 = x3 - x0 + y0;
        int x4 = x0 + y0 - y1;
        int y4 = x1 - x0 + y0;
//		System.out.println("(x0,y0)" + x0 + "," + y0 );
//		System.out.println("(x1,y1)" + x1 + "," + y1 );
//		System.out.println("(x2,y2)" + x2 + "," + y2 );
//		System.out.println("(x3,y3)" + x3 + "," + y3 );
//		System.out.println("(x4,y4)" + x4 + "," + y4 );
        len = Math.pow(Math.abs((y1 -y0)),2) + Math.pow(Math.abs((x1 -x0)),2);
        
        boolean inCircle =false;
        boolean inSquare = false;
        for(int i=0;i<y;i++){
        	for(int j=0;j<x;j++){
        		inCircle = insideCircle(r,j,i,cx,cy);
//        		if(j==9 & i>=10) System.out.println(j + "," + i);
        		inSquare = insideSquare(j,i,x0,y0,x1,y1,x2,y2,x3,y3,x4,y4);
        		if(inCircle | inSquare) System.out.print("#");
        		else System.out.print(".");
        	}
        	System.out.println();
        }
    	
    }
	static int direction(int aX, int aY, int bX, int bY, int cX, int cY){
		int dxAB = bX - aX;
		int dyAB = bY - aY;
		int dxAC = cX - aX;
		int dyAC = cY - aY;
		
		int dir = 0;
		if(dxAB*dyAC < dyAB*dxAC) dir = 1; // clockwise
		if(dxAB*dyAC > dyAB*dxAC) dir = -1; // counter clock-wise
		if(dxAB*dyAC == dyAB*dxAC){
			if(dxAB ==0 && dyAB ==0) dir =0;
			if((dxAB*dxAC<0) || (dyAB*dyAC<0)) dir = -1;
			else if((dxAB * dxAB + dyAB*dyAB) >= (dxAC*dxAC + dyAC*dyAC)) dir =0;
			else dir = 1;
		}
		return dir;
	}

	static boolean intersectLine(int x,int y,int x0,int y0,int x1,int y1,int x2,int y2){
		int dir1 = direction(x,y,x0,y0,x1,y1);
		int dir2 = direction(x,y,x0,y0,x2,y2);
		int dir3 = direction(x1,y1,x2,y2,x,y);
		int dir4 = direction(x1,y1,x2,y2,x0,y0);
		
		boolean intersect = false;
		if((dir1 * dir2 < 0) && (dir3 * dir4 < 0)) intersect = true;
	
		return intersect;
	}
	
	static boolean insideSquare(
			int x,int y,int x0,int y0,
			int x1,int y1,int x2,int y2,
			int x3,int y3,int x4,int y4){
		boolean isIntersect1 = intersectLine(x,y,x0,y0,x1,y1,x2,y2);
		boolean isIntersect2 = intersectLine(x,y,x0,y0,x2,y2,x3,y3);
		boolean isIntersect3 = intersectLine(x,y,x0,y0,x3,y3,x4,y4);
		boolean isIntersect4 = intersectLine(x,y,x0,y0,x4,y4,x1,y1);
		
		boolean isOutRange = outRange(x,y,x0,y0);
		
		if(isIntersect1 | isIntersect2 | isIntersect3 | isIntersect4) return false;
		else if(isOutRange) return false;
		else return true;
	}    
	
	static boolean outRange(int x,int y,int x0,int y0){
        double len2 = Math.pow(Math.abs((y -y0)),2) + Math.pow(Math.abs((x -x0)),2);
        if(len2 > len) return true;
        else return false;
	}
	
	static boolean insideCircle(int r,int x,int y,int cx,int cy){
		double len = Math.pow((x-cx), 2) + Math.pow((y-cy), 2);
		double rad = Math.pow(r, 2);
		if(rad >= len) return true;
		else return false;
	}

}

```

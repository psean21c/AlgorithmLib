
### Day-1

Warm up
```java
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int m = in.nextInt();
        int t = c * m;
        int[] p = new int[n];
        boolean isBoat = true;
        for(int i=0; i < n; i++){
            p[i] = in.nextInt();
            if(p[i]>t){
            	isBoat = false;
            	break;
            }
        }
        if(isBoat) System.out.println("Yes");
        else System.out.println("No");
    }
```

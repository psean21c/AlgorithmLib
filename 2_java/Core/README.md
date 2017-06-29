

range of INT : 
minimum value of -2^31 ( = 2,147,483,648) 
maximum value of 2^31 -1 ( = 2,147,483,647)
  


range of LONG : 
minimum value of -2^63 ( = 9.223372 x 10^18)
maximum value of 2^63 - 1


### Generic
```
class Printer{}


public class Person {


    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = scanner.nextInt();
        }

        n = scanner.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = scanner.next();
        }

        Printer<Integer> intPrinter = new Printer<Integer>();
        Printer<String> stringPrinter = new Printer<String>();
        intPrinter.printArray( intArray  );
        stringPrinter.printArray( stringArray );
        if(Printer.class.getDeclaredMethods().length > 1){
            System.out.println("The Printer class should only have 1 method named printArray.");
        }
    }

}

```

Solution
```
1)
class Printer <T> {

    void printArray(T[] inputArray) {
        for(T t:inputArray){
            System.out.println(t);
        }
    }
}

2) 

class Printer
{
   //Write your code here
 	static <T> void printArray(T[] inputArray){
		for(T e: inputArray){
			System.out.println(e);
		}
	}
}

```

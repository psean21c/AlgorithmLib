
### Java Comparator
[Original Question](https://www.hackerrank.com/challenges/java-comparator)


input
```
10
ab 6
ab 7
ab 5
bcc 0
cba 2
cab 2
def 0
bcc 2
b 0
a 0
```

---

output
```
==================Before sorting==================
ab 6
ab 7
ab 5
bcc 0
cba 2
cab 2
def 0
bcc 2
b 0
a 0
==================After sorting==================
ab 7
ab 6
ab 5
bcc 2
cab 2
cba 2
a 0
b 0
bcc 0
def 0

```

### java Sort

[Original Question](https://www.hackerrank.com/challenges/java-sort)

input
```
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76
```

output
```
Ashis
Fahim
Samara
Samiha
Rumpa
```

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class Student{
	int id;
	String fname;
	double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

}



public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while (T-- > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			// System.out.println(id + ":" + fname + ":" + cgpa);
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
		}

//		for (Student st : studentList) {
//			System.out.println(st.getFname());
//		}
//		
//		System.out.println("++++++++++++++++++++=");
		Sorter sorter = new Sorter();
		Collections.sort(studentList,sorter);
		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
	}
}

```

Solution
```java

class Sorter implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
//		System.out.println(s1.fname + ":" + s1.cgpa + " vs " + s2.fname + ":" + s2.cgpa);
		if(s1.cgpa == s2.cgpa) return (s1.id > s2.id? 1:-1);
		else return (s1.cgpa > s2.cgpa? -1 : 1);
	}

}

```

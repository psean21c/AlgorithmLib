===========================
Abstract for EarnUp
===========================
Author : Simon Park
Start: Jan-28, 10:50 AM (2017)
End  : Jan-29, 08:30 AM


===========================
File Structures & Overview
===========================
If you unzip the file, 
earnup\
       -\quiz1\-ReverseArray.java
	   
       -\quiz2\-WordCount.java
	           -romeo.txt
			   
       -\quiz3_4\-ReturnRandom.java
	   
       -\quiz6\-DAGRun.java
	           -DirectedGraph.java
	           -graph.txt
	           -graph2.txt
			   
       -README.txt

In order to run each program, Open DOS command line, 
Go to the each folder of quiz#
===========================
1) Reversed Array
===========================
DOS>cd quiz1	   

DOS>javac ReverseArray.java
DOS>java ReverseArray
output
------------
string2beReversed



===========================
2) Count Words in a text file
===========================

DOS>javac WordCount.java
DOS>java WordCount romeo.txt

output
------------
29		I
17		the
14		Nurse
14		it
13		and
12		a
12		my
11		of
10		Wife
8		to
8		not
...

===========================
3) M random non-negative integer < N : randomIntegers()
4) M random elements of array		: randomArray()
===========================
DOS>javac ReturnRandom.java
DOS>java ReturnRandom
output
------------
13 [2, 3, 7, 12, 13, 17, 18, 20, 22, 23, 25, 29, 30]

[3, 4, 5, 6, 7, 9, 10, 14, 15, 16, 18, 19, 20, 22, 24]
d e f g h j k o p q s t u w y


===========================
6) How a DNS server works.
===========================
DOS>javac DAGRun.java
DOS>java DAGRun graph.txt
output
------------
Test if 4->1 will create a cycle:
At 1 level :    1
At 2 level :    2 3 4
At 3 level :    5 6

DOS>java DAGRun graph2.txt
output
------------
Not able to insert because 4->1 will cause Cycle
Test if 4->1 will create a cycle:
At 1 level :    1
At 2 level :    2 3
At 3 level :    4


===========================
5) How a DNS server works.
===========================
The DNS(Domain Name System) is the human readable hostname address.
In real situation, Server communicates each other only with IP addresses (based on IPv4 or IPv6).

There are two main reasons why we have advantages to use the DNS.
1) More human readable
When users try to visit one website (i.e. www.earnup.com), they only need to know the domain.
DNS server takes care of tracing the IP and forward the link through the routers.

2) The server can run and accommodate more than one domain service on the same server.
http://www.earnup.com/ 104.197.96.181
http://www.earnup1.com/ 104.197.96.181
http://www.earnup2.com/ 104.197.96.181

Below is the brief explanation how it works.
1) When users visit one domain address, it will request to ISP(Internet Service Provider) DNS Servers.
(i.e. AT&T in USA Rogers in Canada are one of main ISP service companies)

2) In the groups of DNS servers, they are hierarchy structured.
The first DNS server which receives the request, it search internal lookup tables first.
If it finds it, it will forward the IP address to the client.
If not, it will go up to the upper level of DNS and keep searching the lookup table.

3) Because they are also connected with ISP companies, it will be-synced on a regular basis.
If one ISP doesn't have the domain, it will ask its neighbours until it finds it.

4) Once client finds out the IP address for the domain, it will request to router to make the proper route to the destination IP address.


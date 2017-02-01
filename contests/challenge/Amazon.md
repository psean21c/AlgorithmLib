
```java
// Write a function that will execute a set of tasks in dependency order. For example, given the following tasks
// [{"id": 1, "depends": [2,3]}, {"id": 2, "depends": []},{"id": 3, "depends": [2,4]}, {"id": 4, "depends": []}]
// The order in which they should be executed is as follows:
// order: 2, 4, 3, 1
// order: 4, 2, 3, 1
/*
 Before running 1, run its dependencies [2,3]
 before running 2, run its dep...
 
 1 -> (2,3) , 2 -> "2" 3-> (2,4) -> "4", 
        3 -> 
        
{"id": 1, "depends": [1,2,3,4,5.... n]}      // O(n*m)
n is the number of depends for all object..
number of id : m
 */

static HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
static boolean[] visited = new boolean[map.size()]; // initialized all falsed

boolean isEmpty(i){
    List<Integer> lst= map.get(i);
    if(lst.size()==0) return true;
    else return false;
}

void dfs(int i){ // DFS(Depth First Search)
    if(visited[i]) return;
    
    if(isEmpty(i)) {
        System.out.println(i); // print id having empty array
        return;
    }
    List<Integer> lst= map.get(i);
    for(Integer l:lst){
        dfs(l);
    }
    visited[i] = true; 
}


static dependOrder(){
    Integer key = map.entryKey();

    for(int i=0;i<len;i++){ 
        dfs(i);
    }
}
```

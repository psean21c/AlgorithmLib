import java.util.*;


/**
 * Created by sergiu.filip on 9/1/2016.
   My friend - Sergui - made a great solution. It is worth studying his code
 */
public class SumPower {
    int theSum;


    class Items{
        ArrayList<Integer> items;


        Items(Integer val){
            items = new ArrayList<>();
            items.add(val);
        }


    public Items(ArrayList<Integer> it) {
        items = new ArrayList<>();
        items.addAll(it);
    }


    @Override
    public String toString() {
        return items+"";
    }


        int hash(){
            return items.hashCode();
        }
    }
    
    class Sum{
        Integer element;
        //List<Integer> list;
        int count;


        Sum(Integer i){
            this.element = i;
            count = 1;
        }


        public Sum(Sum s, Integer number) {
            this.element = s.element+number;
            count = s.count;


        }


        @Override
        public boolean equals(Object obj){
            Sum s = (Sum)obj;
            return s.element.intValue() == element.intValue();
        }


    @Override
    public String toString() {
        return "{"+element +" " + count +'}';
    }
}






    List<Integer> possibleNumbers;
    HashSet<Sum> sums;


    void check(int sum, int power){
        this.theSum  = sum;


        long time1 = System.currentTimeMillis();
        possibleNumbers = getNumbers(sum, power);


        sums = new HashSet<Sum>();


        System.out.println("FOR ("+sum+", "+power+") - will check #"+possibleNumbers.size());
        HashSet<Sum> results = findSolution(possibleNumbers.size()-1,sums);
        long time2 = System.currentTimeMillis();
        System.out.println("Number of solutions "+getSolution(results)+" time: "+(time2-time1)+"msec \n\n");


    }


    private Integer getSolution(HashSet<Sum> results ){
        for(Sum s: results){
            if(s.element == theSum){


                return s.count;
            }
        }
        return 0;
    }


    private HashSet<Sum> findSolution(int i,HashSet<Sum> sums) {
        if(i < 0){
            return sums;
        }


        HashSet<Sum> newSums_ = new HashSet<Sum>();


        int number = possibleNumbers.get(i);


        if(number <= theSum){
            addElement(newSums_, new Sum(number));


        }




        for(Sum s: sums){
            addElement(newSums_, s);


            int sum = s.element+number;


            if(sum <= theSum){
                addElement(newSums_, new Sum(s, number));
            }
        }


        return findSolution(i - 1,newSums_);
    }




    private void addElement(Set<Sum> newSums, Sum el){
        for(Sum s: newSums){
            if(s.equals(el)){
                s.count += el.count;
                return;
            }
        }
        newSums.add(el);
    }


    private List<Integer> getNumbers(int sum, int power) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<sum;i++){
            int val = (int) Math.pow(i,power);
            if(val <= sum){
                list.add(val);
            }else{
                break;
            }
        }
        return list;
    }


    public static void main(String[] s){
    	SumPower obj = new SumPower();
        obj.check(8000,2);


//        obj.check(10,2);
//        obj.check(100,3);
//        obj.check(100,2);
//        obj.check(800,2);
//        obj.check(1000,10);
//        obj.check(400,2);
    }
}



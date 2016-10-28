import scala.util.control.Breaks._


object Solution {


    var cntFount:Int = 0;
    var targetSum:Int = 0;


    def numberOfWays(X:Int,N:Int):Int = {
  
        val max = maxNumber(X,N)
        
        var candidateList: List[Int] = Nil
        targetSum = X;
        
        for(i <- 1 to max){ 
          var x :Int = powerOperator(i,N)
          if(x <= X) candidateList = candidateList :+ x
        }
        var candidateReverse: List[Int] = candidateList.reverse


        sumPower(X, candidateReverse)
        return cntFount
      }
    


    def sumPower(finalSum:Int, candidateList: List[Int]): Int = {
      var firstLst:Int = candidateList(0)
      var delta:Int = finalSum - firstLst
      
      var subList:List[Int] = subCandidateList(candidateList)
      var sumOfList:Int = candidateList.sum
      if(finalSum == firstLst){
        cntFount = cntFount + 1
        if(candidateList.size > 1){
          sumPower(finalSum, subList)
        }
      }
      else {
        if(( finalSum > firstLst) && (candidateList.size > 0)) {
          if(finalSum < sumOfList) {
            sumPower(finalSum -firstLst, subList)
          }
          if((sumOfList - candidateList(0) >= finalSum)) {
            sumPower(finalSum, subList)
          } else if(sumOfList == finalSum) {
            cntFount = cntFount + 1;
            sumPower(finalSum, subList);
          } else {
          }
        }  
        else{
            sumPower(finalSum, subList)
        }
      }
      return cntFount
    }
 
     def subCandidateList(candidateList: List[Int]): List[Int] ={      
      if(candidateList.size == 0) return Nil
      else return candidateList.slice(1,candidateList.size)
    }
     
    
    def maxNumber(finalSum:Int, powerDegree:Int): Int = {
     var power:Int = 0
      var max:Int = 0
      breakable{
        for(i <- 1 to finalSum) {
          max = i
          power = powerOperator(i,powerDegree)
          if(power >= finalSum) break
        }
      }
      return max
    }
    
    def powerOperator(i:Int, powerDegree:Int):Int = {
      if(powerDegree == 1) 
        return i
      else i * powerOperator(i,powerDegree-1)
    }


    def main(args: Array[String]) {
       println(numberOfWays(readInt(),readInt()))
    }
}

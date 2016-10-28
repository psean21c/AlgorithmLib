import scala.util.control.Breaks._


/***
 * version - 1
 * It failed most of test cases, However I was able to learn the basic syntax in Scala
 * especially figured out that it is different to use add operation with List and Set
  1) For loop for List /Set
  2) one line statement 
  3) Opeation add (:+) on List / add(+=) on Set
  4) Permutations
 * You can only learn something valuable from your mistakes
 * 
 */
object Sum {
    def numberOfWays(X:Int,N:Int):Int = {


      //print("X=" + X + ", N=" + N + "\n==================\n")
      val max = maxNumber(X,N)
      
      var candidateList: List[Int] = Nil
      
      for(i <- 1 to max){ 
        var x :Int = powerOperator(i,N)
        if(x <= X) candidateList = candidateList :+ x
      }
      val number:Int = sumPower(X, candidateList)
      println("\nnumber:"+ number)
      return number
    }
    
    def sumPower(X:Int, candidateList: List[Int]): Int = {
      //println("sumPower:" + candidateList)
      for(i <- candidateList) print(i + " ")
      
      var bigSet: Set[Set[Int]] = Set()
      
      //print(candidateList.permutations.mkString("\n"))


      candidateList.permutations.foreach { x => {
        val set = eachPermute(X,x);
        if(set != null) {
          //for(i <- set) println(i);
          bigSet += set
        }
        }
      }


      
      //for(i <- bigSet) println(i)
      val sizeSet:Int = bigSet.size
      //println("sizeSet=" + sizeSet)
      return sizeSet
    }
        
    def eachPermute(X:Int, x: List[Int]): Set[Int] = {
      var sum: Int = 0
      var atoms: Set[Int] = Set()
      
      breakable{
        for(i <-0 until x.length){
          //println(i + ":" + x(i))
          sum = sum + x(i)
          atoms = atoms + x(i)
          if(sum == X) break
        }
      }
      if(sum != X) {
        atoms = null
      }     
      
      return atoms
    }
    
    def maxNumber(X:Int, powerDegree:Int): Int = {
     //val max = Math.sqrt(X).ceil.toInt
     var power:Int = 0
      var max:Int = 0
      breakable{
        for(i <- 1 to X) {
          max = i
          power = powerOperator(i,powerDegree)
          if(power >= X) break
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
       //println(numberOfWays(readInt(),readInt()))
      val x = numberOfWays(100,3)
      //print(x)
    }
}

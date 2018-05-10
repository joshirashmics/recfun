package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    //println(balance("())(".toList));
    //println(countChange(1,List()))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = 
    if(c<0 || c>r)
      return 0 
    else if(r==0)
      return 1 
    else pascal(c, r-1) + pascal(c-1, r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      
      
      
      def balanceIter(remainingString: List[Char], sum: Int) :Boolean ={
        if(sum == -1)
          false
        else if(remainingString.length == 0 && sum == 0)
          true
        else if(remainingString.length == 0 && sum != 0)
          false
        else
         balanceIter(remainingString.tail,sum + {
          if(remainingString.head == '(') 
          1
          else if(remainingString.head == ')')
          -1
          else
          0})
      
        
      }
          
     balanceIter(chars,0);
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      
      var numberOfWays: Int = 0
      def countChangeIter(currentSum: Int , coins: List[Int]):Unit = 
      {
        if(currentSum > money)
          return
        else if(currentSum == money)
          {
          numberOfWays= numberOfWays + 1;
          return;
          }
        else
          {
          for(i <- coins.indices) countChangeIter(currentSum + coins(i),coins.drop(i))
          return;
          }
      }
      countChangeIter(0,coins);
      return numberOfWays;
      
    }
  }

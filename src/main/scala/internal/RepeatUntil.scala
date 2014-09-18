package internal

/**
 * the loop body should execute 10 times and print:
 * 0
 * 2
 * 4
 * 6
 * 8
 */

/*Sadly broken atm: printing out "0" then going into an infinite loop until it runs out of memory*/

object RepeatUntil extends App {
  
    def repeat(x: => Unit):Repeater = {
      new Repeater(x) {}
    }
  
  // define the new control-flow structure here
  class Repeater (body: => Unit){
    
    def until(condition: => Boolean): Unit = {
      if (!condition) {
    	body
        repeat(body) until(condition)
      }
    }
  }
  
  var i = 0
  repeat  {
      if ( (i % 2) == 0 )
          println(i)
      i += 1
  } until(i > 9)        
}


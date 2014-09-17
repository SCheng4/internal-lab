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
  
  // companion class for repeat.
  object repeat {
	def apply(x: => Unit):repeat = {
		new repeat {
			var body:Unit = x
		}
	}
  }
  
  // define the new control-flow structure here
  abstract class repeat {
    var body:Unit
	
    def until(condition: => Boolean): Unit = {
      if (!condition) {
    	body // warning on this line: "a pure expression does nothing in a statement position
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


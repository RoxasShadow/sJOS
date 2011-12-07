Yo dawg, I heard you like OS, so I put an OS in your OS so you can use an OS while you use an OS.
=============================

-----------------------------
*How compile sJOS:

	You need Apache ANT (install it with your package manager (like APT) or http://ant.apache.org/bindownload.cgi)
	
	Go in sjos/ and compile with
	```bash
	ant && ant compile`
	```
	
	You'll find the executable `sJOS.jar` in dist/
	
	To clean, do `ant clean`
	
-----------------------------
*How compile a module:

	You need Apache ANT (install it with your package manager (like APT) or http://ant.apache.org/bindownload.cgi)
	
	Copy the module in modules/src/
	
	Go in modules/ and compile with
	```bash
	ant && ant compile`
	```
	
	Copy the folder modules/modules/ together at sJOS.jar
	
	To clean, do `ant clean`
	
-----------------------------
*Please, when you code a module:

	The input is simply the param `String[] input`. So manage it how you want
	
	Call it with a unique and lowercase word (except for file/class name, which are capitalized), without using symbols (eg.: cat => Cat.java)
	
	Each module musts extends Module class
	
	Follow the pratice used in my modules (eg.: makeHelp, makeVersion, etc)
	
-----------------------------
Happy hacking!

~ Giovanni Capuano <http://www.giovannicapuano.net>

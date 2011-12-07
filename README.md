Yo dawg, I heard you like OS, so I put an OS in your OS so you can use an OS while you use an OS.
=============================

Run Build.sh to compile ModuleCompiler and sJOS.
You need Apache ANT (install it with your package manager (like APT) or http://ant.apache.org/bindownload.cgi).

-----------------------------
How compile a module:

	```bash
	java -jar ModuleCompiler.jar Cat.java Date.java Yes.java [...]
	```
	
	ModuleCompiler will generate a file .class for each module.
	After, move them in a folder called `modules` in the same folder in which is contained sJOS.

	```bash
	java -jar sJOS.jar [+ModuleName]
	```
	
-----------------------------
Please, when you code a module:

	The input is simply the param `String[] input`. So manage it how you want
	Call it with a unique and lowercase word (except for file/class name, which are capitalized), without using symbols (eg.: cat => Cat.java)
	Each module musts extends Module class
	Follow the pratice used in my modules (eg.: makeHelp, makeVersion, etc)
	
-----------------------------
Happy hacking!

~ Giovanni Capuano <http://www.giovannicapuano.net>

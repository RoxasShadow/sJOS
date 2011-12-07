#!/bin/bash
rm -r bin
rm -r bin/modules
mkdir bin
mkdir bin/modules

#sjos
cd sjos
ant
ant compile
cd dist
mv sJOS.jar ../../bin
cd ../
ant clean

#modules
cd ../modules
ant
ant compile
cd modules
mv *.class ../../bin/modules
cd ../
ant clean

echo "Done."

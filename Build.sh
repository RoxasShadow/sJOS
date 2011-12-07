#!/bin/bash
rm -r bin
mkdir bin

#sjos
cd sjos
ant
ant compile
cd dist
mv sJOS.jar ../../bin
cd ../
ant clean
cd ../

#compiler
cd compiler
ant
ant compile
cd dist
mv ModuleCompiler.jar ../../bin
cd ../
ant clean
cd ../

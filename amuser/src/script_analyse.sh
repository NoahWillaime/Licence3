#!/bin/bash

cd analyse
java -jar ../java-cup-11a.jar -parser  AnalyseurSyntaxique -symbols CodeLexicaux Grammaire.cup
java -jar ../jflex-1.6.1.jar AnalyseurLexical.jflex
cd ../
javac -cp java-cup-11a.jar analyse/*.java
java -cp java-cup-11a.jar:. analyse.TestAnalyse fichier.txt

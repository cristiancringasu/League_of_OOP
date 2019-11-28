#!/bin/bash

## CONSTANTS ##
CURRENT_DIRECTORY=`pwd`
RESOURCES_DIRECTORY="$CURRENT_DIRECTORY/checker/resources"
GOOD_TESTS=0
GOOD_CHECKSTYLE=`echo -ne "Starting audit...\nAudit done.\n"`
BAD_CHECKSTYLE=0

## FUNCTIONS ##
function cleanHomework
{
	find . -name "*.class" -type f -delete
	rm -rf "$RESOURCES_DIRECTORY/out"
}

function compileHomework
{
	if [ -f "$CURRENT_DIRECTORY/FileIO.jar" ]
	then
		unzip FileIO.jar
	fi

	javac -g main/Main.java

	mkdir "$RESOURCES_DIRECTORY/out"
}

function checkTest
{
    echo -ne "Test\t$1\t.....................................\t"
    java main.Main "$RESOURCES_DIRECTORY/in/$1.in" "$RESOURCES_DIRECTORY/out/$1.out" > /dev/null

	if [ $? -eq 0 ]; then
#`diff -Bw -u --ignore-all-space $RESOURCES_DIRECTORY/out/$1.out $RESOURCES_DIRECTORY/res/$1.in.res &> /dev/null`
    echo $RESOURCES_DIRECTORY
   `diff -Bw -u --ignore-all-space $RESOURCES_DIRECTORY/out/$1.out $RESOURCES_DIRECTORY/res/$1.in.res &> out.txt`
        DIFF_RESULT=$?

        if [ $DIFF_RESULT -eq 0 ]; then
        	echo -ne "OK\n"

			if [[ $1 == *x* ]]; then
            	GOOD_TESTS=$((GOOD_TESTS+5))
        	elif [[ $1 == *dense* ]]; then
            	GOOD_TESTS=$((GOOD_TESTS+21))
        	else
            	GOOD_TESTS=$((GOOD_TESTS+1))
        	fi
        else
           echo -ne "FAIL (files differ)\n"
        fi
    else
        echo -ne 'FAIL (program error)\n'
    fi
}

function checkStyle
{
	java -jar checker09/checkstyle/checkstyle-7.3-all.jar -c checker09/checkstyle/poo_checks.xml *  > checkstyle.txt

	YOUR_CHECKSTYLE=`cat checkstyle.txt`

	if [[ "$GOOD_CHECKSTYLE" != "$YOUR_CHECKSTYLE" ]]; then
		BAD_CHECKSTYLE=`cat checkstyle.txt | grep -o 'Checkstyle ends with [0-9]* errors.' | grep -o '[0-9]*'`

		if [[ $BAD_CHECKSTYLE -lt 30 ]]; then
			BAD_CHECKSTYLE=0
		else
			BAD_CHECKSTYLE=20
		fi
	fi
}

function calculateScore
{
	GOOD_TESTS=$((60-GOOD_TESTS*6/10))

	GOOD_TESTS=`echo "scale=2; $GOOD_TESTS" | bc -l`
	BAD_CHECKSTYLE=`echo "scale=2; $BAD_CHECKSTYLE" | bc -l`

	echo -ne "\n-$GOOD_TESTS failed tests"
	echo -ne "\n-$BAD_CHECKSTYLE checkstyle errors\n\n"
}

function checkBonus
{
	echo -ne "\nGit bonus will be checked manually\n"
}

## MAIN EXECUTION ##
cleanHomework
compileHomework

checkTest "fightKKD"

checkStyle

checkBonus

calculateScore

#cleanHomework

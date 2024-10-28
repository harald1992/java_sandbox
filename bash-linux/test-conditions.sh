#!/bin/bash

[ hello = hello ]
echo $?
# $? means use the last output
# output of test 0 means true

isTruthy=$( [ hello = notHello ]; echo $? )
echo $isTruthy

[ 1 -eq 1 ] # -eq means compare numericals
echo $?

[ 1 = 2 ]
echo $?

input=$(echo "$1" | tr '[:upper:]' '[:lower:]')
# tr: convert input to lowercase

echo if else statement:

if [ $input = harald ]; then
  echo "Hello Harald"
elif [ $input = admin ]; then
  echo "Hello Admin"
else
  echo "Enter a valid name"
fi

echo case statement:

case $input in
        harald | admin)
                echo "Hello $input"
                ;;
        help)
                echo "Enter a valid name"
                ;;
        *)
                echo "Default; enter valid name"
                ;;
              esac
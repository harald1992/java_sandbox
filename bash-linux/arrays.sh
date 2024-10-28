#!/bin/bash

MY_ARRAY=(one two three 4)
echo ${MY_ARRAY[@]}
echo ${MY_ARRAY[2]}

MY_ARRAY[2]=3
echo ${MY_ARRAY[2]} | sed 's/3/substituted3forthis/'

echo for loop:
for item in ${MY_ARRAY[@]}; do echo -n $item | wc -c;  done
# echo -n prevent trailing newline, so word count character is correct.
# wc -c count the number of characters
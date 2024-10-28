#!/bin/bash

# positional arguments
echo $1 $2

echo What is your first name?
read FIRST_NAME
echo Your name is $FIRST_NAME

echo $1 $2 > arguments-variables-output.txt
echo $FIRST_NAME >> arguments-variables-output.txt
echo ChangeThisLaterWithSed >> arguments-variables-output.txt

wc -w < arguments-variables-output.txt

echo -n word count  E_O_F dingetje count
wc -w << EOF
line 1
line 2
EOF

echo -n word count firstName
 wc -w <<< $FIRST_NAME

sed -i '' 's/ChangeThisLaterWithSed/ChangedWithSed/g' arguments-variables-output.txt

# > overrides it
# >> appends to it
#wc -w: word count -w: only count the words
# <Redirects input from file to command, so use arguments-variables-output.txt in wc
# << Redirects from block of text with the script until you get EOF if you did << EOF
# <<< Redirects input from a string directly
# sed -i edit the file
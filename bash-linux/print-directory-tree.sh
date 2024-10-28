#!/bin/bash
# this first line tells which shell interpreter to use

echo
# If input argument, cd to the directory in the input argument


if [ "$1" != "" ]; then
  cd "$1"
fi  # close if statement

echo "pwd: "
pwd # print current directory

# -F: Append a character to each file name to indicate file type, / to directories, * to executable files, @ to symbolic links, | to FIFOs, = to sockets, and > to doors
# -1: List one file per line
# | grep: search
# | wc: wordcount -> -l is count lines
if [ `ls -F -1 | grep "/" | wc -l` = 0 ]
  then echo "   -> no sub-directories"
fi

 # print directories recursively and grep for lines that end with ':' ($ is for regex)
 # | sed is for formatting:
 # -e: multiple expressions in the same sed command
 # 's/:$//': remove all colons at end of line
 # 's/[^-][^\/]*\//--/g': replaces / with --
 #  's/^/ /': indents each line by adding three spaces to the beginning
 # 's/-/|/': replaces the first dash - of each line with |.

 ls -R | grep ":$" | sed -e 's/:$//' -e 's/[^-][^\/]*\//--/g' -e 's/^/   /' -e 's/-/|/'

 echo
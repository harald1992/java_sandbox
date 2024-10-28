#!/bin/bash

cd ~/WerkProgramming/
echo Result:
#grep -inRw $1 --exclude-dir -E 'senses,senses_normal_clone'
dir1='senses'
dir2='senses_normal_clone'
grep -inRw $1 --exclude-dir={$dir1,$dir2}
#-i: Ignore case distinctions in the pattern and input files.
#-n: Prefix each line of output with the line number within its input file.
#-R: Read all files under each directory, recursively.
#-w: Select only those lines containing matches that form whole words.
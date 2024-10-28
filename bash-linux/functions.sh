#!/bin/bash

showuptime(){ 
	local up=$(uptime | cut -c11-17)
	# use local, otherwise this is available outside the function

	#| cut -c4-: cut until 11 to 17 remain.
	cat << EOF
--------
This machine has been up for ${up}
---------
EOF
}

showuptime


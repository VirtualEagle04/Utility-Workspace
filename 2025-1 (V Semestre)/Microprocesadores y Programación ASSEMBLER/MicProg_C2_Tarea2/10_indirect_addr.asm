        INP
loop	STA count 
        STA @address
        LDA address
        SUB one
        STA address
        LDA count
        SUB one
        BRP loop
        HLT
		
count   DAT
one 	DAT 1 
address DAT 99

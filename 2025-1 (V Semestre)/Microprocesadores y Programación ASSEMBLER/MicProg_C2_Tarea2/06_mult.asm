        INP
        STA NUM1
        INP 
        STA NUM2
LOOP    LDA TOTAL
        ADD NUM1
        STA TOTAL
        LDA NUM2
        SUB ONE
        STA NUM2
        BRP LOOP
        LDA TOTAL
        SUB NUM1
        STA TOTAL
        OUT
        HLT
		
NUM1    DAT
NUM2    DAT
ONE     DAT 1
TOTAL   DAT 0
  
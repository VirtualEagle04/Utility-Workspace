loop    LDA number
        ADD counter
        OUT
        STA number
        LDA counter
        ADD one
        STA counter
        LDA ten
        SUB counter
        BRP loop
        HLT
		
counter DAT 1
number  DAT 0
one     DAT 1
ten     DAT 10
  
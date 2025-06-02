start   LDA one
        OUT
        LDA zero
        OUT
        LDA count
        SUB one
        STA count
        BRP start
        HLT
one     DAT 1
zero    DAT 0
count   DAT 3

start   INP
        STA dividend
        INP
        STA divisor
        LDA zero
        STA answer
        LDA dividend
loop    SUB divisor
        STA dividend
        BRP greater
        LDA answer
        OUT
        HLT
greater LDA answer
        ADD one
        STA answer
        LDA dividend
        BRA loop
zero    DAT 0
one     DAT 1
answer  DAT
dividend DAT
divisor DAT

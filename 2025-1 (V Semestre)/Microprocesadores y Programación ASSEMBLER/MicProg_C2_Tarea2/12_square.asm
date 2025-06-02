start   INP
        STA number
        LDA zero
        STA sum
        STA count
loop    LDA sum
        ADD number
        STA sum
        LDA count
        ADD one
        STA count
        SUB number
        BRP finish
        BRA loop
finish  LDA sum
        OUT
        HLT
number  DAT
sum     DAT
count   DAT
zero    DAT 0
one     DAT 1

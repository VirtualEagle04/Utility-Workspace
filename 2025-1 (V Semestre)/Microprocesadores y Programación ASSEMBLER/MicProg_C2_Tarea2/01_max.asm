      INP
      STA num1     
      INP
      STA num2
      SUB num1
      BRP pos
      LDA num1
      OUT
      BRA exit
pos   LDA num2
      OUT
exit  HLT

num1  DAT
num2  DAT  
          INP 
          STA final 
          BRZ oneval
          SUB one
          STA iteration
          STA counter
          LDA final
          STA num
mult      LDA iteration
          BRZ end
          SUB one
          BRZ end
          LDA final
          ADD num
          STA final
          LDA counter
          SUB one
          STA counter
          SUB one
          BRZ next
          BRA mult
next      LDA final
          STA num 
          LDA iteration
          SUB one
          STA iteration
          STA counter
          SUB one
          BRZ end
          BRA mult
end       LDA final
          OUT
          HLT
oneval    LDA one
          OUT
          HLT
		  
final     DAT 0
counter   DAT 0
one       DAT 1
iteration DAT 0
num       DAT 0
 
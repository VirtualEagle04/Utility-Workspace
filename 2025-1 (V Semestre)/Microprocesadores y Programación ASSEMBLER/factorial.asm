; Factorial en ASSEMBLY de 16 bits
; AUTOR: Federico Vargas Rozo
; FECHA: 04/01/2024
; DESCRIPCIÓN: Este programa permite calcular el factorial de un número e imprimirlo.
; NOTA: El programa solo funciona hasta el factorial de 4, pues el factorial de 4 es 24, y es el último
; factorial que es de solo 2 dígitos. El factorial de 5 es 120 (tres dígitos) y por lo tanto, sería necesario
; realiza un proceso más extenso para poder imprimir el resultado en tres casillas del display diferentes.
; Lo hice profe! Solamente me tomó 4 horas jajaja, a punta del set de instrucciones, la calculadora y la tabla ASCII

	JMP boot	; Salta al proceso inicial

stackTop    EQU 0xFF    ; Dirección inicial del Stack
txtDisplay  EQU 0x2E0	; Dirección inicial del display de salida

boot:
	; Aquí se establecen algunos registros importantes

	MOV SP, stackTop	; Ubica el SP (Stack Pointer) en la dirección incial, definida por stackTop
	MOV D, txtDisplay	; Ubica el Registro D en la dirección inicial, definida por txtDisplay
    
	MOV A, 4			; Copia un valor al Registro A
    MOV B, A			; Copia el valor del Registro A en el Registro B
    
mult:
	; Aquí se realiza el proceso del factorial, por medio del Registro B, que se utiliza para saber el
	; siguiente número a multiplicar con el Registro A, el cual tiene el resultado del factorial acumulado.
    ; Se detiene cuando B es 1, lo que significa que ha llegado al final del factorial.

    DEC B			; Decrementa el valor del Registro B, por lo que toma el valor del numero previo
    MUL B			; Multiplica el Registro A con el valor del Registro B
    CMP B, 1		; Realiza una comparación para saber si B es 1. Si lo es, el banderín Zero (Z) es 1
    JZ div			; Salta si el banderín Zero (Z) en el SR (Status Register) es 1
    JMP mult		; Realiza nuevamente un ciclo
    
div:
	; Aquí se realiza el proceso de "división" para separar un factorial de 2 dígitos, por ejemplo: !4 = 24
	; en Registros independientes para después poder imprimirlos en casillas del display diferentes.
	; Como la instrucción DIV del simulador no retorna el residuo de una división, es necesario hacer este
	; proceso manualmente, por medio de restas continuas y un contador (Registro C) que cuenta las restas que
	; se han realizado y que no han dado un resultado negativo. En caso de que la resta dé un resultado
	; negativo, se suma 10 para "reestablecer" el valor de A antes de la resta.
	; Con este proceso, se tiene que en el Registro C tenemos el primer dígito y en el Registro A el segundo.

	SUB A, 10		; Resta 10 al Registro A
    JA cont_inc		; Salta si el banderín del Carry (C) en el SR (Status Register) es 1
    ADD A, 10		; Suma 10 al Registro A, en caso de que la ultima resta lo haya llevado a ser negativo
    JMP print 		; Salta al proceso de impresión de los digitos ya separados
    
cont_inc:
	; Aquí simplemente se está aumentando el "contador" (Registro C) para contar las veces que se ha podido
	; restar 10 del Registro A y que no ha dado negativo.

		INC C		; Incrementa el "contador", que es el Registro C
        JMP div		; Saltar nuevamente al proceso de "división"

print:
	; Aquí realiza el proceso de impresión de los dígitos en diferentes casillas del display, utilizando
	; el resultado en los Registros C y A con el primer y segundo dígito, respectivamente.

	ADD C, 0x30 	; Sumar 30 hexadecimal (48 decimal) para saber el valor ASCII del primer dígito
    MOVB [D], CL	; Copiar el valor LSB del Registro C (8 bits) en la casilla del display 
    
    INC D			; Desplazar la casilla del display a la siguiente
    
    ADD A, 0x30		; Sumar 30 hexadecimal (48 decimal) para saber el valor ASCII del segundo dígito
    MOVB [D], AL	; Copiar el valor LSB del Registro A (8 bits) en la casilla del display
    
    HLT				; Detener la ejecución del programa
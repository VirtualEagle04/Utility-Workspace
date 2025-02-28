package main

import (
	"bufio"    // Modulo para lectura de datos
	"fmt"      // Modulo por defecto para formatear
	"math/big" // Modulo para evitar el desbordamiento cuando se introducen los maximos valores: 1024^10
	"os"       // Modulo para imprimir formateadamente
	"strconv"  // Modulo para conversiones numericas
	"strings"  // Modulo para manipular strings
	"time"     // Modulo para la toma del tiempo
)

// Función principal para calcular potencias.
func pot(base *big.Int, exp uint8) *big.Int {
	r := big.NewInt(1)
	for i := uint8(0); i < exp; i++ {
		r.Mul(r, base) // Función requerida para multiplicar numeros muy grandes tipo big.Int
	}
	return r
}

func main(){
	
	// Inicializar el lector
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Ingrese la Base y el Exponente separados por un espacio: ")
	
	// Leer la entrada
	input, _ := reader.ReadString('\n')
	input = strings.TrimSpace(input)
	
	// Separar la entrada en tokens
	tokens := strings.Split(input, " ")
	
	// Verificar que haya exactamente 2 parámetros
	if len(tokens) != 2 {
		fmt.Fprintln(os.Stderr, "No tiene 2 parametros.")
		return
	}
	
	// Tomar tiempo inicial
	t0 := time.Now()
	
	// Intentar parsear la entrada a números
	base, err1 := strconv.ParseUint(tokens[0], 10, 16)
	exp, err2 := strconv.ParseUint(tokens[1], 10, 8)
	
	if err1 != nil || err2 != nil {
		fmt.Fprintln(os.Stderr, "Entradas no numericas.")
		return
	}
	
	// Verificar limites
	if base == 0 || base > 1024 || exp > 10 {
		fmt.Fprintln(os.Stderr, "No cumple límites.")
		return
	}
	
	fmt.Println("Resultado: ")
	
	// Iterar y operar
	bigBase := big.NewInt(int64(base))
	for i := uint8(0); i <= uint8(exp); i++ {
		r := pot(bigBase, i)
		fmt.Printf("%d^%d = %s\n", base, i, r.String())
	}
	
	//Calcular y mostrar el tiempo de ejecución
	dur := time.Since(t0)
	fmt.Fprintf(os.Stderr, "Tiempo de Ejecución: %d nanosegundos\n", dur.Nanoseconds())
	
}
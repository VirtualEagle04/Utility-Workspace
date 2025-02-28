using System;
using System.Numerics;
using System.Diagnostics;
using System.Globalization;

class Potenciacion {
    
    static void Main() {
        Console.Write("Ingrese la Base y el Exponente separados por un espacio: ");
        string input = Console.ReadLine();
        
        string[] tokens = input.Split(' ');
        
        Stopwatch sw = Stopwatch.StartNew();
        
        if (tokens.Length != 2) {
            Console.Error.WriteLine("No tiene 2 parametros.");
            return;
        }
        else {
            try {
                
                short b = short.Parse(tokens[0]);
                byte exp = byte.Parse(tokens[1]);
                
                if (b <= 0 || exp > 10 || exp < 0) {
                    Console.Error.WriteLine("No cumple limites.");
                    return;
                }
                
                Console.WriteLine("Resultado:");
                
                BigInteger bigBase = new BigInteger(b);
                
                for (int i = 0; i <= exp; i++) {
                    BigInteger r = BigInteger.One;
                    for (int j = 0; j < i; j++) {
                        r *= bigBase;
                    }
                    
                    Console.WriteLine($"{b}^{i} = {r.ToString("N0", CultureInfo.InvariantCulture)}");
                }
                
                sw.Stop();
                long ns = (long)(1_000_000_000.0 * sw.ElapsedTicks / Stopwatch.Frequency);
                
                Console.Error.WriteLine($"Tiempo de Ejecucion: {ns} nanosegundos");
                
            } catch (Exception e) {
                Console.Error.WriteLine(e.Message);
            }
        }
        
    }
    
}
// Librerias para el Display
// #include <SPI.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>

#define SCREEN_WIDTH 128  // Ancho de la pantalla, en pixeles
#define SCREEN_HEIGHT 32  // Alto de la pantalla, en pixeles
#define OLED_RESET -1
#define SCREEN_ADDRESS 0x3C  // 0x3D para 128x64, 0x3C para 128x32
Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);

#define SENSOR A0  // Pin de lectura del sensor AD8232

#define BUZZER 6
#define RED_LED 7
#define YELLOW_LED 8
#define BLUE_LED 9

int sensorValue;             // Valor del sensor
int mappedValue;             // Valor del sensor limitado entre 0 a 45
int bpm = 0;                 // Pulsaciones por minuto (BPM), un promedio sacado de todos los registros en el arrelo
int threshold = 338;         // Umbral (valor de la señal del sensor donde ocurre el pico R)
bool belowThreshold = true;  // Bandera para indicar si las lecturas no han superado el umbral

long old_beat_time = 0;  // Tiempo previo donde ocurrió el pico
int beatIndex;           // Utilizado para ingresar lecturas de BPM actuales en este indice en el arreglo
int beats[100];          // Arreglo para almacenar resultados de BPM para el cálculo del promedio

int prev_x = 0;   // Valor previo de coordenadas X
int curr_x = 0;   // Valor actual de coordenadas X
int prev_y = 60;  // Valor previo de coordenadas Y
int curr_y = 0;   // Valor actual de coordenadas Y

void setup() {
  //Inicializar comunicación seríal
  Serial.begin(9600);

  // SSD1306_SWITCHCAPVCC = generate display voltage from 3.3V internally
  if (!display.begin(SSD1306_SWITCHCAPVCC, SCREEN_ADDRESS)) {
    Serial.println(F("SSD1306 allocation failed"));
    for (;;)
      ;  // Don't proceed, loop forever
  }
  pinMode(10, INPUT);  // Detección Leads-Off (LO +)
  pinMode(11, INPUT);  // Detección Leads-Off (LO -)
  pinMode(BUZZER, OUTPUT);
  pinMode(RED_LED, OUTPUT);
  pinMode(YELLOW_LED, OUTPUT);
  pinMode(BLUE_LED, OUTPUT);

  display.setTextSize(1);               // Por defecto la letra es de 6x8 px (1), (2) significa 12x16, etc.
  display.setTextColor(SSD1306_WHITE);  // Color de texto
  display.clearDisplay();               // Limpiar la pantalla
}

void loop() {
  if (digitalRead(10) == 1 || digitalRead(11) == 1) {
    Serial.println('!');
  } else {
    sensorValue = analogRead(SENSOR);
    Serial.println(sensorValue);

    display.display();
    display.setCursor(30, 0);
    display.setTextColor(WHITE, BLACK);
    display.print("   ");
    display.display();
    display.setCursor(0, 0);
    display.print("SIG: ");
    display.setCursor(30, 0);
    display.print(sensorValue);
  }

  mappedValue = map(sensorValue, 0, 1024, 0, 45);  // Convertir el valor de la señal [0-1024) hasta el área vertical asignada a la gráfica [0px-45px)

  curr_y = 31 - mappedValue;  // Invertir la gráfica, porque las coordenadas del display comienzan en la esquina superior izquierda

  // Si la posisción actual de la línea (curr_x) se sale de los margenes del display (0-127), resetear estos valores y limpiar la pantalla
  if (curr_x >= 128) {
    curr_x = 0;
    prev_x = 0;
    display.clearDisplay();
  }

  // Dibujar una linea entre los dos puntos (previo [prev] y actual [curr])
  display.drawLine(prev_x, prev_y, curr_x, curr_y, WHITE);
  prev_x = curr_x;  // Establecer la posición previa de x en la posición actual de x
  prev_y = curr_y;  // Establecer la posición previa de y en la posición actual de y
  curr_x++;         // Aumentar la posición actual de x
  display.display();

  // Si la señal del sensor supera el umbral, calcular los BPM
  if (sensorValue > threshold && belowThreshold == true) {
    BPM();
    belowThreshold = false;
  } else {
    belowThreshold = true;
  }

  // Si al señal del sensor supera el umbral, hacer sonar el buzzer
  if (sensorValue > threshold) {
    tone(BUZZER, 1000);
    delay(100);
    noTone(BUZZER);
  } else if (sensorValue <= 0) {  // Si la señal del sensor es 0, hacer sonar el buzzer e iluminar el LED rojo
    tone(BUZZER, 1000);
    digitalWrite(RED_LED, HIGH);
    digitalWrite(YELLOW_LED, LOW);
    digitalWrite(BLUE_LED, LOW);
  }

  // Intervalos para los LEDs
  if (bpm < 50)
  {
    digitalWrite(RED_LED, HIGH);
    digitalWrite(YELLOW_LED, LOW);
    digitalWrite(BLUE_LED, LOW);
  }
  else if (51 <= bpm && bpm <= 70)
  {
    digitalWrite(YELLOW_LED, HIGH);
    digitalWrite(RED_LED, LOW);
    digitalWrite(BLUE_LED, LOW);
  }
  else if (71 <= bpm && bpm <= 90)
  {
    digitalWrite(BLUE_LED, HIGH);
    digitalWrite(RED_LED, LOW);
    digitalWrite(YELLOW_LED, LOW);
  }
  else if (bpm > 90)
  {
    digitalWrite(RED_LED, HIGH);
    digitalWrite(YELLOW_LED, LOW);
    digitalWrite(BLUE_LED, LOW);
  }

  delay(100);
}

void BPM() {
  int current_beat_time = millis();              // Traer el tiempo actual
  int diff = current_beat_time - old_beat_time;  // Encontrar la diferencia de tiempo entre las dos pulsaciones
  float currentBPM = int(60000 / diff);          // Convertir a pulsaciones por minuto (1 m = 60 s = 60000 ms)
  beats[beatIndex] = currentBPM;                 // Almacenar en arreglo para promedio
  float total = 0.0;
  for (int i = 0; i < 100; i++) {
    total += beats[i];
  }
  bpm = int(total / 100);
  old_beat_time = current_beat_time;
  beatIndex = (beatIndex + 1) % 100;  // Modular para que el indice se quede entre 0 y 499

  display.setCursor(54, 0);  // "BPM: " son 5 caracteres, como cada caracter tiene un ancho de 12 px, 5 * 12 = 60, por lo tanto, el valor de los BPM será impreso desde esa posición en x.
  display.print("BPM: ");
  display.setCursor(84, 0);
  display.print(bpm);
  display.display();
}
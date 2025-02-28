import cv2
import numpy as np
import random as rd
import os

# region Ejercicio 1
# 1. Count pixel of certain color in an Image

def ej1():
    print(" Ejercicio 1 ".center(50, '-'))
    rgb_color = input("RGB: ").split()
    R = int(rgb_color[0])
    G = int(rgb_color[1])
    B = int(rgb_color[2])

    img = cv2.imread("Ave.jpg")

    alto, ancho = img.shape[:2]
    n = 0

    for f in range(alto):
        for c in range(ancho):
            b = img[f,c,0]
            g = img[f,c,1]
            r = img[f,c,2]

            if R == r and G == g and B == b:
                n += 1

    print(f"Total de pixeles con el color ({rgb_color[0]},{rgb_color[1]},{rgb_color[2]}): {n}")
# endregion

# region Ejercicio 2
# 2. Recortar un rectangulo de una imagen y crear un archivo
def ej2():
    print(" Ejercicio 2 ".center(50, '-'))
    L = input("Fila-1, Columna-1: ").split()
    f1 = int(L[0])
    c1 = int(L[1])

    L = input("Fila-2, Columna-2: ").split()
    f2 = int(L[0])
    c2 = int(L[1])

    img = cv2.imread("Ave.jpg")
    img_new = img[f1:f2, c1:c2]

    cv2.imshow('Nueva imagen', img_new)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    cv2.imwrite("Ave_Recortada.jpg", img_new)
# endregion

# region Ejercicio 3
# 3. Change the pixels of a specific color to another color
def ej3():
    print(" Ejercicio 3 ".center(50, '-'))
    color_actual = input("Color actual: ").split()
    color_actual = list(map(int, color_actual))

    color_nuevo = input("Color nuevo: ").split()
    color_nuevo = list(map(int, color_nuevo[::-1]))
    print("color_nuevo:", color_nuevo)

    r = color_actual[0]
    g = color_actual[1]
    b = color_actual[2]
    colorBuscado = f'{r:02x}{g:02x}{b:02x}'

    img = cv2.imread('Ave.jpg')

    alto, ancho = img.shape[:2]
    n = 0
    coordenadas = ''

    for f in range(alto):
        for c in range(ancho):
            b = img[f,c,0]
            g = img[f,c,1]
            r = img[f,c,2]

            colorLeido = f'{r:02x}{g:02x}{b:02x}'

            if colorLeido == colorBuscado:
                img[f,c] = color_nuevo
                print(img[f,c])
                n += 1
                coordenadas += f'({f},{c}) '


    print("Número de cambios:", n)
    print("Coordenadas cambiadas: ", coordenadas)

    cv2.imwrite('Ave_new.jpg', img)
# endregion

# region Ejercicio 4
# 4. Dada una imagen, llenar las primeras 300 filas de ruido.
def ej4():
    print(" Ejercicio 4 ".center(50, '-'))
    img = cv2.imread("Ave.jpg")

    for f in range(300):
        for c in range(img.shape[1]):
            img[f][c] = [
                rd.randint(0, 255),
                rd.randint(0, 255),
                rd.randint(0, 255)
                ]

    cv2.imshow("Ejercicio 4", img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
# endregion

# region Ejecicio 5
# 5. Mostrar la imagen en escala de grises
def ej5():
    print(" Ejercicio 5 ".center(50, '-'))
    img = cv2.imread("Ave.jpg", 0)

    cv2.imshow("Ejercicio 5", img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
# endregion

# region Ejercicio 6
# 6. Recortar una parte de la imagen y ponerla en otra parte de la misma imagen
def ej6():
    img = cv2.imread("Ave.jpg")

    img[500:600][30:80] = img[160:260][200:250]

    cv2.imshow("Ejercicio 6", img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
# endregion

# region Ejercicio 7
# 7. Dada una imagen,m color un rectangulo negro de dimensiones 30x80 en cualquier parte de la misma imagen
def ej7():
    img = cv2.imread("Ave.jpg")

    img[500:600][30:80] = [0, 0, 0]

    cv2.imshow("Ejercicio 6", img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

# endregion

# region Ejercicio 8
# 8. Dada una Imagen, dibujar un rectangulo de color azul en cierta posición
def ej8():
    img = cv2.imread("Ave.jpg")

    img[500:600][30:80] = [255, 0, 0]

    cv2.imshow("Ejercicio 6", img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

# endregion

# region Ejercicio 9
# 9. Dada una Imagen, dibujar un rectangulo sin relleno de color Azul
def ej9():
    img = cv2.imread("Ave.jpg")

    start_point = (5, 5)
    end_point = (220, 220)
    color = (255, 0, 0)
    thickness = 2

    image = cv2.rectangle(img, start_point, end_point, color, thickness)

    cv2.imshow("Ejercicio 9", image)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
# endregion

# region Ejercicio 10
# 10. Rotar una Imagen 90° lentamente
def ej10():
    img = cv2.imread("Ave.jpg")

    (h, w) = img.shape[:2]

    img2 = np.zeros((h,2*h,3), np.uint8)
    img2[:, 700:700+w] = img

    cv2.imshow("Ejercicio 10", img)
    cv2.waitKey(0)

    (h, w) = img2.shape[:2]

    for g in range(90):
        rotation_matrix = cv2.getRotationMatrix2D((700, 0), -g, 1.0)
        rotated_img = cv2.warpAffine(img2, rotation_matrix, (w, h))

        cv2.imshow("Ejercicio 10", rotated_img)
        cv2.waitKey(50)
    
    cv2.destroyAllWindows()
# endregion

# region Ejercicio 11
# 11. Mostrar un Video Fotograma por Fotograma
def ej11():
    cap = cv2.VideoCapture('paseo.mp4')

    # Leer Fotograma por Fotograma
    while cap.isOpened():
        # Se captura un Fotograma
        # ret = un booleano que indica si encontró algún fotograma
        # frame = una imagen del Fotograma actual
        ret, frame = cap.read() 

        if not ret:
            break

        img = cv2.resize(frame, (0,0), fx=0.35, fy=0.35)

        cv2.imshow("Fotograma", img)

        if cv2.waitKey(1) == ord('q'):
            break
    
    cap.release()
    cv2.destroyAllWindows()
# endregion

# region Ejercicio 12
# 12. Rotar el video 180° Verticalmente
def ej12():
    # cap = cv2.VideoCapture(0)
    cap = cv2.VideoCapture('paseo.mp4')

    # Leer Fotograma por Fotograma
    while cap.isOpened():
        # Se captura un Fotograma
        # ret = un booleano que indica si encontró algún fotograma
        # frame = una imagen del Fotograma actual
        ret, frame = cap.read() 

        if not ret:
            break

        img = cv2.resize(frame, (0,0), fx=0.35, fy=0.35)
        img = cv2.rotate(img, 1)

        cv2.imshow("Fotograma", img)

        if cv2.waitKey(1) == ord('q'):
            break
    
    cap.release()
    cv2.destroyAllWindows()

# endregion

# region Ejercicio 13
def ej13():
    img = cv2.imread("Ave.jpg")

    (h, w) = img.shape[:2]

    canvas = np.zeros((h, 2*w), np.uint8)
    canvas[:h, :w] = img
    canvas[:h, w:] = img
    
    cv2.imshow("Ej 13", canvas)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

# endregion


while True:
    os.system("cls")
    print('MENU'.center(50, '-'))
    print()
    print("[1]. Ejercicio 1")
    print("[2]. Ejercicio 2")
    print("[3]. Ejercicio 3")
    print("[4]. Ejercicio 4")
    print("[5]. Ejercicio 5")
    print("[6]. Ejercicio 6")
    print("[7]. Ejercicio 7")
    print("[8]. Ejercicio 8")
    print("[9]. Ejercicio 9")
    print("[10]. Ejercicio 10")
    print("[11]. Ejercicio 11")
    print("[12]. Ejercicio 12")
    opc = input("Elija una opción: ")

    if opc == '1':
        ej1()
    elif opc == '2':
        ej2()
    elif opc == '3':
        ej3()
    elif opc == '4':
        ej4()
    elif opc == '5':
        ej5()
    elif opc == '6':
        ej6()
    elif opc == '7':
        ej7()
    elif opc == '8':
        ej8()
    elif opc == '9':
        ej9()
    elif opc == '10':
        ej10()
    elif opc == '11':
        ej11()
    elif opc == '12':
        ej12()
    elif opc == '000':
        exit()
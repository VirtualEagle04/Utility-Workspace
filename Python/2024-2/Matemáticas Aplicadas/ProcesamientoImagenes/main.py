# OpenCV toma RGB al revez rgb(255, 0, 0) es (0, 0, 255), es decir, azul, no rojo
import cv2
import numpy as np
import random

img0 = cv2.imread("Ave.jpg")

cv2.imshow("Ave", img0)
cv2.waitKey(0)
cv2.destroyAllWindows()
print(img0[0][0]) # img0 es un arreglo de pixeles y sus valores rgb
print(img0.shape)

img1 = np.zeros((500, 500, 3), dtype=np.uint8)

for f in range(img1.shape[0]):
    for c in range(img1.shape[1]):
        r = random.randint(0, 255)
        g = random.randint(0, 255)
        b = random.randint(0, 255)

        img1[f][c] = (b, g, r)

cv2.imshow("La ventana de tu mama",img1)
cv2.waitKey(0)
cv2.destroyAllWindows()

# Rotación

img2 = cv2.imread("Ave.jpg")

(h, w) = img2.shape[:2]
center = (w // 2, h // 2)
angle = -23.5
rotation_matrix = cv2.getRotationMatrix2D(center, angle, 1.0)

rotated_img = cv2.warpAffine(img2, rotation_matrix, (w, h))

cv2.imshow("Imagen Rotada", rotated_img)
cv2.waitKey(0)
cv2.destroyAllWindows()

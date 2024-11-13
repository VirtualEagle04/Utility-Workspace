import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error

data = pd.read_csv("practicaDatos.csv", sep=',')

X = data[['X1', 'X2', 'X3', 'X4']]
Y = data['Y']

# Y = 3X1 + 2X2 - X3 + 2X4

X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=42)

model = LinearRegression()
model.fit(X_train, Y_train)
Y_pred = model.predict(X_test)

mse = mean_squared_error(Y_test, Y_pred)
print(f"Mean Squared Error (MSE) on the test set: {mse}")
print(f"Model Coefficients (Slopes): {model.coef_}")
print(f"Model Intercept (y-intercept): {model.intercept_}")

plt.scatter(Y_test, Y_pred, color='blue')
plt.plot([min(Y_test), max(Y_test)], [min(Y_test), max(Y_test)], color='red', linestyle='--')
plt.title("Actual Y-Values vs Predicted Y-Values (Multiple Linear Regression)")
plt.xlabel("Actual Y-Value")
plt.ylabel("Predicted Y-Value")
plt.show()

x1, x2, x3, x4 = 7, 11, 13, 17
new_data = pd.DataFrame([[x1, x2, x3, x4]], columns=['X1', 'X2', 'X3', 'X4'])

predicted_y = model.predict(new_data)

print(f"Predicted Y-Value for values {x1, x2, x3, x4} is: {predicted_y[0]}")
print("The Predicted Y-Value is 100% with 0% Error, because replacing values X1, X2, X3, X4 in the equation is 64.")
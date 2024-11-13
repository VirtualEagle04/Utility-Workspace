import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error

data = pd.DataFrame({
    'Study Time': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
    'Sleep Time': [7, 6.5, 8, 7.5, 8, 6, 5.5, 6.5, 7, 5],
    'Exam Score': [50, 55, 60, 65, 70, 75, 80, 85, 90, 95]
})

X = data[['Study Time', "Sleep Time"]] # Matriz X
Y = data['Exam Score'] # Vector de B

X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.3, random_state=42)

model = LinearRegression()
model.fit(X_train, Y_train)
Y_pred = model.predict(X_test)

mse = mean_squared_error(Y_test, Y_pred)
print(f"Mean Squared Error (MSE) on the test set: {mse}")
print(f"Model Coefficients (Slopes): {model.coef_}")
print(f"Model Intercept (y-intercept): {model.intercept_}")

plt.scatter(Y_test, Y_pred, color='blue')
plt.plot([min(Y_test), max(Y_test)], [min(Y_test), max(Y_test)], color='red', linestyle='--')
plt.title("Actual vs Predicted Exam Scores (Multiple Linear Regression)")
plt.xlabel("Actual Exam Score")
plt.ylabel("Predicted Exam Score")
plt.show()

study_time = 6
sleep_time = 7
new_data = pd.DataFrame([[study_time, sleep_time]], columns=['Study Time', "Sleep Time"])

predicted_score = model.predict(new_data)

print(f"Predicted Exam Score for {study_time} hours of study and {sleep_time} hours of sleep: {predicted_score[0]}")
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

data = pd.DataFrame({
    'Study Time': [2, 4, 6],
    'Exam Score': [40, 50, 65]
})

data = pd.read_csv("pandasDatos.csv", sep=';')
print(data.head())

X = data[['Study Time']]
Y = data['Exam Score']

model = LinearRegression()
model.fit(X, Y)

plt.scatter(X, Y, color='blue')
plt.plot(X, model.predict(X), color='red')
plt.title("Linear Regression: Exam Score vs Study Time")
plt.xlabel("Study Time (Hours)")
plt.ylabel("Exam Score")
plt.show()

print(f"Slope: {round(model.coef_[0], 2)}")
print(f"Y-intercept: {round(model.intercept_, 2)}")

hours = 5
predicted_score = model.predict(pd.DataFrame([[hours]], columns=['Study Time']))
print(f"Predict Score: {round(predicted_score[0], 2)}")

# The principle of Linear Regression when using TRAINING SETS and TEST
# SETS revolves around the idea of building a model that learns the
# relationships between the dependent and independent variables
# using one subset of the data (the TRAINING SETS) and then testing how
# well the model generalizes to unseen data (the TRAINING SETS).

# ----------------------------------------------------------------------
# Training Set:
# This is a portion of the data that is used to train the
# model. It includes both the independent variables (features) and the
# dependent variable (target). The model uses this data to estimate
# the coefficients (slopes) and intercept for the regression equation.

# ----------------------------------------------------------------------
# Test Set:
# This is the remaining portion of the data that is kept
# separate from the training process. It contains unseen data that the
# model hasn't used during training. After the model is trained, its
# performance is evaluated on this test set to see how well it
# generalizes to new data.


# Brick Breaker Game

A classic brick breaker game built in Java with improved design, readability, and maintainability through the application of refactoring techniques.

## 🚀 Overview

This game features:
- Continuous background music and sound effects
- Interactive gameplay with levels and strategies
- Custom background and level designs
- Clean, modular, and extensible codebase

## 🧹 Refactoring Summary

To improve code quality, the following **refactoring techniques** were applied:

### 🔧 Composing Methods
- **Extract Method**: Broke down large methods into smaller, reusable ones for clarity and reusability.
- **Replace Temp with Query**: Eliminated unnecessary temporary variables by using method calls directly.
- **Encapsulate Downcast**: Centralized type casting logic within utility methods.

### 🧱 Organizing Data
- **Replace Magic Numbers with Symbolic Constants**: Replaced hardcoded values with named constants for better readability and easier modification.
- **Encapsulate Constants**: Promoted shared values to `private static final` constants to enforce encapsulation.

### 🏗️ Moving Features
- **Extract Class**: Divided classes with multiple responsibilities into specialized helper classes (e.g., `BackgroundImageLabel`, `LevelManager`).
- **Move Method**: Moved behavior to the appropriate classes to improve cohesion and reduce coupling.

### 🎯 Simplifying Conditional Logic
- **Replace Conditional with Polymorphism**: Replaced `if-else` or `switch` patterns with polymorphic behavior through strategy classes.

### 🧠 Dealing with Generalization
- **Encapsulate Singleton Constructor**: Ensured singleton enforcement in the `Settings` class by making the constructor private.


## ✅ Requirements

- Java 8 or higher
- IntelliJ IDEA (recommended)

## ▶️ Running the Game

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Run `BrickBreaker.java`.

## 👨‍💻 Credits

Refactored and improved using industry-standard refactoring patterns based on Martin Fowler’s _Refactoring_ principles.

---


# 🌡️ ConverterTabsJava

[![Android](https://img.shields.io/badge/Android-7.0%2B-green.svg)](https://developer.android.com)
[![Java](https://img.shields.io/badge/Java-11-orange.svg)](https://www.java.com)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

Une application Android de conversion d'unités avec interface à onglets, développée en Java. L'application permet de convertir les températures (Celsius ↔ Fahrenheit) et les distances (Kilomètres ↔ Miles) dans une interface moderne et intuitive.

## 📱 Demo




https://github.com/user-attachments/assets/d66f136e-7924-4e86-98e3-6c8275446b7c


## ✨ Fonctionnalités

- **🔘 Interface à onglets** : Navigation fluide entre les deux types de conversion
- **🌡️ Conversion de température** :
  - Celsius → Fahrenheit
  - Fahrenheit → Celsius
- **📏 Conversion de distance** :
  - Kilomètres → Miles
  - Miles → Kilomètres
- **✅ Validation des entrées** : Gestion des erreurs et des champs vides
- **💬 Messages contextuels** : Notifications Toast pour les erreurs utilisateur
- **🚪 Confirmation de sortie** : Dialogue de confirmation avant de quitter l'application

## 🏗️ Architecture Technique

### Technologies utilisées
- **Langage** : Java 11
- **SDK minimum** : API 24 (Android 7.0 Nougat)
- **SDK cible** : API 34 (Android 14)
- **UI Components** : Material Design 3
- **Navigation** : ViewPager2 + TabLayout

### Dépendances principales
```gradle
dependencies {
    implementation 'com.google.android.material:material:1.12.0'
    implementation 'androidx.viewpager2:viewpager2:1.1.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
}

# Project – BoiPata (❌ ✔)

A modern eBook reader app built with **Kotlin + Jetpack Compose**, featuring category-wise books, offline caching, and MVVM architecture.

---

## 📅 Day 1 – Project Foundation

**Date:** 04-01-26  
**Today Goal:** Project foundation  

### ✅ Tasks Completed
- Project created  ✔
- MVVM structure setup  ✔
- Dependencies added  ✔
- App theme finalized  ✔

---

##✅ Day 2

**Date:** 05-01-26
**Today Goal:** Logo + UI Design

### ✅ Tasks Completed
- App logo setup completed ✔
- Splash screen redesigned (green gradient based) ✔
- Login & Register page design goal fixed ✔


## ✅ Day 3

**Date:** 06-01-26  
**Today Goal:** Navigation & Authentication UI Setup

- ✔ Jetpack Compose Navigation implemented (Splash → Login → Register → Home)  
- ✔ `BoipataNavGraph` created to manage routes  
- ✔ `LoginScreen.kt` designed with email & password fields and UI validation  
- ✔ `RegisterScreen.kt` designed with name, email & password fields and validation  
- ✔ "Continue without account" option added for demo mode  

## ✅ Day 4

**Date:** 07-01-26  
**Today Goal:** Firebase Integration & ViewModel

- ✔ Firebase successfully connected (Auth & Firestore)  
- ✔ `AuthViewModel` created for login & registration logic  
- ✔ `BoipataApp.kt` updated to pass `AuthViewModel` to NavGraph  
- ✔ Login & Register screens connected to `AuthViewModel` for authentication logic  
- ✔ Navigation from login/register → home implemented after successful login


## ✅ Day 5

**Date:** 08-01-26  
**Today Goal:** Authentication Flow Fix, Navigation & UI Polishing

- ✔ Firebase Auth callback issues fixed (`onSuccess / onError` mismatch resolved)  
- ✔ `AuthViewModel` login & register functions standardized  
- ✔ Login screen validation improved (email & password error handling)  
- ✔ Auto-login check added using `currentUser` state  
- ✔ Logout functionality implemented from Home screen  
- ✔ Navigation issues fixed (login ↔ home, continue without account flow)  
- ✔ UI polished for Login & Home screens (spacing, buttons, colors)  
- ✔ App flow verified: **Login → Home → Logout → Login**

**Outcome:**  
Authentication flow now stable, navigation works correctly, and user experience is smoother across screens.


## ✅ Day 6

**Date:** 08-01-26  
**Today Goal:** Authentication Flow Fix, Navigation & UI Polishing


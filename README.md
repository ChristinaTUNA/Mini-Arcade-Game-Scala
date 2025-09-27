# 🍞 Roti Baker – OOP Arcade Game  

A ScalaFX **8-bit bakery-themed arcade game** developed as my **Year 2 Object-Oriented Programming Final Assessment**.  
Players must follow recipe sequences by clicking ingredient buttons or pressing keys to bake bread, cakes, and pastries — earning points for success, losing lives for mistakes, and racing against the clock.  


## 🚀 Features  

- 🎮 **Interactive Gameplay** → keyboard & mouse inputs for flexibility  
- ⏳ **Timer & Lives System** → complete recipes before time runs out  
- 🍰 **Random Recipe Generation** → keeps gameplay unpredictable  
- ⭐ **Scoring System** → points for accuracy, penalties for mistakes  
- 🖼️ **Pixelated Bakery Theme** → retro arcade style with cozy vibe  


## 🛠️ System Design  

- **Architecture** → divided into `view`, `controller`, `model`, `util` packages for modularity  
- **View** → FXML layouts for Home, Game, Instruction screens + CSS for 8-bit styling  
- **Controller** → manages user interactions, events (button clicks, key presses)  
- **Model** → core logic (`Game`, `Player`, `Score`, `Lives`, `Recipe`, `RecipeFactory`)  
- **Util** → timer management with ScalaFX `Timeline`  


**OOP Principles Applied**:  
- **Inheritance** → `RecipeType` trait extended by Bread, Cake, etc.  
- **Polymorphism** → flexible recipe handling via `RecipeType` references  
- **Abstraction** → abstract class defines recipe structure & enforces consistency  
- **Encapsulation** → player stats and game state handled through dedicated classes  


## 🎨 User Interface  

- **Home Screen** → retro-style bakery theme with scrolling background  
- **Game Screen** → recipe area, ingredient input, clickable buttons, status indicators  
- **Instruction Screen** → visual examples with minimal text for easy onboarding  


## 📹 Project Showcase  
- **Demo Video** → [YouTube Presentation](https://youtu.be/vHKk1w6WKVQ)  


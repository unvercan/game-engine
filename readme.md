# 🎮 Game Engine – Memento Pattern Demo

This project demonstrates the **Memento Design Pattern** using a game scenario where players can save and restore their state.

## 🧩 Pattern Roles

- **Originator**: `Player`  
  Stores game state (health, position, etc.) and can restore from a saved state.

- **Memento**: `State`  
  An immutable snapshot of the player's internal state.

- **Caretaker**:
    - `SaveSlotManagerImpl` – single save/load slot
    - `CheckpointManagerImpl` – stack-based multiple checkpoints (undo support)

## 🚀 Features

- Simulates actions: walk, run, attack, take damage
- Supports both single-slot and multi-checkpoint save/load

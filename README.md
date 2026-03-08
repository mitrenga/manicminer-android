# Manic Miner Android

Native Android application serving as a wrapper for the web-based remake of the classic **Manic Miner** (1983) game originally created by Matthew Smith for the ZX Spectrum.

## About

This app makes the Manic Miner web game accessible to Android device users through a modern WebView with native elements — splash screen, app icons, and Game Mode support.

## Requirements

- Android 8.0 (API 26)+
- Android Studio (latest stable version)
- Kotlin

## Project Structure

```
app/src/main/
├── kotlin/cz/libmit/manicminer/
│   ├── MainActivity.kt       # WebView loading manicminer.free
│   └── SplashActivity.kt     # Splash screen with logo and authorship text
├── res/
│   ├── drawable/             # Willy sprite
│   ├── mipmap-*/             # App icons
│   ├── values/               # Strings, themes
│   └── xml/game_mode_config.xml
└── AndroidManifest.xml
```

## Development Setup

Open the project in Android Studio — it will handle Gradle sync automatically.

```bash
# Clone the repo
git clone https://github.com/mitrenga/manicminer-android.git

# Open in Android Studio
# File → Open → select the manicminer-android directory
```

## Milestones

- [x] M1 — Project foundation: WebView loading manicminer.free
- [x] M2 — Splash screen: logo and authorship text, min. 1.5s display, fade-out transition
- [x] M3 — Icons: integration into mipmap directories
- [x] M4 — Game Mode: performance mode via game_mode_config.xml
- [ ] M5 — Testing: deployment to physical device via USB

## Credits

Original game **Manic Miner** by Matthew Smith (1983), published by Bug-Byte Software for the ZX Spectrum.

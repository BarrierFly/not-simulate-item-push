# Not Simulate Item Push

A lightweight client-side Fabric mod that stops the client from simulating piston pushes on item entities (掉落物). The server continues to simulate normally.

## Features

Two independently toggleable features (Mod Menu integration, no restart needed):

| Feature | Default | What it does |
|---|---|---|
| **Not Simulate Item Push** | ON | Client skips piston movement simulation for item entities |
| **Disable Piston Collision** | OFF | Piston/piston head/moving piston blocks report empty collision shape |

All changes are **client-side only**.

## Requirements

- Minecraft 1.21.11
- Fabric Loader ≥ 0.16.0
- Java 21+
- Mod Menu (optional — for in-game config screen)

## Installation

Drop the JAR into your `.minecraft/mods/` folder.

## Configuration

If Mod Menu is installed, click the config button next to the mod in the mod list. Otherwise, edit `config/notsimulateitempush.json`:

```json
{
  "enabled": true,
  "disablePistonCollision": false
}
```

## Building from source

```bash
./gradlew build
```

Output: `build/libs/notsimulateitempush-<version>.jar`

## License

MIT

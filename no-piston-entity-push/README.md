# No Piston Entity Push

A lightweight client-side Fabric mod that prevents pistons from interacting with item entities (掉落物).

## Features

Two independently toggleable features:

| Feature | Default | What it does |
|---|---|---|
| **Drop Items Protected** | ON | Pistons won't push item entities (掉落物) |
| **Piston Block Collision** | OFF | Piston blocks report empty collision shape |

All changes are **client-side only** — the server is unaffected. Toggle via Mod Menu (optional dependency) without restarting.

## Requirements

- Minecraft 1.21.11
- Fabric Loader ≥ 0.16.0
- Java 21+
- Mod Menu (optional — for in-game config screen)

## Installation

Drop the JAR into your `.minecraft/mods/` folder.

## Configuration

If Mod Menu is installed, click the config button next to the mod in the mod list. Otherwise, edit `config/nopistonentity.json`:

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

Output: `build/libs/nopistonentity-<version>.jar`

## License

MIT

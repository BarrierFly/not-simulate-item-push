# Not Simulate Item Push / 不模拟物品推动

A lightweight client-side Fabric mod. Stops the client from simulating piston pushes on item entities (掉落物). Server simulation is unaffected.

一个轻量客户端 Fabric 模组。阻止客户端模拟活塞对物品实体（掉落物）的推动。服务端运算不受影响。

## Features / 功能

Two independently toggleable features (Mod Menu integration, no restart needed):

两个独立开关（Mod Menu 集成，无需重启）：

| Feature / 功能 | Default / 默认 | What it does / 说明 |
|---|---|---|
| **Skip Item Push** | ON / 开 | Client skips piston movement simulation for item entities / 客户端跳过活塞推动掉落物的模拟 |
| **Disable Piston Collision** | OFF / 关 | Piston/piston head/moving piston blocks report empty collision shape / 活塞底座/活塞头/移动方块报告无碰撞 |

All changes are **client-side only**.
所有修改**仅客户端生效**。

## Requirements / 运行要求

- Minecraft 1.21.11
- Fabric Loader ≥ 0.16.0
- Java 21+
- Mod Menu (optional / 可选 — for in-game config screen / 游戏内配置界面)

## Installation / 安装

Drop the JAR into your `.minecraft/mods/` folder.
将 JAR 文件放入 `.minecraft/mods/` 文件夹。

## Configuration / 配置

If Mod Menu is installed, click the config button in the mod list. Otherwise, edit `config/notsimulateitempush.json`:

如果安装了 Mod Menu，在模组列表点击配置按钮。否则手动编辑 `config/notsimulateitempush.json`：

```json
{
  "skipItemPush": true,
  "disablePistonCollision": false
}
```

## Building from source / 从源码构建

```bash
./gradlew build
```

Output / 输出: `build/libs/notsimulateitempush-<version>.jar`

## License / 许可

WTFPL — Do What The Fuck You Want To Public License

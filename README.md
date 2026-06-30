# Not Simulate Item Push / 不模拟物品推动

A lightweight client-side Fabric mod. Stops the client from simulating piston pushes on item entities (掉落物). Designed to significantly reduce client-side computation when running machines with many piston-pushed items (e.g. moss farms / 苔藓机).

一个轻量客户端 Fabric 模组。阻止客户端模拟活塞对物品实体（掉落物）的推动。旨在运行有大量活塞推掉落物的机器（如苔藓机）时大幅减小客户端运算量。

## Features / 功能

Three independently toggleable features (Mod Menu integration, no restart needed):

三个独立开关（Mod Menu 集成，无需重启）：

| Feature / 功能 | Default / 默认 | What it does / 说明 |
|---|---|---|
| **Skip Item Push** | ON / 开 | Client skips piston movement simulation for item entities / 客户端跳过活塞推动掉落物的模拟 |
| **Disable Piston Collision** | ON / 开 | Piston/piston head/moving piston blocks report empty collision shape / 活塞底座/活塞头/移动方块报告无碰撞 |
| **Disable Destroy Particles** | OFF / 关 | Client skips spawning block destruction particles (TerrainParticle) / 客户端跳过方块破坏粒子（TerrainParticle）的生成 |

### Recommended configuration / 推荐配置

For best performance, enable the first two options (which is the default). **Disable Destroy Particles** also reduces client-side computation, but the impact is relatively small.

为获得最佳性能，建议开启前两个选项（也是默认配置）。**Disable Destroy Particles** 也能减少客户端运算量，但影响相对较小。

> **Note:** **Disable Piston Collision** affects other client-side behaviors, such as entity (especially player) collision detection against piston-related blocks.
> **注意：Disable Piston Collision** 会影响客户端的其他行为，如其他实体（特别是玩家）对活塞相关方块的碰撞检测。

All changes are **client-side only**. Server simulation is unaffected.
所有修改**仅客户端生效**。服务端运算不受影响。

## Requirements / 运行要求

- Minecraft 1.19.4
- Fabric Loader ≥ 0.14.21
- Java 17+
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
  "disablePistonCollision": true,
  "disableDestroyParticles": false
}
```

## Other Minecraft versions / 其他 Minecraft 版本

If you need this mod for a different Minecraft version, feel free to **Vibe Code** it yourself, or [open an Issue](https://github.com/BarrierFly/not-simulate-item-push/issues).

如果你需要在其他 Minecraft 版本上使用此模组，可以自行 **Vibe Code**，也可以在 [Issues 中提出请求](https://github.com/BarrierFly/not-simulate-item-push/issues)。

## Building from source / 从源码构建

```bash
./gradlew build
```

Output / 输出: `build/libs/notsimulateitempush-1.19.4-<version>.jar`

## License / 许可

[WTFPL Version 2](http://www.wtfpl.net/) — Do What The Fuck You Want To Public License

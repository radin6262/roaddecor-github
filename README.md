# Road Decor

Road Decor is a Minecraft mod that adds decorative road elements to enhance your builds. Create realistic roads, traffic signs, barriers, and more.

![NeoForge](https://img.shields.io/badge/NeoForge-1.21.1-blue.svg)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-green.svg)
![License](https://img.shields.io/badge/License-All+Rights+Reserved-red.svg)

## Features

### Road Blocks

* **Asphalt** — Dark gray road surface.
* **Concrete** — Light gray road surface.
* **Painted Asphalt** — Asphalt with colored road markings.

### Traffic Signs

* **Stop Sign** — Red octagonal sign with rotation support.

### Road Barriers

* **Road Barrier** — Orange and white striped road barrier.

### Tools

* **Paint Roller** — Transforms asphalt into painted asphalt. Has durability and can be used as a practical road-building tool.

## Screenshots

Screenshots coming soon.

## Crafting Recipes

[//]: # ()
[//]: # (| Item            | Recipe                                 |)

[//]: # (| --------------- | -------------------------------------- |)

[//]: # (| Concrete        | 8 Stone + 1 Sand                       |)

[//]: # (| Asphalt         | 8 Sand + 1 Concrete                    |)

[//]: # (| Painted Asphalt | 1 Asphalt + 1 Red Dye                  |)

[//]: # (| Stop Sign       | 4 Red Concrete + 1 White Concrete      |)

[//]: # (| Road Barrier    | 2 Concrete + 2 Iron Ingots + 2 Sticks  |)

[//]: # (| Paint Roller    | 1 Yellow Wool + 1 Iron Ingot + 1 Stick |)

* Coming Soon *

## Installation

### Requirements

* Minecraft **1.21.1**
* NeoForge **21.1.244 or newer**

### Steps

1. Download the mod JAR file from the [Releases](../../releases) page.
2. Place the JAR file into your Minecraft `mods` folder.
3. Launch Minecraft using NeoForge.

## Development

### Setup

Clone the repository and navigate into the project directory:

```bash
git clone https://github.com/yourusername/roaddecor.git
cd roaddecor
```

### Building

Build the mod using:

```bash
./gradlew build
```

### Running Data Generation

Generate the required data files using:

```bash
./gradlew runData
```

### Running the Client

Launch the development Minecraft client using:

```bash
./gradlew runclient
```

## Project Structure

```text
src/main/java/radin6262/road/decor/
├── RoadDecor.java
├── blocks/
│   ├── AsphaltBlock.java
│   ├── ConcreteBlock.java
│   ├── PaintedAsphaltBlock.java
│   ├── StopSignBlock.java
│   └── RoadBarrierBlock.java
├── items/
│   ├── PaintRollerItem.java
│   └── ...
├── registry/
│   ├── ModBlocks.java
│   ├── ModItems.java
│   └── ...
└── datagen/
    ├── ModBlockTagsProvider.java
    ├── ModLootTableProvider.java
    ├── ModRecipeProvider.java
    └── ...
```
* you get it ye? *
## Contributing

Contributions are welcome.

** Hey we're still working on this section **
## License

**All Rights Reserved**

Road Decor is open-source for personal and modpack use, but is **not permitted for commercial redistribution**.

### You may:

* Use the mod in your modpacks.
* Modify the mod for personal use.
* Report bugs.
* Suggest new features.

### You may not:

* Redistribute the mod without permission.
* Use the mod or its contents for commercial purposes.

For permission regarding redistribution or commercial use, contact the developer.

## Support

For bug reports and feature requests, use the repository's **GitHub Issues** section.

## Roadmap

The following features are planned for future versions:

* [ ] More traffic signs

    * [ ] Yield Sign
    * [ ] Speed Limit Signs
    * [ ] One Way Sign
* [ ] Traffic lights with redstone integration
* [ ] Road markings

    * [ ] Directional arrows
    * [ ] Crosswalks
* [ ] Street lamps
* [ ] Custom textures
* [ ] Advancement system

The roadmap is subject to change as development continues.

## Credits

**Developer:** radin6262

### Tools Used

* [Blockbench](https://www.blockbench.net/) — 3D modeling
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) — Integrated development environment
* [NeoForge](https://neoforged.net/) — Minecraft mod loader

## Star History

If you enjoy Road Decor and find it useful, consider giving the repository a star on GitHub.


## Links

* [NeoForge Documentation](https://docs.neoforged.net/)
* [Minecraft](https://www.minecraft.net/)
* [Blockbench](https://www.blockbench.net/)

---

Developed by **radin6262** for the Minecraft community.

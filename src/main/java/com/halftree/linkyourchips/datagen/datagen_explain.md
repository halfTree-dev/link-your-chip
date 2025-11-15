DataGen 是一种可以根据配置代码自动生成数据 JSON 文件的工具，免去了手动编写数据文件的繁琐工作。

在执行
```
./gradlew runData
```
命令时，DataGen 会读取位于 `src/main/java/com/halftree/linkyourchips/datagen/` 目录下的各种数据生成器类（如 `ModBlockTagGenerator`、`ModItemTagGenerator`、`ModLootTableProvider`、`ModRecipeProvider`、`ModItemModelProvider` 等），并根据这些类中的配置逻辑生成对应的数据 JSON 文件。
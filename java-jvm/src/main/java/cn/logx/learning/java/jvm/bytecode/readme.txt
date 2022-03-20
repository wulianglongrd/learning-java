1. 魔数：所有的.class字节码文件的前4个字节都是魔数，魔数值为固定值：0xCAFEBABE
2. 魔数之后的4个字节为版本信息，前两个字节表示minor version(次版本号)，后两个字节表示major version(主版本号)。
   0000 0034，换算成十进制为 0 52,即次版本号为0，主版本号为52，对应的JDK的版本号为 1.8.0
   @see https://stackoverflow.com/questions/9170832/list-of-java-class-file-format-major-version-numbers
   @see https://en.wikipedia.org/wiki/Java_class_file#General_layout


类加载


- 在Java代码中，类型的加载、连接与初始化过程都是在程序运行期间完成的
- 提供了更大的灵活性，增加了更多的可能性


- java虚拟机与程序的生命周期
- 在如下几种情况下，java虚拟机将结束生命周期
 - 执行了System.exit方法
 - 程序正常执行结束
 - 程序在执行过程中遇到了异常或错误而异常终止
 - 由于操作系统出现错误而导致java虚拟机进程终止


类的生命周期（@see class-life-cycle.png）
1. 加载：查找并加载类的二进制数据
 类的加载指的是将类的.class文件中的二进制数据读入内存中，将其放在运行时的数据区的方法区，然后在
 内存中创建一个java.lang.Class对象（规范并未说明class对象位于哪里，HotSpot虚拟机将其放在了
 方法区中）用来封装类在方法区内数据结构
 a. 加载.class文件的方式
 - 从本地系统中直接加载
 - 通过网络下载.class文件
 - 从zip、jar等归档文件中加载.class文件
 - 从专有数据库中提取.class文件
 - 将java源文件动态编译为.class文件
 b. 类的加载虚拟机参数
 XX:+TraceClassLoading
2. 连接
 - 验证：确保被加载的类的正确性
   - 类文件的结构检查、语义检查、字节码验证、二进制兼容检查
 - 准备：为类的静态变量分配内存，并将其设置为默认值，但在达到初史化之前，类变量都没有初始化为真正的初始值。
 - 解析：解析过程就是在类型的常量池中寻找类、接口、字段和方法的符号引用，把这些符号引用替换成直接引用。
3. 初史化：为类的静态变量赋予正确的初始化值。类或接口"首次主动使用"时才会初始化他们
   - 假如这个类还没有被加载和连接，那就先进行加载和连接
   - 假如类存在直接父类，并且这个父类还没有被初始化，那就先初始化直接父类。但不这条规则不适用于接口
    a. 在初始化一个类时，并不会先初始化它所实现的接口
    b. 在初始化一个接口时，并不会先初始化它的父接口
    因此：一个父接口并不会因为它的子接口或者实现类的初始化而初始化。只有当程序首次使用特定接口的静态变量时，才会导致该接口初始化。
   - 假如类存在初始化语句，那就依次执行这些初始化语句

4. 使用
5. 卸载
  a. 一个类何时结束生命周期，取决于代表它的Class对象何时结束生命周期。
  b. 由java虚拟机自带的类加载器所加载的类，在虚拟机的生命周期中，始终不会被卸载。
  包括启动类加载器、扩展类加载器、系统类加载器。java虚拟机本身会始终引用这些类加载器，
  而这些类加载器则会始终引用它们所加载的类的Class对象，因此这些Class对象始终是可触及的。
  c. 用户自定义的类加载器所加载的类是可以被卸载的


java程序对类的使用方式可分为两种
1. 主动使用
 - 创建类的实例
 - 访问某个类或接口的静态变量，或者对该静态变量赋值
 - 调用类的静态方法
 - 反射，如 Class.forName("foo.bar")
 - 初始化一个类的子类
 - java虚拟机启动时被标注为启动类的类，如含main方法的类
 - JDK1.7开始提供的动态语言支持：MethodHandle实例的解析结果REF_getStatic, REF_putStatic, REF_invokeStatic句柄对应的类没有初始化，则初始化
2. 被动使用
   被动使用不会导致类被初始化。

类的加载
1. 类的加载的最终产品是位于内存中的Class对象
2. Class对象封装了类的方法区的数据结构，并且向java程序员提供了访问方法区内的数据结构的接口。
3. 有两种类型的类加载器
 a. Java虚拟机自带的加载器
  - 根类加载器（启动类加载器, BootstrapClassLoader），通过 getClassLoader获取到的一般是null值
  - 扩展类加载器（ExtClassLoader）
  - 系统（应用）类加载器（AppClassLoader）
 b. 用户自定义的类加载器
  - java.lang.ClassLoader的子类
  - 用户可以定制类的加载方式
4. 类加载并不需要等到某个类被"首次主动使用"时才加载它
5. JVM规范允许类加载器在预料某个类将要被使用时就预先加载它，如果在预先加载的过程中遇到了.class文件缺乏或存在错误，
类加载器必须在"程序首次主动"使用该类时才报告 LinkageError 错误。如果这个类一直没有被程序主动使用，那么类加载器不会报告错误。


类加载器的双亲委托机制（@see classload.png）
 根类加载器 > 扩展类加载器 > 系统类加载器 > 自定义类加载器
- 某个类加载器加载类时，首先会把加载任务交给父加载器，若父加载器还有父加载器，则会继续把加载任务交给父类，
  （自底向上检查类是否已加载）
- 若最顶层的父类加载器无法加载类，则会返回把加载任务交给直接子类，若直接子类仍无法加载，则会继续把加载任务交给子类
  （自顶向下尝试加载类）
- 若子类加载成功，则会直接返回加载成功。若最低层的加载器也加载不成功，则宣告类加载失败
上面描述的加载流程，称为双亲委托机制(parent delegate) @see ClassLoader#loadClass(String name, boolean resolve)

双亲委托机制的优点是能够提高软件系统的安全性。因为在此机制下，用户自定义的类加载器不可能加载应该由父加载器加载的可靠类，
从而防止不可靠甚至恶意的代码代替父加载器加载的可靠代码。


命名空间
1. 每个类加载器都有自己的命名空间，命名空间由该加载器及所有父加载器所加载的类组成。
简单理解：如果两个类加载器使用不同的名称，且两个类加载器没有委托（delegate）关系，则认为是不同的命名空间
2. 在同一个命名空间中，不会出现类全名（包括类的包名）相同的两个类
3. 在不同的命名空间中，可能会出现类全名（包括类的包名）相同的两个类


自定义类加载器
要创建用户自己的类加载器，只需要扩展java.lang.ClassLoader类，然后覆盖它的findClass方法即可，该方法
根据参数指定的类的名字，返回对应的Class对象的引用。



GC: 常见的垃圾回收算法、GC问题排查
CMS
并发

spring
IOC
AOP
扩展机器

Mapper

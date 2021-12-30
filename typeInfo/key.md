1.instanceof 和 直接比较class的区别
例子:
  class Base{}
  class Derived extends Base{}
  ...
  new Derived() instanceof Base; // 返回true
  而直接比较class会失败 ;
  
  
2.反射和RTTI的区别
  RTTI在编译时打开和检查.class文件；
  反射机制: .class文件在编译时是不可获取的，所以在运行时通过JVM打开和检查.class文件

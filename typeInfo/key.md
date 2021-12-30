1.instanceof 和 直接比较class的区别
例子:
  class Base{}
  class Derived extends Base{}
  ...
  new Derived() instanceof Base; // 返回true
  而直接比较class会失败 ;
  
  

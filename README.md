# AppModuleDemo
组件化练习
组件化开发  1.正常启动的application的组件  可以包括启动页 首页等
          2.一个base 的lib  可以包括所有的base类  如baseactivity 等 所有的lib都依赖这个lib还可以将各种工具类放入到这个lib中
          3.各个模块的lib  各自完成自己模块的功能  更具需要 依赖其他的lib
          4.baselib 依赖的gradle  具有穿透性  其他的lib 不用在依赖了

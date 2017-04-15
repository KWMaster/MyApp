# MyApp
这是一个新闻app，tablayout+viewpager实现了主页的新闻
drawerlayout实现左滑菜单
//用到了commentpullrefresh框架来刷新
com.chanven.lib:cptr:1.1.0
//fresco加载图片
com.facebook.fresco:fresco:1.1.0
//DefaultLoadingLayout SmartLoadingLayout网络等待加载界面
me.rawnhwang.library:app:1.2.5
//网络请求 易源API
com.squareup.retrofit2:retrofit:2.2.0
com.squareup.retrofit2:converter-gson:2.2.0
//头部轮播框架
com.youth.banner:banner:1.4.9
//换肤框架========混淆时要这样子导入
compile('com.solid.skin:skinlibrary:1.4.0') {
   exclude group: 'com.android.support', module: 'appcompat-v7'
   exclude group: 'com.android.support', module: 'cardview-v7'
}
//返回顶部的floatingactionbutton框架
com.melnykov:floatingactionbutton:1.3.0

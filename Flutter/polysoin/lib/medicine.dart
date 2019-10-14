import 'package:flutter/material.dart';
import 'package:polysoin/drawer.dart';
import 'package:polysoin/profile.dart';
import 'package:polysoin/tabview/today.dart';
import 'package:polysoin/tabview/all.dart';
import 'package:polysoin/tabview/history.dart';



void main() => runApp(Medicine());

class Medicine extends StatefulWidget {
  @override
  _MedicineState createState() => _MedicineState();
}

class _MedicineState extends State<Medicine> with SingleTickerProviderStateMixin{
  TabController _tabController;
  List tabs = ["ALL", "TODAY", "HISTORY"];

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: tabs.length, vsync: this,initialIndex: 1,);
    _tabController.addListener(() {});
  }
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
          appBar: AppBar(
            title: Text("LIST OF MEDECINE"),
            bottom: TabBar(   //生成Tab菜单
                controller: _tabController,
                tabs: tabs.map((e) => Tab(text: e)).toList()
            ),
            actions: <Widget>[ //导航栏右侧菜单
              IconButton(icon: Icon(Icons.share), onPressed: () {}),
            ],

          ),
          drawer: new MyDrawer(), //抽屉
          body: Padding(
            padding: const EdgeInsets.all(12.0),
            child: TabBarView(
              controller: _tabController,
              children: _tabBarView(),
            ),
          ),

      ),
    );
  }
  List<Widget> _tabBarView(){
    List<Widget> widgetList = [All(),Today(),History()];
    return widgetList;
  }
}
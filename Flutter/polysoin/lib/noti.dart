import 'package:flutter/material.dart';
import 'package:polysoin/drawer.dart';

class Noti extends StatefulWidget {
  @override
  _NotiState createState() => _NotiState();
}

class _NotiState extends State<Noti> with SingleTickerProviderStateMixin{

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(

        appBar: AppBar(
          title: Text("NOTIFICATION"),
        ),
        drawer: new MyDrawer(), //抽屉
        floatingActionButton: FloatingActionButton( //悬浮按钮
          child: Icon(Icons.add),
          onPressed:_onAdd,
          backgroundColor: Colors.amber,
        ),
      ),
    );
  }

  void _onAdd(){


  }
}
import 'package:flutter/material.dart';
import 'package:polysoin/addMedicine.dart';

class Today extends StatefulWidget {
  @override
  _TodayState createState() => _TodayState();
}

class _TodayState extends State<Today> with SingleTickerProviderStateMixin{
  bool _checkboxSelected1=true;
  bool _checkboxSelected2=false;
  bool _checkboxSelected3=false;
  Color bgColor = Colors.blue.shade50;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SafeArea(
          child: ListView(
            children: <Widget>[
              Container(
                decoration: BoxDecoration(
                  color: Colors.amberAccent.shade100,
                  borderRadius: BorderRadius.all(Radius.circular(15))
                ),
                height: 30,
                margin: EdgeInsets.only(bottom: 10),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Text("Morning",style: TextStyle(fontSize: 16),),
                  ],
                ),
              ),
              Container(
                margin: EdgeInsets.only(bottom: 10),
                decoration: BoxDecoration(
                    color: bgColor,
                    borderRadius: BorderRadius.all(Radius.circular(10))
                ),
                child: Row(
                  children: <Widget>[
                    Checkbox(
                      value: _checkboxSelected1,
                      activeColor: Colors.blue, //选中时的颜色
                      onChanged:(value){
                        setState(() {
                          _checkboxSelected1=value;
                        });
                      } ,
                    ),
                    Expanded(
                      child: Padding(
                        padding: const EdgeInsets.all(15.0),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: <Widget>[
                            Text("Medicine 1",
                              style: TextStyle(
                                fontSize: 18,
                              ),
                            ),
                            Text("10 a.m.",
                              style: TextStyle(
                                fontSize: 16,
                                color: Colors.grey,
                              ),
                            )
                          ],
                        ),
                      ),
                    ),
                    IconButton(
                      icon: Icon(Icons.info_outline),
                      onPressed: null,
                    ),
                  ],
                ),
              ),
              Container(
                decoration: BoxDecoration(
                    color: Colors.amberAccent.shade100,
                    borderRadius: BorderRadius.all(Radius.circular(15))
                ),
                height: 30,
                margin: EdgeInsets.only(top:10,bottom: 10),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Text("Afternoon",style: TextStyle(fontSize: 16),),
                  ],
                ),
              ),
              Container(
                margin: EdgeInsets.only(bottom: 10),
                decoration: BoxDecoration(
                    color: bgColor,
                    borderRadius: BorderRadius.all(Radius.circular(10))
                ),
                child: Row(
                  children: <Widget>[
                    Checkbox(
                      value: _checkboxSelected2,
                      activeColor: Colors.blue, //选中时的颜色
                      onChanged:(value){
                        setState(() {
                          _checkboxSelected2=value;
                        });
                      } ,
                    ),
                    Expanded(
                      child: Padding(
                        padding: const EdgeInsets.all(15.0),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: <Widget>[
                            Text("Medicine 2",
                              style: TextStyle(
                                fontSize: 18,
                              ),
                            ),
                            Text("1 p.m.",
                              style: TextStyle(
                                fontSize: 16,
                                color: Colors.grey,
                              ),
                            )
                          ],
                        ),
                      ),
                    ),
                    IconButton(
                      icon: Icon(Icons.info_outline),
                      onPressed: null,
                    ),
                  ],
                ),
              ),
              Container(
                margin: EdgeInsets.only(bottom: 10),
                decoration: BoxDecoration(
                    color: bgColor,
                    borderRadius: BorderRadius.all(Radius.circular(10))
                ),
                child: Row(
                  children: <Widget>[
                    Checkbox(
                      value: _checkboxSelected3,
                      activeColor: Colors.blue, //选中时的颜色
                      onChanged:(value){
                        setState(() {
                          _checkboxSelected3=value;
                        });
                      } ,
                    ),
                    Expanded(
                      child: Padding(
                        padding: const EdgeInsets.all(15.0),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: <Widget>[
                            Text("Medicine 3",
                              style: TextStyle(
                                fontSize: 18,
                              ),
                            ),
                            Text("5 p.m.",
                              style: TextStyle(
                                fontSize: 16,
                                color: Colors.grey,
                              ),
                            )
                          ],
                        ),
                      ),
                    ),
                    IconButton(
                      icon: Icon(Icons.info_outline),
                      onPressed: null,
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
        floatingActionButton: FloatingActionButton( //悬浮按钮
          child: Icon(Icons.add),
          onPressed:_onAdd,
          backgroundColor: Colors.amber,
        ),

    );
  }

  void _onAdd(){
    showDialog(
        context: context,
        child: new SimpleDialog(
          title: const Text("Select"),
          children: <Widget>[
            SimpleDialogOption(
              onPressed: (){
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => AddMedicine()),
                );
              },
              child: Row(
                children: <Widget>[
                  Icon(Icons.create),
                  Text("  Manual Input",style: TextStyle(fontSize: 18),),
                ],
              ),
            ),
            SimpleDialogOption(
              onPressed: (){},
              child: Row(
                children: <Widget>[
                  Icon(Icons.camera_alt),
                  Text("  Scan barcode",style: TextStyle(fontSize: 18),),
                ],
              ),
            ),
          ],
        ));
  }
}
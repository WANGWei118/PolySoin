import 'package:flutter/material.dart';
import 'package:polysoin/drawer.dart';


class Profile extends StatefulWidget {
  @override
  _ProfileState createState() => _ProfileState();
}

class _ProfileState extends State<Profile> with SingleTickerProviderStateMixin{

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        backgroundColor: Colors.blue.shade200,

        appBar: AppBar(
          backgroundColor: Colors.blue.shade200,

          title: Text("PROFILE"),
          elevation: 0,
        ),
        drawer: new MyDrawer(), //抽屉
        body: SafeArea(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: ClipOval(
                  child: Image.asset(
                    "image/avatar.jpg",
                    width: 120,
                  ),
                ),
              ),

              Text(
                  "John",
                style:TextStyle(
                  color: Colors.white,
                  fontSize: 30,
                ),
              ),
              Text("",
                style:TextStyle(
                  color: Colors.white,
                  fontSize: 20,
                ),
              ),
              SizedBox(
                height: 20,
                width: 300,
                child: Divider(
                  color: Colors.blue.shade700,
                ),
              ),
              Container(

              ),
            ],
          ),
        ),
      ),
    );
  }
}
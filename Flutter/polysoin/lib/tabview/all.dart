import 'package:flutter/material.dart';

class All extends StatefulWidget {
  @override
  _AllState createState() => _AllState();
}

class _AllState extends State<All> with SingleTickerProviderStateMixin{
  Color bgColor = Colors.green.shade50;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: ListView(
          children: <Widget>[
            Container(
              margin: EdgeInsets.only(bottom: 10),
              decoration: BoxDecoration(
                  color: bgColor,
                  borderRadius: BorderRadius.all(Radius.circular(10))
              ),
              child: Row(
                children: <Widget>[
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
              margin: EdgeInsets.only(bottom: 10),
              decoration: BoxDecoration(
                  color: bgColor,
                  borderRadius: BorderRadius.all(Radius.circular(10))
              ),
              child: Row(
                children: <Widget>[
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
            Container(
              margin: EdgeInsets.only(bottom: 10),
              decoration: BoxDecoration(
                  color: bgColor,
                  borderRadius: BorderRadius.all(Radius.circular(10))
              ),
              child: Row(
                children: <Widget>[
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
              margin: EdgeInsets.only(bottom: 10),
              decoration: BoxDecoration(
                  color: bgColor,
                  borderRadius: BorderRadius.all(Radius.circular(10))
              ),
              child: Row(
                children: <Widget>[
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

    );
  }

}
import 'package:flutter/material.dart';

class History extends StatefulWidget {
  @override
  _HistoryState createState() => _HistoryState();
}

class _HistoryState extends State<History> with SingleTickerProviderStateMixin{
  bool _checkboxSelected1=true;
  bool _checkboxSelected2=false;
  bool _checkboxSelected3=false;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: ListView(
          children: <Widget>[
            Container(
              margin: EdgeInsets.only(bottom: 10),
              decoration: BoxDecoration(
                  color: Colors.blue.shade50,
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
                  color: Colors.blue.shade50,
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
                  color: Colors.blue.shade50,
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
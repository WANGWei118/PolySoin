import 'package:flutter/material.dart';
import 'package:polysoin/medicine.dart';
import 'package:polysoin/profile.dart';
import 'package:polysoin/noti.dart';

class MyDrawer extends StatelessWidget {
  const MyDrawer({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: MediaQuery.removePadding(
        context: context,
        removeTop: true,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Padding(
              padding: const EdgeInsets.only(top: 38.0),
              child: Container(
                height: 120,
                color: Colors.blue,
                child: Row(
                  children: <Widget>[
                    Padding(
                      padding: const EdgeInsets.symmetric(horizontal: 16.0),
                      child: ClipOval(
                        child: Image.asset(
                          "image/avatar.jpg",
                          width: 80,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.only(top: 20),
                      child: Column(
                        children: <Widget>[
                          Text(
                            "John",
                            style: TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 24,
                              color: Colors.white,
                            ),
                          ),
                          Padding(
                            padding: const EdgeInsets.all(8.0),
                            child: Text(
                              "Age 81",
                              style: TextStyle(
                                fontSize: 16,
                                color: Colors.white,
                              ),
                            ),
                          ),
                        ],
                      ),
                    )
                  ],
                ),
              ),
            ),
            Expanded(
              child: ListView(
                children: <Widget>[
                  ListTile(
                    leading: const Icon(Icons.person),
                    title: const Text('Profile'),
                    onTap:() {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => Profile()),
                      );
                    },
                  ),
                  ListTile(
                    leading: const Icon(Icons.apps),
                    title: const Text('List of medicines'),
                    onTap:() {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => Medicine()),
                      );
                    },
                  ),
                  ListTile(
                    leading: const Icon(Icons.chrome_reader_mode),
                    title: const Text('Diagnosis'),
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
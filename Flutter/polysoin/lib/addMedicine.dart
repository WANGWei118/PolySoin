import 'package:flutter/material.dart';
import 'package:flutter_datetime_picker/flutter_datetime_picker.dart';

class AddMedicine extends StatefulWidget {
  @override
  _AddMedicineState createState() => _AddMedicineState();
}

class _AddMedicineState extends State<AddMedicine> with SingleTickerProviderStateMixin{
  String _date = "Not set";
  String _time = "Not set";
  Color _themeColor = Colors.teal;
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Theme(
        data: ThemeData(
        primarySwatch: _themeColor, //用于导航栏、FloatingActionButton的背景色等
        iconTheme: IconThemeData(color: _themeColor) //用于Icon颜色
        ),child: Scaffold(
        appBar: AppBar(
          title: Text("ADD A MEDICINE"),
        ),
        body: SafeArea(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: ListView(
              children: <Widget>[
                Padding(
                  padding: const EdgeInsets.only(bottom:16.0),
                  child: TextField(
                    decoration: InputDecoration(
                      labelText: "Name of medicine",
                      prefixIcon: Icon(Icons.local_hospital),
                    ),
                  ),
                ),
                RaisedButton(
                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(5.0)),
                  elevation: 4.0,
                  onPressed: () {
                    DatePicker.showDatePicker(context,
                        theme: DatePickerTheme(
                          containerHeight: 210.0,
                        ),
                        showTitleActions: true,
                        minTime: DateTime(2000, 1, 1),
                        maxTime: DateTime(2022, 12, 31), onConfirm: (date) {
                          print('confirm $date');
                          _date = '${date.year} - ${date.month} - ${date.day}';
                          setState(() {});
                        }, currentTime: DateTime.now(), locale: LocaleType.en);
                  },
                  child: Container(
                    alignment: Alignment.center,
                    height: 50.0,
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: <Widget>[
                        Row(
                          children: <Widget>[
                            Container(
                              child: Row(
                                children: <Widget>[
                                  Icon(
                                    Icons.date_range,
                                    size: 18.0,
                                    color: Colors.teal,
                                  ),
                                  Text(
                                    " $_date",
                                    style: TextStyle(
                                        color: Colors.teal,
                                        fontWeight: FontWeight.bold,
                                        fontSize: 18.0),
                                  ),
                                ],
                              ),
                            )
                          ],
                        ),
                        Text(
                          "  Change",
                          style: TextStyle(
                              color: Colors.teal,
                              fontWeight: FontWeight.bold,
                              fontSize: 18.0),
                        ),
                      ],
                    ),
                  ),
                  color: Colors.white,
                ),
                SizedBox(
                  height: 20.0,
                ),
                RaisedButton(
                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(5.0)),
                  elevation: 4.0,
                  onPressed: () {
                    DatePicker.showTimePicker(context,
                        theme: DatePickerTheme(
                          containerHeight: 210.0,
                        ),
                        showTitleActions: true, onConfirm: (time) {
                          print('confirm $time');
                          _time = '${time.hour} : ${time.minute} : ${time.second}';
                          setState(() {});
                        }, currentTime: DateTime.now(), locale: LocaleType.en);
                    setState(() {});
                  },
                  child: Container(
                    alignment: Alignment.center,
                    height: 50.0,
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: <Widget>[
                        Row(
                          children: <Widget>[
                            Container(
                              child: Row(
                                children: <Widget>[
                                  Icon(
                                    Icons.access_time,
                                    size: 18.0,
                                    color: Colors.teal,
                                  ),
                                  Text(
                                    " $_time",
                                    style: TextStyle(
                                        color: Colors.teal,
                                        fontWeight: FontWeight.bold,
                                        fontSize: 18.0),
                                  ),
                                ],
                              ),
                            )
                          ],
                        ),
                        Text(
                          "  Change",
                          style: TextStyle(
                              color: Colors.teal,
                              fontWeight: FontWeight.bold,
                              fontSize: 18.0),
                        ),
                      ],
                    ),
                  ),
                  color: Colors.white,
                )
              ],
            ),
          ),
        ),
      ),
      ),
    );
  }

}
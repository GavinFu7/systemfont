
import 'package:flutter/services.dart';

class systemFont {
  static Future<List<String>> getFontList() async {
    final fontList = await MethodChannel('systemFont').invokeMethod<List<Object?>>('getAllFonts');
    return fontList?.map((e) => e.toString()).toList() ?? [];
  }
}
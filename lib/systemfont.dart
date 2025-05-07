
import 'package:flutter/services.dart';

Future<List<String>> getSystemFontList() async {
  final fontList = await MethodChannel('systemFont').invokeMethod<List<Object?>>('getAllFonts');
  return fontList?.cast<String>() ?? [];
}
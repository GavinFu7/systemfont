# systemfont

取得iOS設備中的字體列表

Get fonts list in iOS device

## Getting Started

### Use this package

This will add a line like this to your package's pubspec.yaml (and run an implicit flutter pub get):

```yaml
dependencies:
  systemfont: 
    git:
      url: https://github.com/GavinFu7/systemfont.git
```

### Get System Fonts

```dart
import 'package:systemfont/systemfont.dart';

.
.
.

List<String> fonts = await getSystemFontList();
```

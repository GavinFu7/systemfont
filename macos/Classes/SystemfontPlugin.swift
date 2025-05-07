import Cocoa
import FlutterMacOS

public class SystemfontPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "systemFont", binaryMessenger: registrar.messenger)
    let instance = SystemfontPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    switch call.method {
    case "getAllFonts":
      result(NSFontManager.shared.availableFontFamilies)
    default:
      result(FlutterMethodNotImplemented)
    }
  }
}
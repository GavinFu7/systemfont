package com.example.systemfont

import androidx.annotation.RequiresApi
import android.os.Build
import android.content.Context
import android.graphics.Typeface
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** SystemfontPlugin */
class SystemfontPlugin: FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel
  private lateinit var context: Context

  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    context = flutterPluginBinding.applicationContext
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "systemFont")
    channel.setMethodCallHandler(this)
  }

  fun getCustomFonts(): List<String> {
    return try {
        context.assets.list("fonts")?.toList() ?: emptyList()
    } catch (e: Exception) {
        emptyList()
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method == "getAllFonts") {
      val fonts = mutableListOf<String>()

      // 1. 添加默认系统字体
      fonts.addAll(listOf("sans-serif", "serif", "monospace"))

      // 2. 添加自定义字体（如果有）
      fonts.addAll(getCustomFonts())

      result.success(fonts)
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}

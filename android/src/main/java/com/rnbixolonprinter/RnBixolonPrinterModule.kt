package com.rnbixolonprinter.PrinterControl

import android.content.Context
import com.bxl.config.editor.BXLConfigLoader
import com.facebook.react.bridge.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class RNBixolonPrinterModule(
        private val reactContext: ReactApplicationContext
) : ReactContextBaseJavaModule(reactContext) {

    private val appContext: Context
        get() = reactContext.applicationContext

    private var activePrinterSession: BixolonPrinterSession? = null

    override fun getName(): String {
        return "RNBixolonPrinter"
    }

    @ReactMethod
    fun multiply(a: Int, b: Int, promise: Promise) {
      promise.resolve(a * b)
    }

    @ReactMethod
    open fun getProductName(name: String): String? {
      var productName = BXLConfigLoader.PRODUCT_NAME_SPP_R200II
      when (name) {
          "SPP-R200III" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_R200III
          }
          "SPP-R210" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_R210
          }
          "SPP-R215" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_R215
          }
          "SPP-R220" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_R220
          }
          "SPP-C200" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_C200
          }
          "SPP-R300" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_R300
          }
          "SPP-R310" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_R310
          }
          "SPP-R318" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_R318
          }
          "SPP-C300" -> {
            //productName = BXLConfigLoader.PRODUCT_NAME_SPP_C300;
          }
          "SPP-R400" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_R400
          }
          "SPP-R410" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_R410
          }
          "SPP-R418" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_R418
          }
          "SPP-100II" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_100II
          }
          "SRP-350IIOBE" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_350IIOBE
          }
          "SRP-350III" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_350III
          }
          "SRP-352III" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_352III
          }
          "SRP-350plusIII" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_350PLUSIII
          }
          "SRP-352plusIII" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_352PLUSIII
          }
          "SRP-380" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_380
          }
          "SRP-382" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_382
          }
          "SRP-383" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_383
          }
          "SRP-340II" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_340II
          }
          "SRP-342II" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_342II
          }
          "SRP-Q200" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_Q200
          }
          "SRP-Q300" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_Q300
          }
          "SRP-Q302" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_Q302
          }
          "SRP-QE300" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_QE300
          }
          "SRP-QE302" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_QE302
          }
          "SRP-E300" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_E300
          }
          "SRP-E302" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_E302
          }
          "SRP-B300" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_B300
          }
          "SRP-330II" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_330II
          }
          "SRP-332II" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_332II
          }
          "SRP-S200" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_S200
          }
          "SRP-S300" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_S300
          }
          "SRP-S320" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_S320
          }
          "SRP-S3000" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_S3000
          }
          "SRP-F310" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_F310
          }
          "SRP-F312" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_F312
          }
          "SRP-F310II" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_F310II
          }
          "SRP-F312II" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_F312II
          }
          "SRP-F313II" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_F313II
          }
          "SRP-275III" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SRP_275III
          }
          "BK3-2" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_BK3_2
          }
          "BK3-3" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_BK3_3
          }
          "SMB6350" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SMB6350
          }
          "SLP X-Series" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SLP_X_SERIES
          }
          "SLP-DX420" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SLP_DX420
          }
          "SPP-L410II" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SPP_L410II
          }
          "XM7-40" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_XM7_40
          }
          "MSR" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_MSR
          }
          "CashDrawer" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_CASH_DRAWER
          }
          "LocalSmartCardRW" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_LOCAL_SMART_CARD_RW
          }
          "SmartCardRW" -> {
            productName = BXLConfigLoader.PRODUCT_NAME_SMART_CARD_RW
          }
      }
      return productName
    }

    /**
     * Runs a Bluetooth scan looking for the fist device
     * which name includes [BixolonPrinter.TARGET_DEVICE_NAME]
     *
     * Prequesties:
     * - Pair the device using Android Bluetooth settings.
     *
     * @see [BixolonPrinter.getTargetDevice]
     * @param callback { isSuccess: Boolean, error: String, isDeviceAvailable: Boolean }
     */
    @ReactMethod
    fun isDeviceAvailable(callback: Callback) {
        GlobalScope.launch(Dispatchers.IO) {
            val result = BixolonPrinter().isDeviceAvailable()
            val args = result.toRnArgs().apply {
                result.getOrNull()?.let { putBoolean("isDeviceAvailable", it) }
            }
            callback.invoke(args)
        }
    }

    /**
     * Manually connect to specified printer.
     *
     * Prequesties:
     * - Pair the device using Android Bluetooth settings.
     *
     * Always close down the connection before reconnecting to the device again.
     *
     * @param logicalName Bluetooth device name e.g. SPP-R410
     * @param address Bluetooth device address e.g. 74:F0:7D:E9:8C:B8
     * @param callback { isSuccess: Boolean, error: String }
     */
    @ReactMethod
    fun connect(logicalName: String, address: String, callback: Callback) {
        if (activePrinterSession != null) {
            callback(Result.failure<Unit>("Disconnect first!").toRnArgs())
            return
        }
        GlobalScope.launch(Dispatchers.IO) {
            val result = BixolonPrinter().open(
                    context = appContext,
                    receiver = null,
                    logicalName = logicalName,
                    address = address
            )
            activePrinterSession = result.getOrNull()
            callback(result.toRnArgs())
        }
    }

    /**
     * Auto-connect with compatible device.
     *
     * Prequesties:
     * - Pair the device using Android Bluetooth settings.
     *
     * Always close down the connection before reconnecting to the device again.
     *
     * @see [BixolonPrinter.getTargetDevice]
     * @param callback { isSuccess: Boolean, error: String }
     */
    @ReactMethod
    fun autoConnect(callback: Callback) {
        if (activePrinterSession != null) {
            callback(Result.failure<Unit>("Disconnect first!").toRnArgs())
            return
        }
        GlobalScope.launch(Dispatchers.IO) {
            val result = BixolonPrinter().autoOpen(
                    context = appContext,
                    receiver = null
            )
            activePrinterSession = result.getOrNull()
            callback.invoke(result.toRnArgs())
        }
    }

    /**
     * Prints the first page of the PDF file.
     *
     * @param pdfPath full path to the pdf file on the Android device.
     * @param brightness value from 0 to 100. Default is 50.
     * @param callback { isSuccess: Boolean, error: String }
     */
//    @ReactMethod
//    fun printPdf(pdfPath: String, brightness: Int, callback: Callback) {
//        val session = activePrinterSession
//        if (session == null) {
//            callback.invoke(Result.failure<Unit>("Not Connected to a Printer!").toRnArgs())
//        } else {
//            GlobalScope.launch {
//                val result = session.printPdf(
//                        filePath = pdfPath,
//                        // Only the first page will be printed, thus PDF file with more than one page
//                        // aren't supported.
//                        //
//                        // Native library doesn't expose a official way to print all pdf pages, but
//                        // it does provide a method with range params(fromPage, toPage). It could be
//                        // posible when giving starting page of 0 and end page of Int.MAX it would
//                        // print the whole document, but it's equalily posible that it will print
//                        // a few bilion pages.
//                        page = 0,
//                        alignment = Alignment.Left,
//                        brightness = brightness
//                )
//                callback.invoke(result.toRnArgs())
//            }
//        }
//    }

    /**
     * Close down the printer session.
     *
     * @param callback { isSuccess: Boolean, error: String }
     */
    @ReactMethod
    fun disconnect(callback: Callback) {
        val session = activePrinterSession
        if (session == null) {
            callback.invoke(Result.failure<Unit>("Not Connected to a Printer!").toRnArgs())
        } else {
            GlobalScope.launch {
                val result = session.close()
                activePrinterSession = null
                callback.invoke(result.toRnArgs())
            }
        }
    }

    private fun <T> Result<T>.toRnArgs(): WritableMap {
        return Arguments.createMap().apply {
            putBoolean("isSuccess", isSuccess)
            putString("error", exceptionOrNull()?.message)
        }
    }

    external fun nativeMultiply(a: Int, b: Int): Int
}

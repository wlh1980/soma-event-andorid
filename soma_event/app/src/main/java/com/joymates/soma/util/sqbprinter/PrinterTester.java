package com.joymates.soma.util.sqbprinter;

import android.content.Context;
import android.graphics.Bitmap;

import com.blankj.utilcode.util.LogUtils;
import com.pax.dal.IPrinter;
import com.pax.dal.entity.EFontTypeAscii;
import com.pax.dal.entity.EFontTypeExtCode;
import com.pax.dal.exceptions.PrinterDevException;

public class PrinterTester  {

    private static PrinterTester printerTester;
    private IPrinter printer;

    private PrinterTester(Context context) {
        printer = GetObj.getDal(context).getPrinter();
    }

    public static PrinterTester getInstance(Context context) {
        if (printerTester == null) {
            printerTester = new PrinterTester(context);
        }
        return printerTester;
    }

    public void init() {
        try {
            printer.init();
            LogUtils.e("init");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("init", e.toString());
        }
    }

    public String getStatus() {
        try {
            int status = printer.getStatus();
            LogUtils.e("getStatus");
            return statusCode2Str(status);
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("getStatus", e.toString());
            return "";
        }

    }

    public void fontSet(EFontTypeAscii asciiFontType, EFontTypeExtCode cFontType) {
        try {
            printer.fontSet(asciiFontType, cFontType);
            LogUtils.e("fontSet");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("fontSet", e.toString());
        }

    }

    public void spaceSet(byte wordSpace, byte lineSpace) {
        try {
            printer.spaceSet(wordSpace, lineSpace);
            LogUtils.e("spaceSet");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("spaceSet", e.toString());
        }
    }

    public void printStr(String str, String charset) {
        try {
            printer.printStr(str, charset);
            LogUtils.e("printStr");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("printStr", e.toString());
        }

    }

    public void step(int b) {
        try {
            printer.step(b);
            LogUtils.e("setStep");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("setStep", e.toString());
        }
    }

    public void printBitmap(Bitmap bitmap) {
        try {
            printer.printBitmap(bitmap);
            LogUtils.e("printBitmap");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("printBitmap", e.toString());
        }
    }

    public String start() {
        try {
            int res = printer.start();
            LogUtils.e("start");
            return statusCode2Str(res);
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("start", e.toString());
            return "";
        }

    }

    public void leftIndents(short indent) {
        try {
            printer.leftIndent(indent);
            LogUtils.e("leftIndent");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("leftIndent", e.toString());
        }
    }

    public int getDotLine() {
        try {
            int dotLine = printer.getDotLine();
            LogUtils.e("getDotLine");
            return dotLine;
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("getDotLine", e.toString());
            return -2;
        }
    }

    public void setGray(int level) {
        try {
            printer.setGray(level);
            LogUtils.e("setGray");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("setGray", e.toString());
        }

    }

    public void setDoubleWidth(boolean isAscDouble, boolean isLocalDouble) {
        try {
            printer.doubleWidth(isAscDouble, isLocalDouble);
            LogUtils.e("doubleWidth");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("doubleWidth", e.toString());
        }
    }

    public void setDoubleHeight(boolean isAscDouble, boolean isLocalDouble) {
        try {
            printer.doubleHeight(isAscDouble, isLocalDouble);
            LogUtils.e("doubleHeight");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("doubleHeight", e.toString());
        }

    }

    public void setInvert(boolean isInvert) {
        try {
            printer.invert(isInvert);
            LogUtils.e("setInvert");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("setInvert", e.toString());
        }

    }

    public String cutPaper(int mode) {
        try {
            printer.cutPaper(mode);
            LogUtils.e("cutPaper");
            return "cut paper successful";
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("cutPaper", e.toString());
            return e.toString();
        }
    }

    public String getCutMode() {
        String resultStr = "";
        try {
            int mode = printer.getCutMode();
            LogUtils.e("getCutMode");
            switch (mode) {
                case 0:
                    resultStr = "Only support full paper cut";
                    break;
                case 1:
                    resultStr = "Only support partial paper cutting ";
                    break;
                case 2:
                    resultStr = "support partial paper and full paper cutting ";
                    break;
                case -1:
                    resultStr = "No cutting knife,not support";
                    break;
                default:
                    break;
            }
            return resultStr;
        } catch (PrinterDevException e) {
            e.printStackTrace();
            LogUtils.e("getCutMode", e.toString());
            return e.toString();
        }
    }

    public String statusCode2Str(int status) {
        String res = "";
        switch (status) {
            case 0:
                res = "Success ";
                break;
            case 1:
                res = "Printer is busy ";
                break;
            case 2:
                res = "Out of paper ";
                break;
            case 3:
                res = "The format of print data packet error ";
                break;
            case 4:
                res = "Printer malfunctions ";
                break;
            case 8:
                res = "Printer over heats ";
                break;
            case 9:
                res = "Printer voltage is too low";
                break;
            case 240:
                res = "Printing is unfinished ";
                break;
            case 252:
                res = " The printer has not installed font library ";
                break;
            case 254:
                res = "Data package is too long ";
                break;
            default:
                break;
        }
        return res;
    }
}

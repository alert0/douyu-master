//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package name.yumao.douyu.swing

import okio.BufferedSink
import okio.Okio
import org.apache.log4j.Logger

import java.io.File
import java.util.Calendar
import java.util.Date
import java.util.Random
import java.util.TimeZone

class ToolSub2 @Throws(Exception::class)

constructor(filePath: String) {
    private val initTime: Date
    private val file: File
    // private BufferedWriter bufferedWriter;

    private lateinit var sink: BufferedSink  //=  Okio.buffer(Okio.appendingSink(file) );

    private  val random: Random

    init {

        logger.info("Sub:初始化字幕转储进程")
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"))
        this.initTime = calendar.time

        this.file = File(filePath)

        sink = Okio.buffer(Okio.appendingSink(file))
        //this.file.getParentFile().mkdirs();
        // this.bufferedWriter = new BufferedWriter(new FileWriter(this.file));

        this.random = Random()

        sink.writeUtf8("[Script Info]")

        sink.writeUtf8("\r\n")
        sink.writeUtf8("Title:DouyuAssiatantSub")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("Original Script:DouyuAssiatantV3.x")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("Synch Point:0")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("ScriptType:v4.00")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("Collisions:Normal")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("PlayResX:1280")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("PlayResY:720")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("Timer:100.0000")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("[V4+ Styles]")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("Format: Name, Fontname, Fontsize, PrimaryColour, SecondaryColour, OutlineColour, BackColour, Bold, Italic, Underline, StrikeOut, ScaleX, ScaleY, Spacing, Angle, BorderStyle, Outline, Shadow, Alignment, MarginL, MarginR, MarginV, Encoding")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("Style: Default,微软雅黑,25,&H00FFFFFF,&H00000000,&H00000000,&H00000000,-1,0,0,0,100,100,0,0.00,1,1,0,2,30,30,10,134")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("[Events]")
        sink.writeUtf8("\r\n")
        sink.writeUtf8("Format: Layer, Start, End, Style, Actor, MarginL, MarginR, MarginV, Effect, Text")
        sink.flush()
    }

    @Throws(Exception::class)
    fun addSubString(str: String) {
        var str = str
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"))
        var startTime = java.lang.Long.valueOf(calendar.time.time - this.initTime.time)
        startTime = java.lang.Long.valueOf(startTime.toLong() + 0L)
        val endTime = java.lang.Long.valueOf(startTime.toLong() + 10000L)
        val randomNum = this.random.nextInt(720).toString()
        val startDate = String.format("%02d:%02d:%02d.%02d", *arrayOf<Any>(java.lang.Long.valueOf(startTime.toLong() % 86400000L / 3600000L), java.lang.Long.valueOf(startTime.toLong() % 3600000L / 60000L), java.lang.Long.valueOf(startTime.toLong() % 60000L / 1000L), java.lang.Long.valueOf(startTime.toLong() / 10L % 100L)))
        val endDate = String.format("%02d:%02d:%02d.%02d", *arrayOf<Any>(java.lang.Long.valueOf(endTime.toLong() % 86400000L / 3600000L), java.lang.Long.valueOf(endTime.toLong() % 3600000L / 60000L), java.lang.Long.valueOf(endTime.toLong() % 60000L / 1000L), java.lang.Long.valueOf(endTime.toLong() / 10L % 100L)))
        if (str.startsWith("=")) {
            str = " " + str
        }

        sink.writeUtf8("\r\n")
        sink.writeUtf8("Dialogue: 0,$startDate,$endDate,*Default,NTP,0000,0000,0000,,{\\move(1280,$randomNum,0,$randomNum)}$str")
        sink.flush()
    }

    @Throws(Exception::class)
    fun close() {

            sink.flush()
            sink.close()
           // sink = null


        // logger.info("*******************************" + this.bufferedWriter);
    }

    companion object {
        private val logger = Logger.getLogger(ToolSub2::class.java)
    }
}

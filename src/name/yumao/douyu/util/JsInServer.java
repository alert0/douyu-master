package name.yumao.douyu.util;
import com.tznin.http.HttpClientFromDouyu;



import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class JsInServer {
	static Invocable inv = null;

     public static String jsrun( int vid, String did, String tt) {
		try {

			if (inv != null)
				return inv.invokeFunction("ub98484234", vid,did,tt).toString();
			ScriptEngineManager manager = new ScriptEngineManager();

            ScriptEngine engine = manager.getEngineByName("nashorn");
//            Path path = Paths.get("conf","m.js");
//            Reader scriptReader = new InputStreamReader(new FileInputStream(path.toFile() ));
//
			//System.out.println(scriptReader );
			String src =  HttpClientFromDouyu.Companion.getHomeH5Enc(vid) ;
			engine.eval(HttpClientFromDouyu.Companion.getJs() );
			engine.eval(src);


//			js_ctx = JSEngine(js_md5)
//			js_ctx.eval(js_enc)
//			did = uuid.uuid4().hex
//			tt = str(int(time.time()))
//			ub98484234 = js_ctx.call('ub98484234', self.vid, did, tt)
			//
			// expose object defined in the script to the Java application
			// Object obj = engine.get("obj");

			// create an Invocable object by casting the script engine object
			inv = (Invocable) engine;

			// invoke the method named "hello" on the object defined in the
			// script
			// with "Script Method!" as the argument
			// System.out.println(invocable.invokeFunction(“sum”,1,3));

			Object d = inv.invokeFunction("ub98484234", vid,did, tt);
				
			return d.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}

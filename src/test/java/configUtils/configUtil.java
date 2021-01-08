package configUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class configUtil {

    public static String formataData(Date data, String formato){
        SimpleDateFormat dt = new SimpleDateFormat(formato);
        return dt.format(data);
    }

    public static void aguardar(final int millisegundos){
        try{
            Thread.sleep(millisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

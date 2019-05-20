import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class SaveLoadCache {
    public static void saveCache(String path,String json)
    {
        try(FileOutputStream fos=new FileOutputStream(path))
        {
            byte[] buffer = json.getBytes();
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("Saved!");
    }

    public static String loadCache(String path){
        String str = "";
        try
        {
            File file = new File(path);
            if(file.exists()) {
                str = new String(Files.readAllBytes(Paths.get(path)));
            }
            else throw null;
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("Loaded!");
        return str;
    }

    public static void LoadSaveSettingsConfig(SettingsConfig obj, String path, boolean SaveOrLoad)
    {
        Gson gson = new Gson();
        if(SaveOrLoad) {
            String json = new Gson().toJson(obj);
            saveCache(path,json);
        }
        else
        {
            String json = loadCache(path);
            obj = gson.fromJson(json,SettingsConfig.class);
        }
    }

}

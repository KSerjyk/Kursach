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

    public static String loadCache(String path) throws IOException {
        String str = "";
        File file = new File(path);
        if(file.exists()) {
            str = new String(Files.readAllBytes(Paths.get(path)));
        }
        else throw null;
        System.out.println("Loaded!");
        return str;
    }
}

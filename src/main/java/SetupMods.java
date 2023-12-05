import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class SetupMods {
    public static final String steam_location = "D:\\SteamLibrary";//"C:\\Program Files (x86)\\Steam";

    public static void main(String... args) throws IOException {
        File modsStream = new File(steam_location + "\\steamapps\\workshop\\content\\211820");
        File modsFolderInstall = new File(steam_location + "\\steamapps\\common\\Starbound\\mods");
        for (File file : modsStream.listFiles()) {
            if(!file.isDirectory()) continue;

            for (File listFile : file.listFiles()) {
                if(!"contents.pak".equals(listFile.getName())) continue;

                File destination = new File(modsFolderInstall, file.getName() + ".pak");

                //if(destination.exists()) continue;

                Files.copy(listFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}

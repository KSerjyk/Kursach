package Controllers;

public class SettingsConfig {

    private static SettingsConfig INSTANCE;

    private boolean saveCache;
    private boolean showTime;
    private String path = "Cahche\\";

    private SettingsConfig(){
        INSTANCE = this;
    }

    public static SettingsConfig getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SettingsConfig();

        return INSTANCE;
    }

    public boolean isSaveCache() {
        return saveCache;
    }

    public void setSaveCache(boolean saveCache) {
        this.saveCache = saveCache;
    }

    public boolean isShowTime() {
        return showTime;
    }

    public void setShowTime(boolean showTime) {
        this.showTime = showTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "SettingsConfig{" +
                "saveCache=" + saveCache +
                ", showTime=" + showTime +
                ", path='" + path + '\'' +
                '}';
    }
}

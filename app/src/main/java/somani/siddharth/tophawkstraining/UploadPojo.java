package somani.siddharth.tophawkstraining;
import com.google.firebase.database.IgnoreExtraProperties;
@IgnoreExtraProperties
public class UploadPojo{

    public String name;
    public String url;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public UploadPojo() {
    }

    public UploadPojo(String name, String url) {
        this.name = name;
        this.url= url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
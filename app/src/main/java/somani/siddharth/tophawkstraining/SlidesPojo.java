package somani.siddharth.tophawkstraining;
import com.google.firebase.database.IgnoreExtraProperties;
@IgnoreExtraProperties
public class SlidesPojo{

    public String heading;
    public String url;
    public String info;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public SlidesPojo() {
    }

    public SlidesPojo(String heading, String url,String info) {
        this.heading = heading;
        this.url= url;
        this.info=info;
    }

    public String getHeading() {
        return heading;
    }
    public String getUrl() {
        return url;
    }
    public String getInfo(){return info;}
}
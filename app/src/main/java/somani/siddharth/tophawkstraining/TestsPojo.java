package somani.siddharth.tophawkstraining;



public class TestsPojo {

    public String heading;
    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public TestsPojo() {
    }

    public TestsPojo(String heading) {
        this.heading = heading;

    }

    public String getHeading() {
        return heading;
    }

}
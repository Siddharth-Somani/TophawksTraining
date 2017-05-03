package somani.siddharth.tophawkstraining;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.firebase.client.ChildEventListener;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class TestWeb2 extends AppCompatActivity {
    public static Firebase mDatabase1,mDatabase2;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view2);
        final WebView myWebView = (WebView) findViewById(R.id.myWebView);
        Bundle bundle=getIntent().getExtras();
        url=bundle.getString("url");
                myWebView.loadUrl(url);
                myWebView.setWebViewClient(new MyWebViewClient());
                WebSettings webSettings = myWebView.getSettings();
                webSettings.setJavaScriptEnabled(true);

    }
    private class MyWebViewClient extends WebViewClient {

        @Override

        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            startActivity(intent);

            return true;
        }
    }}

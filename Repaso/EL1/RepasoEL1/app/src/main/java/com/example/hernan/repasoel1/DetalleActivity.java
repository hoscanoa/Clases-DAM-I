package com.example.hernan.repasoel1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class DetalleActivity extends ActionBarActivity {

    String urlTvs[]={"http://www.falabella.com.pe/falabella-pe/product/13917000/LED-32%22-32LB561B?navAction=push","http://www.falabella.com.pe/falabella-pe/product/13951268/LED-42%22--42LB7000?navAction=push","http://www.falabella.com.pe/falabella-pe/product/14067374/LED-42%22-L42Q530AKS?navAction=push","http://www.falabella.com.pe/falabella-pe/product/14006853/Monitor-LED-TV-23,6%22-LT24D310LB?navAction=push"};
    String urlAds[]={"http://www.falabella.com.pe/falabella-pe/product/13032184/Audifono-Vincha--MDR-ZX100B-Tipo-Diadema?navAction=push","http://www.falabella.com.pe/falabella-pe/product/13607906/Audifonos-Supraurales-SHP1900-Negro?navAction=push","http://www.falabella.com.pe/falabella-pe/product/13948480/Mini-MX-H630-230-W-RMS?navAction=push"};

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        webView = (WebView)findViewById(R.id.webView);

        int categoria=getIntent().getExtras().getInt("categoria");
        int producto=getIntent().getExtras().getInt("producto");

        switch (categoria)
        {
            case 0:
                webView.loadUrl(urlTvs[producto]);
                break;
            default:
                webView.loadUrl(urlAds[producto]);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

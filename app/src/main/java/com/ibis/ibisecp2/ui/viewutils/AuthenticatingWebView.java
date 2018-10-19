package com.ibis.ibisecp2.ui.viewutils;

/*******************************************************************************
 * Copyright (c) 2014 OCLC Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 *
 ******************************************************************************/

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.model.EsiaTokenMarker;

import java.util.HashMap;

/**
 * Extends a generic webView to execute an Oauth2 authentication. Returns a token and its associated parameters for use
 * in calling OCLC web services.
 *
 * @see WebView
 */
public class AuthenticatingWebView {

    /**
     * Parameters returned by a successful authentication.
     */
    private final HashMap<String, String> authorizationReturnParameters = new HashMap<String, String>();

    /**
     * Browser Window that hosts the authentication process.
     */
    private final WebView webView;

    /**
     * Listener for callbacks from webView.
     */
    private final AuthenticatingWebViewCallbackMethods listener;

    /**
     * Stores the webview and call back listener into class instance variables for later use.
     *
     * @param webView the WebView that is handling the authentication interaction with the user.
     * @param listener handle to the callback methods to StartActivity.java.
     */
    public AuthenticatingWebView(final WebView webView, final AuthenticatingWebViewCallbackMethods listener) {
        this.webView = webView;
        this.listener = listener;
    }

    /**
     * Sets up the WebView to make a a HTTP GET to the OCLC Authentication server to retrieve an access token.
     * <p>
     * The request URL is of this form:
     * <p>
     * {baseURL}/authorizeCode?client_id={wskey client ID}&authenticatingInstitutionId={Inst ID}
     * &contextInstitutionId={Inst ID}&redirect_uri={redirect Url}&response_type={token} &scope={scope_1 scope_2 ...}
     *
     * @param requestUrl the request URL that initiates the token request
     */
    @SuppressLint("SetJavaScriptEnabled")
    public final void makeRequest(final String requestUrl) {

        /*
         * Clear the webView, in case it is showing a previous authentication error. Make the webView visible, in case
         * the last attempt succeeded and it is hidden.
         */
        webView.loadUrl("about:blank");
        webView.setVisibility(View.VISIBLE);

        CookieManager cookieManager = CookieManager.getInstance();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            cookieManager.removeAllCookies(null);
        else
            cookieManager.removeAllCookie();

        /*
         * Enable javascript in the WebView (off by default). The annotation
         */
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        /*
         * Set the callback function for the webview. Inspect the URL before loading to detect successful or failed
         * loads.
         */
        webView.setWebViewClient(new MyCustomWebViewClient());

        /*
         * Execute the token request
         */
        webView.loadUrl(requestUrl);
    }

    /**
     * Handles callbacks from the webView.
     */
    private class MyCustomWebViewClient extends WebViewClient {

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            if(error.getPrimaryError() == SslError.SSL_UNTRUSTED )
                handler.proceed();
            else {
                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage(R.string.notification_error_ssl_cert_invalid);
                builder.setPositiveButton("продолжить", (dialog, which) -> handler.proceed());
                builder.setNegativeButton("отменить", (dialog, which) -> handler.cancel());
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        }

        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {

            String cookiesString = CookieManager.getInstance().getCookie(url);
            if(cookiesString != null && !cookiesString.isEmpty()){
                String[] cookies = cookiesString.split(";");
                for (String cookie : cookies){
                    String[] parts = cookie.split("=",2);
                    if(parts.length == 2 && parts[0].replaceAll("\\s","").equalsIgnoreCase("esiaapp")){
                        listener.displayResults(EsiaTokenMarker.parse(parts[1]));
                        view.loadUrl("about:blank");
                        webView.setVisibility(View.INVISIBLE);
                        return true;
                    }
                }
            }

            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(final WebView view, final String url, final Bitmap favicon) {
            listener.startProgressDialog();
        }

        @Override
        public void onPageFinished(final WebView view, final String url) {
            listener.stopProgressDialog();
            view.scrollTo(0,0);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asyncreq;
import java.util.concurrent.Future;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.apache.http.protocol.HttpContext;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.http.client.fluent.Async;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.concurrent.FutureCallback;
/**
 *
 * @author tiniv_000
 */
public class MainApp {
//    	public static void main(String[] args) throws InterruptedException, ExecutionException {
//	  try {
// 
//		CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();
//		HttpGet getRequest = new HttpGet(
//			"http://localhost:8080/RESTfulExample/json/product/get");
//		getRequest.addHeader("accept", "application/json");
// 
//		Future<HttpResponse> future = httpClient.execute(getRequest,null);
//                HttpResponse response = future.get();
//		if (response.getStatusLine().getStatusCode() != 200) {
//			throw new RuntimeException("Failed : HTTP error code : "
//			   + response.getStatusLine().getStatusCode());
//		}
// 
//		BufferedReader br = new BufferedReader(
//                         new InputStreamReader((response.getEntity().getContent())));
// 
//		String output;
//		System.out.println("Output from Server .... \n");
//		while ((output = br.readLine()) != null) {
//			System.out.println(output);
//		}
// 
//		httpClient.close();
// 
//	  } catch (ClientProtocolException e) {
// 
//		e.printStackTrace();
// 
//	  } catch (IOException e) {
// 
//		e.printStackTrace();
//	  }
// 
//	}
  
    public static void main(String[ ] args) 
            throws InterruptedException, ExecutionException, IOException
    {
      URIBuilder builder = new URIBuilder();
builder.setScheme("http").setHost("comtrade.un.org").setPath("/api/get")
    .setParameter("max","50000")
        .setParameter("type","C")
        .setParameter("freq","M")
        .setParameter("px","HS")
        .setParameter("ps","2014")
        .setParameter("r","804")
        .setParameter("p","112")
        .setParameter("rg","All")
        .setParameter("cc","All")
        .setParameter("fmt","json");
URI requestURL = null;
try {
    requestURL = builder.build();
} catch (URISyntaxException use) {}

ExecutorService threadpool = Executors.newFixedThreadPool(2);
Async async = Async.newInstance().use(threadpool);
final Request request = Request.Get(requestURL);

try{
    Future<Content> future = async.execute(request, new FutureCallback<Content>() {
    @Override
    public void failed (final Exception e) {
        System.out.println(e.getMessage() +": "+ request);
    }
    @Override
    public void completed (final Content content) {
        System.out.println("Request completed: "+ request);
        System.out.println("Response:\n"+ content.asString());
    }

    @Override
    public void cancelled () {}
});
    }
catch(Exception e)
{System.out.println("Job threw exception: " + e.getCause());}

    }
}

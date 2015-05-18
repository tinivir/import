/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asyncreq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.Future;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.protocol.HttpContext;
import org.hamcrest.MatcherAssert;

/**
 *
 * @author tiniv_000
 */
class GetThread extends Thread {
    private CloseableHttpAsyncClient client;
    private HttpContext context;
    private HttpGet request;
 
    public GetThread(CloseableHttpAsyncClient client,HttpGet req){
        this.client = client;
        context = HttpClientContext.create();
        this.request = req;
    }
 
    @Override
    public void run() {
        try {
            Future<HttpResponse> future = client.execute(request, context, null);
            HttpResponse response = future.get();
            MatcherAssert.assertThat(response.getStatusLine().getReasonPhrase(), equals(200));
            Boolean isDone = true;
            Scanner scan = new Scanner(System.in);
            File f = new File("my.txt");
            FileWriter fr = new FileWriter(f);
            BufferedWriter bwr  = new BufferedWriter(fr);
            BufferedReader br = new BufferedReader(
                         new InputStreamReader((response.getEntity().getContent())));
            while ((br.readLine())!=null) {

             bwr.write(new Scanner(System.in).nextLine());

             
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
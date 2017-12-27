package code;

import org.apache.http.impl.client.HttpClientBuilder;
import sun.net.www.http.HttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shafi on 7/14/2017.
 */
public class HTTPHANDLE {

    private String url;
    private String student_id;
    private String semester_id;

    public HTTPHANDLE(String url){
        this.url = url;
    }

    public  HTTPHANDLE(String url, String student_id){
        this.url = url;
        this.student_id = student_id;
    }

    public HTTPHANDLE(String url, String student_id, String semester_id){
        this.url = url;
        this.student_id = student_id;
        this.semester_id = semester_id;
    }

    public String sendGet(String url) throws  Exception{
        org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    public String sendPost() throws  Exception{
        org.apache.http.client.HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("STUDENT_ID", student_id));
        urlParameters.add(new BasicNameValuePair("SELESTER_ID", semester_id));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line + "'\r\n");
        }

        String resultString = result.toString();
        System.out.println ("Gotten datasize = " + resultString.length());
        return result.toString();
    }



    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(String semester_id) {
        this.semester_id = semester_id;
    }
}

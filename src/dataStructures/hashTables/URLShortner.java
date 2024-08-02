package dataStructures.hashTables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/*
 * URL Shortner
You have a URL-shortening service that registered users can use to create custom short links for any website. 
The service can also be used through an API which has the following requirements:
There is a rate limit of 5 seconds for every user, i.e, the user must wait for at least 5 seconds after using the service before using it again.
The URL provided must begin with either http:// or https://.
The custom key chosen must be between 2 and 12 characters long (inclusive), and consist of alphabets and numbers only.
The custom key should not be taken already (the custom key must be unique).
If all the conditions are met, then the custom key is added to the database and it redirects to the given website. 
The database is empty before the first query and after that, the custom keys of successful queries are added to the database one by one.
You will be given a list of queries made to the API in chronological order. 
Determine whether each query is successful. Each query will contain the following:

time: The epoch time at which the query was made.
URL: The URL of the original website.
key: The custom key.
userId: An integer that identifies the particular user who made the query.

Task
You are given N queries. If a query is successful, print "YES" else print "NO".

Sample Input
4
1000000000 https://www.google.com ggl 25
1000000004 https://www.youtube.com yt 26
1000000004 https://HackerEarth.com he 50 
1000000005 https://www.facebook.com F!B 25

Sample Output
YES
YES
YES
NO

Explanation
All the first queries are successful so we print "YES", except for the last query. 
The last query contains a special character in the key (F!B) itself so it's invalid that's why the answer will be "NO" for the last one.
 */

public class URLShortner {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[][] Query = new String[N][4];
         for(int i_Query = 0; i_Query < N; i_Query++)
         {
         	String[] arr_Query = br.readLine().split(" ");
         	for(int j_Query = 0; j_Query < 4; j_Query++)
         	{
         		Query[i_Query][j_Query] = arr_Query[j_Query];
         	}
         }

         String[] out_ = solve(N, Query);
         for (int i_out_ = 0; i_out_ < out_.length; i_out_++)
         {
         	System.out.println(out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static String[] solve(int N, String[][] Query){
        String[] result = new String[N];
        HashMap<String, String> userTimeMap = new HashMap<>();
        HashMap<String, String> userKeyMap = new HashMap<>();
        
        for (int i=0; i<N; i++) {
        	String[] query = Query[i];
        	String time = query[0];
        	String url = query[1];
        	String key = query[2];
        	String userId = query[3];
        	
        	// Check url length
        	if (url.length() < 1 || url.length() > 100) {
        		result[i] = "NO";
        		continue;
        	}
        	
        	// Check URL
        	if (!(url.startsWith("http://") || url.startsWith("https://"))) {
        		result[i] = "NO";
        		System.out.println("url - NO");
        		continue;
        	}
        	
        	// Check time length
        	if (time.length() < 1 || time.length() > 10) {
        		result[i] = "NO";
        		continue;
        	}
        	
        	// Check Time between queries
        	if (userTimeMap.containsKey(userId) && (Long.parseLong(time) - Long.parseLong(userTimeMap.get(userId))) < 5) {
        		result[i] = "NO";
        		System.out.println("time - NO");
        		continue;
        	} else {
        		userTimeMap.put(userId, time);
        	}
        	
        	// Check key length
        	if (key.length() < 2 || key.length() > 12) {
        		result[i] = "NO";
        		continue;
        	}
        	
        	// Check for unique key
        	if (userKeyMap.containsKey(key)) {
        		result[i] = "NO";
        		continue;
        	} else {
        		userKeyMap.put(key, url);
        	}
        	
        	// Check key
        	for (int j=0; j<key.length(); j++) {
        		char ch = key.charAt(j);
        		if (!((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90) || (ch >= 48 && ch <= 57))) {
        			result[i] = "NO";
        			System.out.println(i + " " + (int) ch  + " key - NO");
            		break;
        		}
        	}
        	
        	// Check userId length
        	if (userId.length() < 1 || userId.length() > 10) {
        		result[i] = "NO";
        		continue;
        	}
        	
        	// check userId
        	for (int j=0; j<userId.length(); j++) {
        		char ch = userId.charAt(j);
        		if (!(ch >= 48 && ch <= 57)) {
        			result[i] = "NO";
            		break;
        		}
        	}
        	
        	result[i] = (result[i] == "NO") ? result[i] : "YES";
        }
        System.out.println(userTimeMap);
        return result;
    
    }

}

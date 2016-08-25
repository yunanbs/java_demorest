
package yn.demorest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("text/plain")
    @Path("/getit")
    public String getIt() {
        return "Hi there!";
    }
    
    @POST  
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
    @Path("/createuser")
    public JSONObject newUser(JSONObject userinfo) {
    	 System.out.println(userinfo.toString());
    	 JSONObject result = new JSONObject();
    	 try {
			result.put("id", 0);
			result.put("name", userinfo.get("username"));
	    	result.put("age", userinfo.get("userage"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
      return result;
    }
    
}

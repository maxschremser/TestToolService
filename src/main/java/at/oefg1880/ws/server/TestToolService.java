package at.oefg1880.ws.server;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by IntelliJ IDEA.
 * User: AT003053
 * Date: 11.07.12
 * Time: 11:28
 * To change this template use File | Settings | File Templates.
 */
@WebService()
public class TestToolService {
  @WebMethod
  public String getFragebogen(String fragebogen) {
    String result = "Hello, world, fragebogen " + fragebogen;
    System.out.println(result);
    return result;
  }

}
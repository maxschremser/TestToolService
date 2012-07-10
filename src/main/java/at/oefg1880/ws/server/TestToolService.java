package at.oefg1880.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by IntelliJ IDEA.
 * User: AT003053
 * Date: 10/07/12
 * Time: 08:09
 * To change this template use File | Settings | File Templates.
 */
@WebService()
public class TestToolService {
  @WebMethod
  public String getFragebogen(String fragebogen) {
    String result = "Hello, world, from " + fragebogen;
    System.out.println(result);
    return result;
  }
}
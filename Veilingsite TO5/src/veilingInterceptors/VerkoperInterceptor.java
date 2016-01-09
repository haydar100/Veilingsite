package veilingInterceptors;

import java.util.Map;

import veilingAware.UserAware;
import veilingDomain.Gebruiker;
import veilingDomain.Recht.TYPE;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class VerkoperInterceptor implements Interceptor {

 public void destroy() {
 }

 public void init() {
 }

 public String intercept( ActionInvocation actionInvocation ) throws Exception {
  System.out.println("verkoper interceptor init....");
  @SuppressWarnings("rawtypes")
  Map session = actionInvocation.getInvocationContext().getSession();
  
  Gebruiker user = (Gebruiker) session.get("loggedUser");
  
  if (user == null) {
      return Action.LOGIN;
  } 
  else {
   if (user.getRecht() == TYPE.verkoper) {
    Action action = ( Action ) actionInvocation.getAction();
       
       if (action instanceof UserAware) {
           ((UserAware)action).setUser(user);
       }
   }
   else {
    System.out.println("Gebruiker geen verkoper !");
    return Action.LOGIN;
   }
   
      
      
      return actionInvocation.invoke();
  }
 }
}
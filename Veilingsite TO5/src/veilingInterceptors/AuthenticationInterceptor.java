package veilingInterceptors;

import java.util.Map;

import veilingAware.UserAware;
import veilingDomain.Gebruiker;
import veilingDomain.Recht.TYPE;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class AuthenticationInterceptor implements Interceptor {

 public void destroy() {
 }

 public void init() {
  
 }

 public String intercept(ActionInvocation actionInvocation) throws Exception {
  System.out.println("Interceptor line 1");
  @SuppressWarnings("rawtypes")
  Map session = actionInvocation.getInvocationContext().getSession();

  Gebruiker gebruiker = (Gebruiker) session.get("loggedUser");
 
  System.out.println(gebruiker);

  if (gebruiker == null) {
   System.out.println("Gebruiker niet ingelogd");
   return Action.LOGIN;
   
  } else {
   if (gebruiker.getRecht() != TYPE.admin) {
    System.out.println("Gebruiker is geen admin");
   }
   /*Action action = (Action) actionInvocation.getAction();

   if (action instanceof UserAware) {
    ((UserAware) action).setUser(gebruiker);
    System.out.println(gebruiker);
    System.out.println("userAware set");
   }*/
   System.out.println("invoke it");
   return actionInvocation.invoke();
  }
 }
}
// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package rmi.iWeather.server;

public final class RemoteWeatherImpl_Stub
    extends java.rmi.server.RemoteStub
    implements rmi.iWeather.common.RemoteWeather, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_getWeather_0;
    private static java.lang.reflect.Method $method_sayHi_1;
    
    static {
	try {
	    $method_getWeather_0 = rmi.iWeather.common.RemoteWeather.class.getMethod("getWeather", new java.lang.Class[] {java.lang.String.class});
	    $method_sayHi_1 = rmi.iWeather.common.RemoteWeather.class.getMethod("sayHi", new java.lang.Class[] {java.lang.String.class});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public RemoteWeatherImpl_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of getWeather(String)
    public java.lang.String getWeather(java.lang.String $param_String_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getWeather_0, new java.lang.Object[] {$param_String_1}, -3085976825856872198L);
	    return ((java.lang.String) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of sayHi(String)
    public java.lang.String sayHi(java.lang.String $param_String_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_sayHi_1, new java.lang.Object[] {$param_String_1}, 7048859751209179378L);
	    return ((java.lang.String) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}

package org.apache.commons.logging;

@Deprecated
public interface Log {
  void debug(Object paramObject);
  
  void debug(Object paramObject, Throwable paramThrowable);
  
  void error(Object paramObject);
  
  void error(Object paramObject, Throwable paramThrowable);
  
  void fatal(Object paramObject);
  
  void fatal(Object paramObject, Throwable paramThrowable);
  
  void info(Object paramObject);
  
  void info(Object paramObject, Throwable paramThrowable);
  
  boolean isDebugEnabled();
  
  boolean isErrorEnabled();
  
  boolean isFatalEnabled();
  
  boolean isInfoEnabled();
  
  boolean isTraceEnabled();
  
  boolean isWarnEnabled();
  
  void trace(Object paramObject);
  
  void trace(Object paramObject, Throwable paramThrowable);
  
  void warn(Object paramObject);
  
  void warn(Object paramObject, Throwable paramThrowable);
}


/* Location:              D:\wlzc_institute\wlzc\wlzc1-dex2jar.jar!\org\apache\commons\logging\Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
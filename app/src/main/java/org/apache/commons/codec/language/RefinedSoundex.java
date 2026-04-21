package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

@Deprecated
public class RefinedSoundex implements StringEncoder {
  public static final RefinedSoundex US_ENGLISH;
  
  public static final char[] US_ENGLISH_MAPPING = null;
  
  static {
    US_ENGLISH = null;
  }
  
  public RefinedSoundex() {
    throw new RuntimeException("Stub!");
  }
  
  public RefinedSoundex(char[] paramArrayOfchar) {
    throw new RuntimeException("Stub!");
  }
  
  public int difference(String paramString1, String paramString2) throws EncoderException {
    throw new RuntimeException("Stub!");
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    throw new RuntimeException("Stub!");
  }
  
  public String encode(String paramString) {
    throw new RuntimeException("Stub!");
  }
  
  public String soundex(String paramString) {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\wlzc_institute\wlzc\wlzc1-dex2jar.jar!\org\apache\commons\codec\language\RefinedSoundex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
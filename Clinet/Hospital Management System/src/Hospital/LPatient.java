package Hospital;

import java.io.Serializable;

class LPatient implements Serializable {
   String userName;
   String passWord;
  LPatient(String userName, String passWord)
  {
      this.userName=userName;
      this.passWord=passWord;
  }

  public String getUserName() {
      return userName;
  }

  public String getPassWord() {
      return passWord;
  }
}

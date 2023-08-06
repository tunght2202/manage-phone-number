package model;

import java.util.*;
import java.sql.*;

public class ContactDAO extends MyDAO {

    public List<User> getListUser() {
        List<User> list = new ArrayList<>();
        xSql = "select * from Login l Left join Users u on l.IdLogin = u.IdLogin";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xloginName, xNameUser,xphoneNumber,xImg; int xRole,xIdLogin, xIdUser;
            while (rs.next()) {
                xloginName=rs.getString("LoginName");
                xNameUser=rs.getString("NameUser");
                xphoneNumber=rs.getString("PhoneNumberUser");
                xImg=rs.getString("ImgUser");
                xRole=rs.getInt("Role");
                xIdLogin = rs.getInt("IdLogin");
                xIdUser = rs.getInt("IdUser");
                User u = new User(xloginName, xNameUser, xphoneNumber, xImg, xIdUser, xIdLogin, xRole);
                list.add(u);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Contact> getContacts(int xidLogin) {
        List<Contact> list = new ArrayList<>();
        xSql = "select * from Contacts where IdLogin = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xidLogin);
            rs = ps.executeQuery();
            String xNameContact, xPhoneNumberContact;
            int xIdContacts, xIdLogin;
            Contact x;
            while (rs.next()) {
                xNameContact = rs.getString("NameContact");
                xPhoneNumberContact = rs.getString("PhoneNumberContact");
                xIdContacts = rs.getInt("IdContacts");
                xIdLogin = rs.getInt("IdLogin");
                x = new Contact(xNameContact, xPhoneNumberContact, xIdContacts, xIdLogin);
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Contact> getContacts(String name, int xidLogin) {
        List<Contact> list = new ArrayList<>();
        xSql = "select * from Contacts where NameContact like '%" + name + "%' and IdLogin = " + xidLogin + ";";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xNameContact, xPhoneNumberContact;
            int xIdContacts, xIdLogin;
            Contact x;
            while (rs.next()) {
                xNameContact = rs.getString("NameContact");
                xPhoneNumberContact = rs.getString("PhoneNumberContact");
                xIdContacts = rs.getInt("IdContacts");
                xIdLogin = rs.getInt("IdLogin");
                x = new Contact(xNameContact, xPhoneNumberContact, xIdContacts, xIdLogin);
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return list;
    }

    public int checkNameAccount(String xNameAccount, String xPassword) {
        xSql = "select * from Login where LoginName = ?";
        int kq;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xNameAccount);
            rs = ps.executeQuery();
            int count = 0;
            if (rs.next()) {
                count++;
            }

            if (count > 0) {
                if (xPassword.equals(rs.getString("LoginPassword"))) {
                    kq = 1;
                    return kq;
                } else {
                    kq = 3;
                    return kq;
                }
            } else {
                kq = 2;
                return kq;
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public User getUser(String xNameAccount) {
        xSql = "select * from Login l Left join Users u on l.IdLogin = u.IdLogin where l.LoginName = ? order by l.IdLogin";
        User u = new User();
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xNameAccount);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setNameUser(rs.getString("NameUser"));
                u.setPhoneNumberUser(rs.getString("PhoneNumberUser"));
                u.setImgUser(rs.getString("ImgUser"));
                u.setIdLogin(rs.getInt("IdLogin"));
                u.setIdUser(rs.getInt("IdUser"));
                u.setRole(rs.getInt("Role"));
            }
        } catch (SQLException e) {
        }
        return u;
    }
    public User getUser(int idUser) {
        xSql = "select * from Login l Left join Users u on l.IdLogin = u.IdLogin where u.IdUser = ? order by l.IdLogin;";
        User u = new User();
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setNameUser(rs.getString("NameUser"));
                u.setPhoneNumberUser(rs.getString("PhoneNumberUser"));
                u.setImgUser(rs.getString("ImgUser"));
                u.setIdLogin(rs.getInt("IdLogin"));
                u.setIdUser(rs.getInt("IdUser"));
                u.setRole(rs.getInt("Role"));
            }
        } catch (SQLException e) {
        }
        return u;
    }

    public User getUserByPhone(String phoneNumber) {
        xSql = "select * from Users where PhoneNumberUser = ?;";
        User u = new User();
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, phoneNumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setNameUser(rs.getString("NameUser"));
                u.setPhoneNumberUser(rs.getString("PhoneNumberUser"));
                u.setImgUser(rs.getString("ImgUser"));
            }
        } catch (SQLException e) {
        }
        return u;
    }

    public LoginAccount getLoginAccount(String xNameAccount) {
        xSql = "select * from Login l where l.LoginName = ?";
        LoginAccount la = new LoginAccount();
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xNameAccount);
            rs = ps.executeQuery();
            while (rs.next()) {
                la.setIdLogin(rs.getInt("IdLogin"));
                la.setLoginName(rs.getString("LoginName"));
                la.setLoginPassword(rs.getString("LoginPassword"));
            }
        } catch (SQLException e) {
        }
        return la;
    }

    public void insertAccount(String xNameAccountSigUp, String xPasswordSigUp) {
        ContactDAO c = new ContactDAO();
        xSql = "insert into Login (IdLogin,LoginName,LoginPassword) values (?,?,?);";
        int xIdLogin;
        xIdLogin = c.getMaxIdLogin() + 1;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xIdLogin);
            ps.setString(2, xNameAccountSigUp);
            ps.setString(3, xPasswordSigUp);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
        }

    }

    public void insertUser(int xIdLogin, int xIdUser, User u) {
        xSql = "insert into Users (IdUser,NameUser,PhoneNumberUser,ImgUser,IdLogin,Role) values (?,?,?,?,?,?);";

        String xNameUser, xPhoneNumberUser, xImgUser;
        xNameUser = u.getNameUser();
        xPhoneNumberUser = u.getPhoneNumberUser();
        xImgUser = u.getImgUser();
        int role = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xIdUser);
            ps.setString(2, xNameUser);
            ps.setString(3, xPhoneNumberUser);
            ps.setString(4, xImgUser);
            ps.setInt(5, xIdLogin);
            ps.setInt(6, role);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
        }
    }

    public void inserContact(int xIdLogin, int xIdContacts, String xNameContact, String xPhoneNumberContact) {
        xSql = "insert into Contacts (IdContacts,NameContact,PhoneNumberContact,IdLogin) values (?,?,?,?);";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xIdContacts);
            ps.setString(2, xNameContact);
            ps.setString(3, xPhoneNumberContact);
            ps.setInt(4, xIdLogin);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
        }
    }

    public int getMaxIdLogin() {
        xSql = "SELECT MAX(IdLogin) AS MaxIdLogin FROM Login;";
        int maxIdLoggin = 0;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxIdLoggin = rs.getInt("MaxIdLogin");
            }
        } catch (SQLException e) {
        }
        return maxIdLoggin;
    }

    public int getMaxIdUser() {
        xSql = "SELECT MAX(IdUser) AS MaxIdUser FROM Users;";
        int maxIdUser = 0;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxIdUser = rs.getInt("MaxIdUser");
            }
        } catch (SQLException e) {
        }
        return maxIdUser;
    }

    public int getMaxIdContacts() {
        xSql = "SELECT MAX(IdContacts) AS MaxIdContacts FROM Contacts;";
        int maxIdContacts = 0;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxIdContacts = rs.getInt("MaxIdContacts");
            }
        } catch (SQLException e) {
        }
        return maxIdContacts;
    }

    public List<Contact> getContacts(int xidLogin, String xSortColName, String xSortType) {
        List<Contact> list = new ArrayList<>();
        xSql = "select * from Contacts where IdLogin = " + xidLogin + " order by " + xSortColName + " " + xSortType;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xNameContact, xPhoneNumberContact;
            int xIdContacts, xIdLogin;
            Contact x;
            while (rs.next()) {
                xNameContact = rs.getString("NameContact");
                xPhoneNumberContact = rs.getString("PhoneNumberContact");
                xIdContacts = rs.getInt("IdContacts");
                xIdLogin = rs.getInt("IdLogin");
                x = new Contact(xNameContact, xPhoneNumberContact, xIdContacts, xIdLogin);
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return list;
    }

    public Contact getContactByName(int xidLogin, String xNameContact) {
        xSql = "select * from Contacts c where c.NameContact = ? and c.IdLogin = ?;";
        Contact c = new Contact();
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xNameContact);
            ps.setInt(2, xidLogin);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdContacts(rs.getInt("IdContacts"));
                c.setIdLogin(rs.getInt("IdLogin"));
                c.setNameContact(rs.getString("NameContact"));
                c.setPhoneNumberContact(rs.getString("PhoneNumberContact"));
            }
        } catch (SQLException e) {
        }
        return c;
    }
    public Contact getContactByIdContacts(int xidContacts) {
        xSql = "select * from Contacts c where c.IdContacts = ?;";
        Contact c = new Contact();
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xidContacts);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdContacts(rs.getInt("IdContacts"));
                c.setIdLogin(rs.getInt("IdLogin"));
                c.setNameContact(rs.getString("NameContact"));
                c.setPhoneNumberContact(rs.getString("PhoneNumberContact"));
            }
        } catch (SQLException e) {
        }
        return c;
    }

    public Contact getContactByPhoneNumber(int xidLogin, String xPhoneNumberContact) {
        xSql = "select * from Contacts c where c.PhoneNumberContact = ? and c.IdLogin = ?;";
        String xName;
        int xidContact;
        Contact c = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xPhoneNumberContact);
            ps.setInt(2, xidLogin);
            rs = ps.executeQuery();
            while (rs.next()) {
                xidContact = rs.getInt("IdContacts");
                xName = rs.getString("NameContact");
                c = new Contact(xName, xPhoneNumberContact, xidContact, xidLogin);
            }
        } catch (SQLException e) {
        }
        return c;
    }
      public void update(int idContact, Contact c) {
     xSql = "update Contacts set NameContact=?, PhoneNumberContact=? where IdContacts=?";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, c.nameContact);
        ps.setString(2, c.phoneNumberContact);
        ps.setInt(3, c.idContacts);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
      public void updateAdmin(int idLogin) {
     xSql = "update Users set Role = 1 where IdLogin = ?;";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setInt(1, idLogin);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
      public void deleteAdmin(int idLogin) {
     xSql = "update Users set Role = 0 where IdLogin = ?;";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setInt(1, idLogin);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
      public void changeName(int idLogin, String name) {
     xSql = "update Users set NameUser = ? where IdLogin = ?;";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, name);
        ps.setInt(2, idLogin);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
      public void changePhoneNumber(int idLogin, String phoneNumber) {
     xSql = "update Users set PhoneNumberUser = ? where IdLogin = ?;";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, phoneNumber);
        ps.setInt(2, idLogin);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
      public void changeImg(int idLogin, String img) {
     xSql = "update Users set ImgUser = ? where IdLogin = ?;";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, img);
        ps.setInt(2, idLogin);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
      public void changePassword(int idLogin, String password) {
     xSql = "update Login set LoginPassword = ? where IdLogin = ?;";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, password);
        ps.setInt(2, idLogin);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
        public void delete(int idContact) {
     xSql = "delete from Contacts where IdContacts=?";
     try {
        ps = con.prepareStatement(xSql);
        ps.setInt(1, idContact);
        ps.executeUpdate();
        //con.commit();
        ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
  }
        public void deleteUser(int idLoggin) {
     xSql = "delete from Users where IdLogin = ?;";
     try {
        ps = con.prepareStatement(xSql);
        ps.setInt(1, idLoggin);
        ps.executeUpdate();
        //con.commit();
        ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }}
        public void deleteAccount(int idLoggin) {
     xSql = "delete from Login where IdLogin = ?;";
     try {
        ps = con.prepareStatement(xSql);
        ps.setInt(1, idLoggin);
        ps.executeUpdate();
        //con.commit();
        ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
  }
}

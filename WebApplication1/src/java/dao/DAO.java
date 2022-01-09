/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLast() {
        String query = "select top 1 * from product\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Product> getProductByCate(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                        +"where cateID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Product getProductByid(String id) {
        String query = "select * from product\n"
                        +"where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
        }
       return null;
    }
    
        public List<Product> getProductByName(String name ){
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                        +"where name like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+name+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
        public Account login(String username, String password){
            
            String query = "select * from Account\n"
                            +"where [user] = ? "+"and pass =?";
             try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
            return null;   
        }
        
        public Account checkAccountbyName(String name) {
            String query = "select * from Account\n"
                        +"where [user] = ?";
            try {
                conn = new DBContext().getConnection();//mo ket noi voi sql
                ps = conn.prepareStatement(query);
                ps.setString(1, name);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
       return null;
    }
       
        public void sigup(String name, String password) {
            String query = "INSERT INTO [dbo].[Account]\n" +
                            "([user],[pass],[isSell],[isAdmin])\n" +
                            "VALUES(?,?,0,0) ";
            try {
                conn = new DBContext().getConnection();//mo ket noi voi sql
                ps = conn.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, password);
                rs = ps.executeQuery();
                
        } catch (Exception e) {
        }
 
    }
      public List<Product> getProductByisSell(int id ){
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                        +"where sell_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }      
      
      public void deleteProduct(String id) {
            String query = "Delete from product\n"
                        +"where id = ?";
            try {
                conn = new DBContext().getConnection();//mo ket noi voi sql
                ps = conn.prepareStatement(query);
                ps.setString(1, id);
                ps.executeUpdate();
                
        } catch (Exception e) {
        }
 
    }
      
      public void addProduct(String name ,String imge ,String price ,String title ,String description,String category, int sell_id ) {
            String query = "insert into [dbo].[product]\n" +
                            "([name],[image],[price],[title],[description],[cateID],[sell_ID])\n"+"values(?,?,?,?,?,?,?)";
            try {
                conn = new DBContext().getConnection();//mo ket noi voi sql
                ps = conn.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, imge);
                ps.setString(3, price);
                ps.setString(4, title);
                ps.setString(5, description);
                ps.setString(6, category);
                ps.setInt(7, sell_id);
                ps.executeUpdate();
        } catch (Exception e) {
        }
 
    }
      public void updateProduct(String id,String name ,String imge ,String price ,String title ,String description,String category) {
            String query = "UPDATE [dbo].[product]\n" +
                            "   SET [name] = ?\n" +
                            "      ,[image] = ?\n" +
                            "      ,[price] = ?\n" +
                            "      ,[title] = ?\n" +
                            "      ,[description] = ?\n" +
                            "      ,[cateID] = ?\n" +
                            " WHERE id = ?";
            try {
                conn = new DBContext().getConnection();//mo ket noi voi sql
                ps = conn.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, imge);
                ps.setString(3, price);
                ps.setString(4, title);
                ps.setString(5, description);
                ps.setString(6, category);
                ps.setString(7, id);
                ps.executeUpdate();
        } catch (Exception e) {
        }
 
    }
      
      public void addBill(int id,int idUser, int amount, LocalDate dateBuy) {
            String query = "INSERT INTO [dbo].[Cart]\n" +
                            "([userID]\n" +
                            ",[ProductID]\n" +
                            ",[amount]\n" +
                            ",[dateBuy])\n" +
                            "VALUES(?,?,?,?)" ;
            try {
                conn = new DBContext().getConnection();//mo ket noi voi sql
                ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ps.setInt(2, idUser);
                ps.setInt(3, amount);
                ps.setDate(4,Date.valueOf(dateBuy));
                ps.executeUpdate();
        } catch (Exception e) {
        }
 
    }
    
      public int getCount(){
      
          String query = "SELECT count(id) FROM product";
          int count =0;
          try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
          } catch (Exception e) {
          }
          return count;
      }
      
       public int getCountProbyCate(String id){
      
          String query = "SELECT count(id) FROM product where cateID =?";
          int count =0;
          try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
          } catch (Exception e) {
          }
          return count;
      }
      
      public List<Product> pageListProduct(int index) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product order by id offset ? rows fetch next 6 rows only ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index-1)*3);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
      
      public List<Product> pageListProductByCate(String id, int index) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where cateID = ? order by id offset ? rows fetch next 3 rows only ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setInt(2, (index-1)*3);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
      
    public static void main(String[] args) {
        DAO dao = new DAO();
       // dao.updateProduct("23","okeádas", "okeádas", "100", "okr", "oke", "1");
        List<Product> list = dao.getAllProduct();
        List<Category> listC = dao.getAllCategory();
        List<Product> listp = dao.pageListProductByCate("1",2);       
        for (Product o : listp) {
            System.out.println(o);
        }
        //dao.sigup("admin123", "123");
        //System.out.println(dao.getProductByid("2"));
       // System.out.println(dao.login("Adam", "123456"));
       //dao.addBill(1, 1, 1, LocalDate.now());
       // System.out.println(dao.getCount());
    }

}

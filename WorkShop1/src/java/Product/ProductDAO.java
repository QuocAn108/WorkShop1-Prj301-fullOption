/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import User.UserDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lienm
 */
public class ProductDAO {

    private static final String SEARCHALL = "SELECT * FROM tbl_Mobile";
    private static final String SEARCHN = "SELECT * FROM tbl_Mobile WHERE mobileName like ?";
    private static final String SEARCHID = "SELECT * FROM tbl_Mobile WHERE mobileID like ?";
    private static final String SEARCHMINMAX = "SELECT * FROM tbl_Mobile WHERE Price BETWEEN ? AND ?";
    private static final String DELETE = "DELETE tbl_Mobile WHERE mobileID=?";
    private static final String UPDATE = "UPDATE tbl_Mobile SET  Description=?,Price=?,Quantity=?,notSale=? WHERE mobileID=?";
    private static final String INSERT = "INSERT INTO tbl_Mobile(mobileID,Description,Price,mobileName,yearOfProduction,Quantity,notSale) "
            + "                         VALUES(?,?,?,?,?,?,?)";
    private static final String INSERT_WHISTLIST = "INSERT INTO tbl_WhistList(mobileID,Description,Price,mobileName,yearOfProduction,Quantity,notSale) "
            + "                         VALUES(?,?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT mobileID FROM tbl_Mobile WHERE mobileID=?  ";
    private static final String CHECK_DUPLICATE1 = "SELECT mobileID FROM tbl_WhistList WHERE mobileID=?  ";
    private static final String DELETE1 = "DELETE tbl_WhistList WHERE mobileID=?";

    public List<ProductDTO> getListProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(SEARCHALL);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String mobileID = rs.getString("mobileID");
                    String Description = rs.getString("Description");
                    float Price = rs.getFloat("Price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int Quantity = rs.getInt("Quantity");
                    int notSale = rs.getInt("notSale");

                    ProductDTO b = new ProductDTO(mobileID, Description, Price, mobileName, yearOfProduction, Quantity, notSale);
                    list.add(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean checkDuplicate(String mobileID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, mobileID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean checkDuplicate1(String mobileID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE1);
                ptm.setString(1, mobileID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public List<ProductDTO> getListProductByName(String name) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCHN);
                ptm.setString(1, "%" + name + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String mobileID = rs.getString("mobileID");
                    String Description = rs.getString("Description");
                    float Price = rs.getFloat("Price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int Quantity = rs.getInt("Quantity");
                    int notSale = rs.getInt("notSale");
                    list.add(new ProductDTO(mobileID, Description, Price, mobileName, yearOfProduction, Quantity, notSale));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getListProductByID(String ID) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCHID);
                ptm.setString(1, ID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String mobileID = rs.getString("mobileID");
                    String Description = rs.getString("Description");
                    float Price = rs.getFloat("Price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int Quantity = rs.getInt("Quantity");
                    int notSale = rs.getInt("notSale");
                    list.add(new ProductDTO(mobileID, Description, Price, mobileName, yearOfProduction, Quantity, notSale));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getListProductByPriceMinMax(float min, float max) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCHMINMAX);
                ptm.setFloat(1, min);
                ptm.setFloat(2, max);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String mobileID = rs.getString("mobileID");
                    String Description = rs.getString("Description");
                    float Price = rs.getFloat("Price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int Quantity = rs.getInt("Quantity");
                    int notSale = rs.getInt("notSale");
                    list.add(new ProductDTO(mobileID, Description, Price, mobileName, yearOfProduction, Quantity, notSale));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean delete(String mobileID) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, mobileID);
                checkDelete = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkDelete;
    }

    public boolean delete1(String mobileID) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE1);
                ptm.setString(1, mobileID);
                checkDelete = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkDelete;
    }

    public boolean update(ProductDTO product) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, product.getDescription());
                ptm.setFloat(2, product.getPrice());
                ptm.setInt(3, product.getQuantity());
                ptm.setInt(4, product.getNotSale());
                ptm.setString(5, product.getMobileID());
                checkUpdate = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkUpdate;
    }

    public boolean insert(ProductDTO product) throws SQLException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, product.getMobileID());
                ptm.setString(2, product.getDescription());
                ptm.setFloat(3, product.getPrice());
                ptm.setString(4, product.getMobileName());
                ptm.setInt(5, product.getYearOfProduction());
                ptm.setInt(6, product.getQuantity());
                ptm.setInt(7, product.getNotSale());
                checkInsert = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkInsert;
    }

    public boolean insertLIST(ProductDTO product) throws SQLException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_WHISTLIST);
                ptm.setString(1, product.getMobileID());
                ptm.setString(2, product.getDescription());
                ptm.setFloat(3, product.getPrice());
                ptm.setString(4, product.getMobileName());
                ptm.setInt(5, product.getYearOfProduction());
                ptm.setInt(6, product.getQuantity());
                ptm.setInt(7, product.getNotSale());
                checkInsert = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkInsert;
    }

}

package com.student.grocerystore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Crud {
    public static void createTable_Products(Connection conn, String table_name){
        Statement statement;
        try{
            String query="CREATE TABLE IF NOT EXISTS public.\"Products\"\n" + "    (\n" +
                    "        product_id integer NOT NULL,\n" +
                    "        product_name text COLLATE pg_catalog.\"default\",\n" +
                    "        product_quantity integer,\n" +
                    "        product_price integer,\n" +
                    "        CONSTRAINT \"Products_pkey\" PRIMARY KEY (product_id)\n" +
                    "    )\n" + "    TABLESPACE pg_default;\n" +
                    "\n" + "ALTER TABLE IF EXISTS public.\"Products\"\n" +
                    "    OWNER to postgres;";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void createTable_Sales(Connection conn, String table_name){
        Statement statement;
        try{
            String query="CREATE TABLE IF NOT EXISTS public.\"Sales\"\n" +
                    "(\n" +
                    "    sale_id integer NOT NULL,\n" +
                    "    date text  COLLATE pg_catalog.\"default\",\n" +
                    "    user_id integer NOT NULL,\n" +
                    "    product_id integer NOT NULL,\n" +
                    "    payment text COLLATE pg_catalog.\"default\",\n" +
                    "    CONSTRAINT \"Sales_pkey\" PRIMARY KEY (sale_id)\n" +
                    ")\n" +
                    "\n" +
                    "TABLESPACE pg_default;\n" +
                    "\n" +
                    "ALTER TABLE IF EXISTS public.\"Sales\"\n" +
                    "    OWNER to postgres;";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void createTable_Users(Connection conn, String table_name){
        Statement statement;
        try{
            String query="CREATE TABLE IF NOT EXISTS public.\"Users\"\n" +
                    "(\n" +
                    "    user_id integer NOT NULL,\n" +
                    "    \"Name\" \"text\",\n" +
                    "    \"E-mail\" \"text\",\n" +
                    "    \"Password\" \"text\",\n" +
                    "    \"Role\" \"text\",\n" +
                    "    CONSTRAINT \"Users_pkey\" PRIMARY KEY (user_id)\n" +
                    ")\n" +
                    "\n" +
                    "TABLESPACE pg_default;\n" +
                    "\n" +
                    "ALTER TABLE IF EXISTS public.\"Users\"\n" +
                    "    OWNER to postgres;";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void createTable_ProductDiscount(Connection conn, String table_name){
        Statement statement;
        try{
            String query="CREATE TABLE IF NOT EXISTS public.\"Product Discount\"\n" +
                    "(\n" +
                    "    discount_id integer NOT NULL,\n" +
                    "    discount_amount integer,\n" +
                    "    start_date text,\n" +
                    "    end_date text,\n" +
                    "    product_id integer NOT NULL,\n" +
                    "    CONSTRAINT \"Product Discount_pkey\" PRIMARY KEY (discount_id)\n" +
                    ")\n" +
                    "\n" +
                    "TABLESPACE pg_default;\n" +
                    "\n" +
                    "ALTER TABLE IF EXISTS public.\"Product Discount\"\n" +
                    "    OWNER to postgres;";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void insertRow_users(Connection conn, Integer user_id, String Name, String Email, String Password, String Role){
        Statement statement;
        try {
            String query=String.format("INSERT INTO public.\"Users\"" +
                    " (user_id, \"Name\"," + " \"E-mail\", \"Password\"," + " \"Role\")" +
                    " VALUES (%d, '%s', '%s', '%s', '%s');", user_id, Name, Email, Password, Role);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void insertRow_Sales(Connection conn, Integer sale_id, String date,Integer user_id, Integer product_id, String payment){
        Statement statement;
        try {
            String query=String.format("INSERT INTO public.\"Sales\"" + " " +
                    "(sale_id, date, user_id, product_id, payment)" +
                    " VALUES (%d, '%s', %d, %d, '%s');", sale_id, date, user_id, product_id, payment);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void insertRow_Products(Connection conn,Integer product_id,Integer product_quantity,String product_name, Integer product_price){
        Statement statement;
        try {
            String query=String.format("INSERT INTO public.\"Products\"" + " " +
                    "(product_id, product_name, product_quantity, product_price)" +
                    " VALUES (%d, '%s', %d, %d);", product_id, product_name, product_quantity, product_price);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void insertRow_ProductDiscount(Connection conn, Integer discount_id, Integer discount_amount, String  start_date, String end_date, Integer product_id){
        Statement statement;
        try {
            String query=String.format("INSERT INTO public.\"Product Discount\"" + " " +
                    "(discount_id, discount_amount, start_date, end_date, product_id)" +
                    " VALUES (%d, %d, '%s', '%s', %d);",
                    discount_id, discount_amount, start_date, end_date, product_id);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs=null;

        try {
            String query=String.format("select * from %s",table_name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            System.out.println(query);
            while(rs.next()){
                System.out.print("Empid:" + rs.getString("empid")+" ");
                System.out.print("Product:" +rs.getString("name")+" ");
                System.out.println("Price:" +rs.getString("price")+" ");
            }

        }
        catch (Exception e){
            System.out.println(e);
        }

    }public static String[] read_username(Connection conn) {
        Statement statement;
        ResultSet rs = null;

        String Role;
        String name;
        String password;
        String[] login = new String[0];
        try {
            String query = String.format("select * from %s", "Users");
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            System.out.println(query);
            while (rs.next()) {
                name = rs.getString("name");
                Role = rs.getString("role");
                password = rs.getString("password");
                login = new String[]{name, Role, password};
                System.out.println(login[0] + " " + login[1] + " " + login[2]);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return login;
    }



    public void update_name(Connection conn,String table_name, String old_name,String new_name){
        Statement statement;
        try {
            String query=String.format("update %s set name='%s' where name='%s'",table_name,new_name,old_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void update_amount(Connection conn,String table_name, String old_amount,String new_amount){
        Statement statement;
        try {
            String query=String.format("update %s set productprice='%s' where productprice='%s'",table_name,new_amount,old_amount);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void search_by_name(Connection conn, String table_name,String name){
        Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("select * from %s where name= '%s'",table_name,name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address"));

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static ArrayList<Integer> search_by_id(Connection conn, String table_name, int id) throws SQLException {
        Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("select * from %s where productid= %s",table_name,id);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("productid")+" ");
              //  System.out.print(rs.getString("productname")+" ");
                //System.out.println(rs.getString("productprice"));

            }
        }catch (Exception e){
            System.out.println(e);
        }
        Integer productid;
        Integer productprice;
        ArrayList<Integer> productid_list = new ArrayList<Integer>();
        productid = Integer.valueOf(rs.getString("productid"));
        productprice = Integer.valueOf(rs.getString("productprice"));
        productid_list.add(productid);
        productid_list.add(productprice);
       /* try {

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return productid_list;

    }

    public static void delete_row_by_name(Connection conn,String table_name, String name){
        Statement statement;
        try{
            String query=String.format("DELETE FROM %s WHERE NAME='%s'",table_name,name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    // delete_row_by_name
    public static void delete_row_by_id(Connection conn,String table_name, int id){
        Statement statement;
        try{
            String query=String.format("DELETE FROM %s WHERE productid=%d",table_name,id);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public void delete_table(Connection conn, String table_name){
        Statement statement;
        try {
            String query= String.format("drop table %s",table_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
